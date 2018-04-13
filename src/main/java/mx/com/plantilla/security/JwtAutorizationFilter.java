package mx.com.plantilla.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.util.Collections.emptyList;

/**
 * Created by dzuniga on 03/05/2017.
 */
public class JwtAutorizationFilter extends BasicAuthenticationFilter {

    @Value("${jwt.header}")
    private String HEADER_STRING;

    @Value("${jwt.tokenPrefix}")
    private String TOKEN_PREFIX;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Qualifier("jwtUserDetailService")
    @Autowired
    JwtUserDetailService jwtUserDetailService;

    public JwtAutorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader(HEADER_STRING);

        if (token == null || !token.startsWith(TOKEN_PREFIX)) {
            filterChain.doFilter(request, response);
            return;
        }

        String user = jwtTokenUtil.getUsernameFromToken(token);

        if(user!=null && SecurityContextHolder.getContext().getAuthentication() == null){
            //No es necesario ya que puede colocarse los datos del usuario en el token
            JwtUser userDetails = (JwtUser) jwtUserDetailService.loadUserByUsername(user);

            if (jwtTokenUtil.validateToken(token, userDetails)) {
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(user, null, emptyList());
                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }

        filterChain.doFilter(request, response);
    }
}