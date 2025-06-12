package finalmission.infrastructure.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {

    private final JwtProperties jwtProperties;

    public JwtTokenProvider(final JwtProperties jwtProperties) {
        this.jwtProperties = jwtProperties;
    }

    public String createToken(String payload) {
        return Jwts.builder()
                .setSubject(payload)
                .setExpiration(new Date(jwtProperties.validTime()))
                .signWith(Keys.hmacShaKeyFor(jwtProperties.secretKey().getBytes(StandardCharsets.UTF_8)))
                .compact();
    }
}
