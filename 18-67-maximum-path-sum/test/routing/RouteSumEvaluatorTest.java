package routing;

import exception.RouteTooLongException;
import model.Triangle;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import testingtools.BaseTriangleTest;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Tests that the RouteSumEvaluator correctly adds up points.
 */
public class RouteSumEvaluatorTest extends BaseTriangleTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    private RouteSumEvaluator routeSumEvaluator;

    @Before
    public void setUp() {
        Triangle triangle = new Triangle(Arrays.asList(
                makeRow(10),
                makeRow(14, 15),
                makeRow(11, 18, 21),
                makeRow(8, 3, 5, 11)
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

        // Sum = 10 + 14 + 11 + 8 = 43
        assertEquals(43, sum);
    }

    @Test
    public void canEvaluateRouteOfAllRights() {
        Route route = new Route(
                RouteDecision.GO_RIGHT,
                RouteDecision.GO_RIGHT,
                RouteDecision.GO_RIGHT
        );

        int sum = routeSumEvaluator.evaluate(route);

        // Sum = 10 + 15 + 21 + 11 = 57
        assertEquals(57, sum);
    }

    @Test
    public void canEvaluateRouteOFMixedDecisions() {
        Route route = new Route(
                RouteDecision.GO_RIGHT,
                RouteDecision.GO_LEFT,
                RouteDecision.GO_RIGHT
        );

        int sum = routeSumEvaluator.evaluate(route);

        // Sum = 10 + 15 + 18 + 5 = 48
        assertEquals(48, sum);
    }

    @Test
    public void ifRouteIsTooLongForTriangleThrowsInvalidRouteException() {
        // The triangle has four rows, so a route must be comprised of maximum four decisions.
        Route route = new Route(
                RouteDecision.GO_LEFT,
                RouteDecision.GO_LEFT,
                RouteDecision.GO_LEFT,
                RouteDecision.GO_LEFT
        );

        expectedException.expect(RouteTooLongException.class);
        routeSumEvaluator.evaluate(route);
    }

    @Test
    public void canCalculateRouteShorterThanTriangle() {
        // Test that a partial route through a triangle can be calculated, finishing early
        Route route = new Route(
                RouteDecision.GO_RIGHT,
                RouteDecision.GO_LEFT
        );

        int sum = routeSumEvaluator.evaluate(route);

        // Sum = 10 + 15 + 18 = 43
        assertEquals(43, sum);
    }
}