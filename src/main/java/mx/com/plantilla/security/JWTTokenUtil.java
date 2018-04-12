package mx.com.plantilla.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by dzuniga on 12/04/2018.
 * Esta libreria nos permite decodificar el token para obtener datos del usuario
 */

@Component
public class JWTTokenUtil {
    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.tokenPrefix}")
    private String bearer;

    public String getUsernameFromToken(String token) {
        String username;
        try {
            final Claims claims = getClaimsFromToken(token);
            username = claims.getSubject();
        } catch (Exception e) {
            username = null;
        }
        return username;
    }

    private Claims getClaimsFromToken(String token) {
        Claims claims;
        String authToken = token.replace(bearer, "").trim();
        try {
            claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(authToken)
                    .getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }
}
