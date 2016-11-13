package routing;

import model.Triangle;
import org.junit.Before;
import org.junit.Test;
import testingtools.BaseTriangleTest;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Tests that the RouteSumEvaluator correctly adds up points.
 */
public class RouteSumEvaluatorTest extends BaseTriangleTest {

    private RouteSumEvaluator routeSumEvaluator;

    @Before
    public void setUp() {
        Triangle triangle = new Triangle(Arrays.asList(
                makeRow(10),
                makeRow(14, 15),
                makeRow(11, 18, 21)
        ));
        routeSumEvaluator = new RouteSumEvaluator(triangle);
    }

    @Test
    public void canEvaluateRouteOfAllLefts() {
        Route route = new Route(
                RouteDecision.GO_LEFT,
                RouteDecision.GO_LEFT,
                RouteDecision.GO_LEFT
        );

        int sum = routeSumEvaluator.evaluate(route);

        // Sum = 10 + 14 + 11 = 35
        assertEquals(35, sum);
    }

    @Test
    public void canEvaluateRouteOfAllRights() {
        Route route = new Route(
                RouteDecision.GO_RIGHT,
                RouteDecision.GO_RIGHT,
                RouteDecision.GO_RIGHT
        );

        int sum = routeSumEvaluator.evaluate(route);

        // Sum = 10 + 15 + 21 = 46
        assertEquals(46, sum);
    }

    @Test
    public void canEvaluateRouteOFMixedDecisions() {
        Route route = new Route(
                RouteDecision.GO_RIGHT,
                RouteDecision.GO_RIGHT,
                RouteDecision.GO_RIGHT
        );

        int sum = routeSumEvaluator.evaluate(route);

        // Sum = 10 + 15 + 21 = 46
        assertEquals(46, sum);
    }
}