package org.example.calculation.methods;

import org.example.calculation.entities.Calculation;
import org.example.calculation.entities.Calculation3D;
import org.example.points.entities.CouplePoints;
import org.example.points.entities.Points;
import org.example.points.entities.Points2D;
import org.example.points.entities.Points3D;

public class Calculation3dPoints implements CalculationMethods{
    @Override
    public Calculation calculateDistance(CouplePoints couplePoints) {
        Points3D pointA3D = (Points3D) couplePoints.getPointA();
        Points3D pointB3D = (Points3D) couplePoints.getPointB();
        Calculation calculation = new Calculation3D();

        float xA = pointA3D.getX();
        float yA = pointA3D.getY();
        float zA = pointA3D.getZ();

        float xB = pointB3D.getX();
        float yB = pointB3D.getY();
        float zB = pointB3D.getZ();

        calculation.setDistance((float) Math.sqrt(Math.pow(xB - xA, 2) + Math.pow(yB - yA, 2) + Math.pow(zB - zA, 2)));

        return calculation;
    }

}
