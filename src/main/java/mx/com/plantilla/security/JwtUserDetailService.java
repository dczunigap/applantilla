package mx.com.plantilla.security;

import mx.com.plantilla.dao.UsuarioDao;
import mx.com.plantilla.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by dzuniga on 13/04/2018.
 */
@Service
public class JwtUserDetailService implements UserDetailsService {

    @Autowired
    @Qualifier(value = "usuarioDao")
    UsuarioDao usuarioDao;

    @Override
    public UserDetails loadUserByUsername(String usuarioLogin) throws UsernameNotFoundException {
        if (usuarioLogin == null || usuarioLogin.equals("")) {
            return new JwtUser();
        }

        Usuario usuario = new Usuario();
        usuario.setUsername(usuarioLogin);

        usuario = (Usuario) usuarioDao.get(usuario);

        if (usuario != null && usuario.getId() != null && usuario.getUsername().equals(usuarioLogin)) {
            List<GrantedAuthority> authorities = new ArrayList<>();

            JwtUser user = new JwtUser(
                    usuario.getId(),
                    usuario.getUsername(),
                    "_",
                    "_",
                    "desconocido@gmail.com",
                    usuario.getPassword(),
                    Collections.emptyList(),
                    true,
                    null
                    );
            return user;
        } else {
            throw new BadCredentialsException(String.format("El usuario %s no existe ", usuarioLogin));
        }
    }
}
