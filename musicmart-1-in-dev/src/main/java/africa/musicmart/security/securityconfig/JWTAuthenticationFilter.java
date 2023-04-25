package africa.musicmart.security.securityconfig;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JWTAuthenticationFilter extends OncePerRequestFilter {

    private final JWTTokenProvider jwtTokenProvider;
    private final CustomerDetailService customUserDetailService;

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest httpServletRequest,
                                    @NonNull HttpServletResponse httpServletResponse,
                                    @NonNull FilterChain filterChain) throws ServletException, IOException {
        String email = null;
        String jwtToken = getJwtTokenFromRequest(httpServletRequest);

        if (jwtToken != null) {
            email = jwtTokenProvider.extractEmail(jwtToken);
        }

        if (email != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = customUserDetailService.loadUserByUsername(email);

            if (jwtTokenProvider.validateToken(jwtToken, userDetails)) {
                UsernamePasswordAuthenticationToken authenticationToken =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            } else {
                httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            }
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

    private String getJwtTokenFromRequest(HttpServletRequest httpServletRequest) {
        String authorizationHeader = httpServletRequest.getHeader("Authorization");
        String jwt = null;

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            jwt = authorizationHeader.substring(7);
        }
        return jwt;
    }
}
