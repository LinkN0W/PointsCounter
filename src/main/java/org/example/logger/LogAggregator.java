package org.example.logger;

import org.example.calculation.entities.Calculation;
import org.example.calculation.methods.CalculationMethods;
import org.example.calculation.methods.CalculationPointsFactory;
import org.example.launch.entities.Launch;
import org.example.logger.entities.Logger;
import org.example.logger.LoggerService;
import org.example.points.entities.CouplePoints;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class LogAggregator {

    private Launch launch;



    private Logger logger;



    public Logger aggregateLog(CouplePoints couplePoints){

        launch = new Launch();

        logger = new Logger();

        CalculationMethods calculationMethods =
                CalculationPointsFactory.createCalculationMethods(couplePoints.getPointA().getMethodCalculation());

        logger.setCouplePoints(couplePoints);

        launch.setTimeOfBegin(LocalDateTime.now());
        Calculation calculation = calculationMethods.calculateDistance(couplePoints);
        launch.setTimeOfEnd(LocalDateTime.now());

        logger.setCalculation(calculation);
        logger.setLaunch(launch);

        return logger;
    }
}
