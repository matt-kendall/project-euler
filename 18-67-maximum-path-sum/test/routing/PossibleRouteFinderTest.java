package routing;

import model.Row;
import model.Triangle;
import org.junit.Before;
import org.junit.Test;
import testingtools.BaseTriangleTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Tests that the PossibleRouteFinder correctly determines all possible routes.
 */
public class PossibleRouteFinderTest extends BaseTriangleTest {

    private PossibleRouteFinder routeFinder;

    @Before
    public void setUp() {
        routeFinder = new PossibleRouteFinder();
    }

    @Test
    public void findsCorrectRoutesForTriangleOfSizeTwo() {
        Triangle triangle = makeTriangleOfSize(2);

        List<Route> routes = routeFinder.findRoutes(triangle);

        // There are 2^1 = 2 routes here
        assertEquals(2, routes.size());
        // The order of the routes is not strictly important but it's easiest to test
        // Route 1 = L
        assertEquals(RouteDecision.GO_LEFT, routes.get(0).decision(0));
        // Route 2 = R
        assertEquals(RouteDecision.GO_RIGHT, routes.get(1).decision(0));
    }

    @Test
    public void findsCorrectRoutesForTriangleOfSizeThree() {
        Triangle triangle = makeTriangleOfSize(3);

        List<Route> routes = routeFinder.findRoutes(triangle);

        // There are 2^2 = 4 routes here
        assertEquals(4, routes.size());
        // The order of the routes is not strictly important but it's easiest to test
        // Route 1 = L, L
        assertEquals(RouteDecision.GO_LEFT, routes.get(0).decision(0));
        assertEquals(RouteDecision.GO_LEFT, routes.get(0).decision(1));
        // Route 2 = L, R
        assertEquals(RouteDecision.GO_LEFT, routes.get(1).decision(0));
        assertEquals(RouteDecision.GO_RIGHT, routes.get(1).decision(1));
        // Route 3 = R, L
        assertEquals(RouteDecision.GO_RIGHT, routes.get(2).decision(0));
        assertEquals(RouteDecision.GO_LEFT, routes.get(2).decision(1));
        // Route 4 = R, R
        assertEquals(RouteDecision.GO_RIGHT, routes.get(3).decision(0));
        assertEquals(RouteDecision.GO_RIGHT, routes.get(3).decision(1));
    }

    @Test
    public void hasCorrectNumberOfRoutesForTriangleOfSizeTen() {
        // Validating the routes for more than a small triangle is hard as there are lots,
        // so just check the right number of routes have been calculated
        // There should be 2^9 routes
        Triangle triangle = makeTriangleOfSize(10);

        List<Route> routes = routeFinder.findRoutes(triangle);

        assertEquals(Math.pow(2, 9), routes.size(), 0.001);
    }

    private Triangle makeTriangleOfSize(int size) {
        List<Row> rows = new ArrayList<>();
        for (int i = 1; i <= size; i++) {
            rows.add(makeRowOfSize(i));
        }
        return new Triangle(rows);
    }
}