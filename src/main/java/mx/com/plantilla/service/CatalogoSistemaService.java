package mx.com.plantilla.service;

import mx.com.plantilla.dao.CatalogoSistemaDao;
import mx.com.plantilla.model.CatalogoSistema;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by dzuniga on 15/03/2017.
 */
@Service
@Transactional(readOnly = true)
public class CatalogoSistemaService {
    final static Logger logger = Logger.getLogger(CatalogoSistema.class);

    @Autowired
    @Qualifier(value = "catalogoSistemaDao")
    private CatalogoSistemaDao catalogoSistemaDao;

    public List<CatalogoSistema> list() {
        CatalogoSistema catalogoSistema = new CatalogoSistema();
        return (List<CatalogoSistema>) catalogoSistemaDao.findAll(catalogoSistema);
    }

    public CatalogoSistema id(Long id) {
        return (CatalogoSistema) catalogoSistemaDao.findById(id);
    }
}
