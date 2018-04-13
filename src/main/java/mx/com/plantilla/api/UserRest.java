package mx.com.plantilla.api;

import mx.com.plantilla.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Map;

/**
 * Created by dzuniga on 12/04/2018.
 */
@Component
@Path("/user")
public class UserRest {
    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @GET
    @Path("/{token}")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, String> getInfo(@PathParam("token") String token){
        return userService.getUserInfo(token);
    }
}
