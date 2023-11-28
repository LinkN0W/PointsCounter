package org.example.calculation.methods;

import org.example.enums.MethodCalculation;

public class CalculationPointsFactory {


    public static CalculationMethods createCalculationMethods(MethodCalculation methodCalculation){
        CalculationMethods calculationMethods = null;
        switch (methodCalculation){
            case DISTANCE2D:
                calculationMethods = new Calculation2dPoints();
                break;
            case DISTANCE3D:
                calculationMethods = new Calculation3dPoints();
                break;
        }
        return calculationMethods;

    }


}
