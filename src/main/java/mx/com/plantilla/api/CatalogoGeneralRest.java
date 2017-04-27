package mx.com.plantilla.api;

import mx.com.plantilla.model.CatalogoGeneral;
import mx.com.plantilla.service.CatalogoGeneralService;
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
 * Created by dzuniga on 27/04/2017.
 */
@Component
@Path("/catalogoGeneral")
public class CatalogoGeneralRest {
    @Autowired
    @Qualifier(value = "catalogoGeneralService")
    private CatalogoGeneralService catalogoGeneralService;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<CatalogoGeneral> list() {
        return catalogoGeneralService.list();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public CatalogoGeneral id(@PathParam("id") Long id) {
        return catalogoGeneralService.id(id);
    }
}
