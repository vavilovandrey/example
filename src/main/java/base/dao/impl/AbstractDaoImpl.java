package base.dao.impl;

import base.dao.AbstractDao;
import base.data.Identifiable;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public abstract class AbstractDaoImpl<KEY extends Serializable, ENTITY extends Identifiable> implements AbstractDao<KEY, ENTITY> {

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    protected void flushSession() {
        getSession().flush();
    }

    protected void clearSession() {
        getSession().clear();
    }

    @Override
    public ENTITY saveOrUpdate(ENTITY entity) {
        if (entity.isNew()) {
            getSession().save(entity);
        } else {
            getSession().update(entity);
        }
        return entity;
    }

    protected abstract Class<ENTITY> getEntityClass();

    @Override
    public ENTITY get(String id) {
        return (ENTITY) getSession().get(getEntityClass(), id);
    }

    @Override
    public boolean isExist(KEY id) {
        return getSession().createCriteria(getEntityClass())
                .setProjection(Projections.id())
                .setMaxResults(1)
                .uniqueResult() != null;
    }
}
