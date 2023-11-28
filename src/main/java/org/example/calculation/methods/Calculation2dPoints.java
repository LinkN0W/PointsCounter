package org.example.calculation.methods;

import org.example.calculation.entities.Calculation;
import org.example.calculation.entities.Calculation2D;
import org.example.points.entities.CouplePoints;
import org.example.points.entities.Points2D;

public class Calculation2dPoints implements CalculationMethods{
    @Override
    public Calculation calculateDistance(CouplePoints couplePoints) {
        Points2D pointA2D = (Points2D) couplePoints.getPointA();
        Points2D pointB2D = (Points2D) couplePoints.getPointB();
        Calculation calculation = new Calculation2D();

        float xA = pointA2D.getX();
        float yA = pointA2D.getY();

        float xB = pointB2D.getX();
        float yB = pointB2D.getY();

        calculation.setDistance((float) Math.sqrt(Math.pow(xB - xA, 2) + Math.pow(yB - yA, 2)));

        return calculation;
    }
}
