import org.example.inputXML.XMLReader;
import org.example.points.entities.CouplePoints;
import org.example.points.entities.Points;
import org.example.points.entities.Points2D;
import org.example.points.entities.Points3D;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

public class XMLReaderTest extends Assertions {

    public static XMLReader xmlReader;


    public static List<CouplePoints> couplePointsList = null;
    @BeforeAll
    public static void globalSetUp(){
        xmlReader = new XMLReader.Builder("123.xml")
                .setElement("CouplePoints")
                .build();


    }

    @Test
    public void getElementsTest(){
        couplePointsList = ((List<CouplePoints>) xmlReader.getElements());
        assertNotNull(couplePointsList);
        Points2D points2DTest = (Points2D) couplePointsList.get(0).getPointA();
        Points3D points3DTest = (Points3D) couplePointsList.get(1).getPointB();

        assertEquals(points3DTest.getZ(), 6);
        assertEquals(points2DTest.getX(), 2);

    }
}
