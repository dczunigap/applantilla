package mx.com.plantilla.dao.impl;

import mx.com.plantilla.dao.CatalogoSistemaDao;
import mx.com.plantilla.model.CatalogoSistema;
import org.springframework.stereotype.Repository;

/**
 * Created by dzuniga on 16/03/2017.
 */
@Repository(value = "catalogoSistemaDao")
public class CatalogoSistemaDaoImpl extends GenericDaoImpl implements CatalogoSistemaDao {
    public CatalogoSistemaDaoImpl() {
        super(CatalogoSistema.class);
    }
    /*@Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }*/
}
