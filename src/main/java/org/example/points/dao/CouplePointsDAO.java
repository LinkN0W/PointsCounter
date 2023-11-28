package org.example.points.dao;

import org.example.HibernateUtil;
import org.example.points.entities.CouplePoints;
import org.example.points.entities.Points;
import org.hibernate.LockMode;
import org.hibernate.Session;

import java.util.UUID;

public class CouplePointsDAO {

    public CouplePoints get(UUID id) {
        return HibernateUtil.getSessionFactory()
                .getCurrentSession()
                .get(CouplePoints.class, id, LockMode.PESSIMISTIC_READ);
    }


    public UUID add(CouplePoints couplePoints) {
        return (UUID) HibernateUtil.getSessionFactory()
                .getCurrentSession()
                .save(couplePoints);
    }


    public void update(CouplePoints couplePoints) {
        HibernateUtil.getSessionFactory().getCurrentSession()
                .update(couplePoints);
    }


    public CouplePoints delete(UUID id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        CouplePoints couplePoints = session.byId(CouplePoints.class).load(id);
        session.delete(couplePoints);
        return couplePoints;
    }
}
