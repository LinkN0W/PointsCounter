import org.example.calculation.dao.CalculationDAO;
import org.example.calculation.entities.Calculation;
import org.example.calculation.entities.Calculation2D;
import org.example.calculation.entities.Calculation3D;
import org.example.calculation.methods.Calculation2dPoints;
import org.example.calculation.methods.Calculation3dPoints;
import org.example.calculation.methods.CalculationMethods;
import org.example.calculation.methods.CalculationPointsFactory;
import org.example.enums.MethodCalculation;
import org.example.points.entities.CouplePoints;
import org.example.points.entities.Points2D;
import org.example.points.entities.Points3D;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculationTest  extends Assertions{

    private static CalculationMethods calculationMethods2D;

    private static CalculationMethods calculationMethods3D;

    private static CouplePoints couplePoints3D;

    private static CouplePoints couplePoints2D;

    private static float xA = 3;
    private static float yA = 5;

    private static float zA = -4;


    private static float xB = -3;
    private static float yB = 9;

    private static float zB = 0;


    private static float distance2D = 7;

    private static float distance3D = 8;


    @BeforeAll
    public static void globalSetUp(){
        calculationMethods2D = new Calculation2dPoints();
        calculationMethods3D = new Calculation3dPoints();
        couplePoints2D = new CouplePoints();
        couplePoints3D = new CouplePoints();
        couplePoints2D.setPointA(new Points2D(xA, yA));
        couplePoints2D.setPointB(new Points2D(xB, yB));
        couplePoints3D.setPointA(new Points3D(xA, yA, zA));
        couplePoints3D.setPointB(new Points3D(xB, yB, zB));
    }

    @BeforeEach
    public void setUp(){

    }

    @Test
    public void testCalculationDistance(){
        Calculation calculation2d = calculationMethods2D.calculateDistance(couplePoints2D);
        assertNotNull(calculation2d);
        assertTrue(calculation2d instanceof Calculation2D);
        assertEquals(Math.round(calculation2d.getDistance()), distance2D);

        Calculation calculation3d = calculationMethods3D.calculateDistance(couplePoints3D);
        assertNotNull(calculation3d);
        assertTrue(calculation3d instanceof Calculation3D);
        assertEquals(Math.round(calculation3d.getDistance()), distance3D);
    }

    @Test
    public void createCalculationMethods(){
        assertNotNull(CalculationPointsFactory.createCalculationMethods(MethodCalculation.DISTANCE2D));
        assertTrue(CalculationPointsFactory.createCalculationMethods(
                MethodCalculation.DISTANCE2D) instanceof Calculation2dPoints);
        assertNotNull(CalculationPointsFactory.createCalculationMethods(MethodCalculation.DISTANCE3D));
        assertTrue(CalculationPointsFactory.createCalculationMethods(
                MethodCalculation.DISTANCE3D) instanceof Calculation3dPoints);

    }




}
