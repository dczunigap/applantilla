package mx.com.plantilla.service;

import mx.com.plantilla.dao.CatalogoGeneralDao;
import mx.com.plantilla.model.CatalogoGeneral;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by dzuniga on 27/04/2017.
 */
@Service
@Transactional(readOnly = true)
public class CatalogoGeneralService {

    @Autowired
    @Qualifier(value = "catalogoGeneralDao")
    private CatalogoGeneralDao catalogoGeneralDao;

    public List<CatalogoGeneral> list() {
        CatalogoGeneral catalogoSistema = new CatalogoGeneral();
        return (List<CatalogoGeneral>) catalogoGeneralDao.findAll(catalogoSistema);
    }

    public CatalogoGeneral id(Long id) {
        return (CatalogoGeneral) catalogoGeneralDao.findById(id);
    }
}
