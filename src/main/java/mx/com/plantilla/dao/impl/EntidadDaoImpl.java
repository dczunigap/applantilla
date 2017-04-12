package mx.com.plantilla.dao.impl;

import mx.com.plantilla.dao.EntidadDao;
import mx.com.plantilla.model.Entidad;
import org.springframework.stereotype.Repository;

/**
 * Created by dzuniga on 17/03/2017.
 */
@Repository(value = "entidadDao")
public class EntidadDaoImpl extends GenericDaoImpl implements EntidadDao {
    public EntidadDaoImpl() {
        super(Entidad.class);
    }
}
