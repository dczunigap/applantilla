package mx.com.plantilla.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import mx.com.plantilla.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

/**
 * Created by dzuniga on 03/05/2017.
 */
public class JwtAuthenticationLoginFilter extends UsernamePasswordAuthenticationFilter {
    @Value("${jwt.tokenPrefix}")
    final String TOKEN_PREFIX = "Bearer";

    @Value("${jwt.header}")
    final String HEADER_STRING = "Authorization";

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    public JwtAuthenticationLoginFilter(AuthenticationManager authManager) {
        setAuthenticationManager(authManager);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res) throws AuthenticationException {
        try {
            Usuario creds = new ObjectMapper().readValue(req.getInputStream(), Usuario.class);
            return getAuthenticationManager().authenticate(
                    new UsernamePasswordAuthenticationToken(
                            creds.getUsername(),
                            creds.getPassword(),
                            Collections.emptyList()
                    )
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain, Authentication auth) {
        SecurityContextHolder.getContext().setAuthentication(auth);
        String JWT = jwtTokenUtil.generateToken(auth.getName());
        res.addHeader(HEADER_STRING, TOKEN_PREFIX.concat(" ").concat(JWT));
    }
}
