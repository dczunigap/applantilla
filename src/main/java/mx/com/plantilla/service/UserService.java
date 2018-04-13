package mx.com.plantilla.service;

import mx.com.plantilla.security.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dzuniga on 12/04/2018.
 */
@Service
@Transactional(readOnly = true)
public class UserService {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    public Map<String, String> getUserInfo(String token) {
        Map<String, String> respuesta = new HashMap<>();
        respuesta.put("username", jwtTokenUtil.getUsernameFromToken(token));

        return respuesta;
    }
}
