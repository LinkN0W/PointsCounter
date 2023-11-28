import org.example.logger.LogAggregator;
import org.example.logger.entities.Logger;
import org.example.points.entities.CouplePoints;
import org.example.points.entities.Points2D;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LogAggregatorTest extends Assertions {

    private static LogAggregator logAggregator;

    private static CouplePoints couplePoints;
    @BeforeEach
    public void setUp(){
        logAggregator = new LogAggregator();
        couplePoints = new CouplePoints();
        couplePoints.setPointA(new Points2D(1,1));
        couplePoints.setPointB(new Points2D(2, 2));
    }

    @Test
    public void aggregateLog(){
        assertNotNull(logAggregator.aggregateLog(couplePoints));
        assertSame(logAggregator.aggregateLog(couplePoints).getCouplePoints(),couplePoints);
    }
}
