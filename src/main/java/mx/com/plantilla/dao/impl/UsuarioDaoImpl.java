package mx.com.plantilla.dao.impl;

import mx.com.plantilla.dao.UsuarioDao;
import mx.com.plantilla.model.Usuario;
import org.springframework.stereotype.Repository;

/**
 * Created by dzuniga on 13/04/2018.
 */
@Repository(value = "usuarioDao")
public class UsuarioDaoImpl extends GenericDaoImpl implements UsuarioDao {
    public UsuarioDaoImpl() {
        super(Usuario.class);
    }
}
