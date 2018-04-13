package mx.com.plantilla.dao.impl;

import mx.com.plantilla.dao.GenericDao;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

/**
 * Created by dzuniga on 17/03/2017.
 */
public class GenericDaoImpl<T extends Serializable, PK extends Serializable> implements GenericDao<T,PK> {
    private Class<T> entityClass;

    @PersistenceContext
    private EntityManager entityManager;

    public GenericDaoImpl(Class<T> entityClass){
        this.entityClass = entityClass;
    }

    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }

    @Override
    public T save(T t) {
        entityManager.persist(t);
        return t;
    }

    @Override
    public T findById(PK id) {
        return entityManager.find(entityClass, id);
    }

    @Override
    public List<T> findAll(T t) {
        return entityManager.createQuery("Select t from " + entityClass.getSimpleName() + " t").getResultList();
    }

    @Override
    public T get(T t) {
        List<T> list = findAll(t);

        if (list != null && !list.isEmpty()) {
            return list.get(0);
        } else {
            return null;
        }
    }
}
