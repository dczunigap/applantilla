package mx.com.plantilla.dao.impl;

import mx.com.plantilla.dao.CatalogoGeneralDao;
import mx.com.plantilla.model.CatalogoGeneral;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by dzuniga on 27/04/2017.
 */
@Repository(value = "catalogoGeneralDao")
public class CatalogoGeneralDaoImpl extends GenericDaoImpl implements CatalogoGeneralDao {
    public CatalogoGeneralDaoImpl() {
        super(CatalogoGeneral.class);
    }
}
