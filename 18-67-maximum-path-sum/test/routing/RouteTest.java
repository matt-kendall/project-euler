package routing;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests for immutability and behaviour of Routes.
 */
public class RouteTest {

    @Test
    public void routeWithOneDecisionHasDepthTwo() {
        Route route = new Route(RouteDecision.GO_LEFT);
        assertEquals(2, route.depth());
    }

    @Test
    public void canGetRouteDecisionAtIndex() {
        Route route = new Route(RouteDecision.GO_LEFT, RouteDecision.GO_RIGHT);
        assertEquals(RouteDecision.GO_RIGHT, route.decision(1));
    }

    @Test
    public void canExtendRoute() {
        Route route = new Route(RouteDecision.GO_RIGHT, RouteDecision.GO_RIGHT);
        Route longerRoute = route.extend(RouteDecision.GO_LEFT);

        assertEquals(4, longerRoute.depth());
        assertEquals(RouteDecision.GO_RIGHT, longerRoute.decision(0));
        assertEquals(RouteDecision.GO_RIGHT, longerRoute.decision(1));
        assertEquals(RouteDecision.GO_LEFT, longerRoute.decision(2));
    }

    @Test
    public void extendingRouteDoesNotModifyOriginalRoute() {
        Route route = new Route(RouteDecision.GO_LEFT);
        route.extend(RouteDecision.GO_RIGHT);

        assertEquals(2, route.depth());
    }
}