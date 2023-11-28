package org.example.launch.dao;

import org.example.HibernateUtil;
import org.example.launch.entities.Launch;
import org.example.points.entities.Points;
import org.hibernate.LockMode;
import org.hibernate.Session;

import java.util.UUID;

public class LaunchDAO {

    public Launch get(UUID id) {
        return HibernateUtil.getSessionFactory()
                .getCurrentSession()
                .get(Launch.class, id, LockMode.PESSIMISTIC_READ);
    }


    public UUID add(Launch launch) {
        return (UUID) HibernateUtil.getSessionFactory()
                .getCurrentSession()
                .save(launch);
    }


    public void update(Launch launch) {
        HibernateUtil.getSessionFactory().getCurrentSession()
                .update(launch);
    }


    public Launch delete(UUID id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Launch launch = session.byId(Launch.class).load(id);
        session.delete(launch);
        return launch;
    }



}
