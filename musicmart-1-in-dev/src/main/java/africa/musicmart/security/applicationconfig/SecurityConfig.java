package africa.musicmart.security.applicationconfig;

import africa.musicmart.security.securityconfig.JWTAuthenticationEntryPoint;
import africa.musicmart.security.securityconfig.JWTAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final JWTAuthenticationEntryPoint unauthorizedHandler;
    private final JWTAuthenticationFilter jwtAuthenticationFilter;
    private final AuthenticationProvider authenticationProvider;

    private static final String[] AUTH_WHITELIST = {
            "/login",
            "/signup",
            "/forgotPassword",
            "confirmToken",
            "/api/v1/user/**",
            "/oauth2/**",
            "/authenticate",
            "/swagger-resources/**",
            "/swagger-ui/**",
            "/v3/api-docs/**",
            "/webjars/**",
            "/api/v1/demo/**"
    };

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .cors()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .csrf()
                .disable()
                .exceptionHandling()
                .authenticationEntryPoint(unauthorizedHandler)
                .and()
                .authorizeHttpRequests()
                .requestMatchers(AUTH_WHITELIST)
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling()
                .authenticationEntryPoint(unauthorizedHandler);
        return http.build();
    }
}