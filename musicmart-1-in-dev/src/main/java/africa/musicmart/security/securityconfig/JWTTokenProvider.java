package africa.musicmart.security.securityconfig;

import africa.musicmart.security.securityconfig.UserPrincipal;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JWTTokenProvider {

    @Value("${JWT_SECRET_KEY}")
    private String SECRET_KEY;
    @Value("${TOKEN_EXPIRATION}")
    private String tokenExpiration;

    public String generateToken(String email) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, email);
    }
    public String createToken(Authentication authentication) {
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        return generateToken(userPrincipal.getEmail());
    }

    private String createToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims).setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
//                // Jwt expiration time is 10hr after jwt is issued
                .setExpiration(new Date(System.currentTimeMillis() + tokenExpiration))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public String extractEmail(String jwtToken) {
        return extractClaim(jwtToken, Claims::getSubject);
    }

    private <T> T extractClaim(String jwtToken, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaim(jwtToken);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaim(String jwtToken) {
        return Jwts.parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(jwtToken)
                .getBody();
    }

    private Key getSignInKey() {
        byte [] key = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(key);
    }
    public boolean validateToken(String token, UserDetails user) {
        final String email = extractEmail(token);
        return (email.equals(user.getUsername()) && !isTokenExpired(token));
    }

    public boolean isTokenExpired(String token) {
        return extractExpirationDate(token).before(new Date(System.currentTimeMillis()));
    }

    private Date extractExpirationDate(String token) {
        return extractClaim(token, Claims::getExpiration);
    }
}
