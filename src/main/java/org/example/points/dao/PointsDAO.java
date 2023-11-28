package org.example.points.dao;

import org.example.HibernateUtil;
import org.example.points.entities.Points;
import org.hibernate.LockMode;
import org.hibernate.Session;

import java.util.UUID;

public class PointsDAO {

    public Points get(UUID id) {
        return HibernateUtil.getSessionFactory()
                .getCurrentSession()
                .get(Points.class, id, LockMode.PESSIMISTIC_READ);
    }


    public UUID add(Points point) {
        return (UUID) HibernateUtil.getSessionFactory()
                .getCurrentSession()
                .save(point);
    }


    public void update(Points point) {
        HibernateUtil.getSessionFactory().getCurrentSession()
                .update(point);
    }


    public Points delete(UUID id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Points point = session.byId(Points.class).load(id);
        session.delete(point);
        return point;
    }


}
