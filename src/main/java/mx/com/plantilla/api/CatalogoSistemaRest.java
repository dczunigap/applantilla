package mx.com.plantilla.api;

import mx.com.plantilla.model.CatalogoSistema;
import mx.com.plantilla.service.CatalogoSistemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by dzuniga on 15/03/2017.
 */
@Component
@Path("/catalogoSistema")
public class CatalogoSistemaRest {

    @Autowired
    @Qualifier(value = "catalogoSistemaService")
    private CatalogoSistemaService catalogoSistemaService;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<CatalogoSistema> list() {
        return catalogoSistemaService.list();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public CatalogoSistema id(@PathParam("id") Long id) {
        return catalogoSistemaService.id(id);
    }

    /*@GET
    @Path("/{codigo}")
    @Produces(MediaType.APPLICATION_JSON)
    public CatalogoSistema id(@PathParam("codigo") String codigo) {
        return catalogoSistemaService.listByCode(codigo);
    }*/
}
