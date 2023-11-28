package org.example.logger;

import javax.persistence.*;
import org.example.calculation.dao.CalculationDAO;
import org.example.launch.dao.LaunchDAO;
import org.example.logger.dao.LoggerDAO;
import org.example.logger.entities.Logger;
import org.example.points.dao.CouplePointsDAO;
import org.example.points.dao.PointsDAO;
import org.example.points.entities.CouplePoints;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;


public class LoggerService {


    private final PointsDAO pointsDAO;
    private final LaunchDAO launchDAO;

    private final CouplePointsDAO couplePointsDAO;

    private final CalculationDAO calculationDAO;

    private final LoggerDAO loggerDAO;

    LoggerService(){
        pointsDAO = new PointsDAO();
        launchDAO = new LaunchDAO();
        calculationDAO = new CalculationDAO();
        couplePointsDAO = new CouplePointsDAO();
        loggerDAO = new LoggerDAO();
    }

    public void addLogger(Logger logger)  {
        Transaction transaction = DBService.getTransaction();
        try {
            CouplePoints couplePoints = logger.getCouplePoints();
            pointsDAO.add(couplePoints.getPointA());
            pointsDAO.add(couplePoints.getPointB());
            couplePointsDAO.add(couplePoints);
            launchDAO.add(logger.getLaunch());
            calculationDAO.add(logger.getCalculation());
            loggerDAO.add(logger);
            transaction.commit();

        } catch (HibernateException | NoResultException e) {
            DBService.transactionRollback(transaction);
        }

    }

    public Iterable<Logger> getAllLogger(){
        Transaction transaction = DBService.getTransaction();
        Iterable<Logger> loggers = null;
        try {

            loggers = loggerDAO.getAll();
            transaction.commit();

        } catch (HibernateException | NoResultException e) {
            DBService.transactionRollback(transaction);
        }
        return loggers;
    }



}
