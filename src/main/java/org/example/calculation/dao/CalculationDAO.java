package org.example.calculation.dao;

import org.example.HibernateUtil;
import org.example.calculation.entities.Calculation;
import org.example.points.entities.Points;
import org.hibernate.LockMode;
import org.hibernate.Session;

import java.util.UUID;

public class CalculationDAO {


    public Calculation get(UUID id) {
        return HibernateUtil.getSessionFactory()
                .getCurrentSession()
                .get(Calculation.class, id, LockMode.PESSIMISTIC_READ);
    }


    public UUID add(Calculation calculation) {
        return (UUID) HibernateUtil.getSessionFactory()
                .getCurrentSession()
                .save(calculation);
    }


    public void update(Calculation calculation) {
        HibernateUtil.getSessionFactory().getCurrentSession()
                .update(calculation);
    }


    public Calculation delete(UUID id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Calculation calculation = session.byId(Calculation.class).load(id);
        session.delete(calculation);
        return calculation;
    }

}
