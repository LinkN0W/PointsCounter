package org.example.logger.dao;

import org.example.HibernateUtil;
import org.example.logger.entities.Logger;

import org.hibernate.LockMode;

import java.util.UUID;

public class LoggerDAO {

    public Logger get(UUID id) {
        return HibernateUtil.getSessionFactory()
                .getCurrentSession()
                .get(Logger.class, id, LockMode.PESSIMISTIC_READ);
    }

    public Iterable<Logger> getAll() {
        return HibernateUtil.getSessionFactory()
                .getCurrentSession().createQuery("From " + Logger.class.getSimpleName()).getResultList();

    }


    public UUID add(Logger logger) {
        return (UUID) HibernateUtil.getSessionFactory()
                .getCurrentSession()
                .save(logger);
    }

}
