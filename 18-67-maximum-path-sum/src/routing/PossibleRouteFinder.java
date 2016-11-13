package routing;

import model.Triangle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Finds all possible routes through a triangle of known size.
 */
public class PossibleRouteFinder {

    /**
     * Calculate all possible routes through a triangle.
     * The number of routes returned will be 2^(N-1) where N is the triangle size.
     * @param triangle triangle to calculate routes for
     * @return list of all possible routes through the triangle
     */
    public List<Route> findRoutes(Triangle triangle) {
        // The starting routes are for depth 2 (spans 2 rows), the shortest route possible
        List<Route> routes = getStartingRoutes();

        // Now run routes of depths 3 .. N where N is the triangle size
        for (int i = 3; i <= triangle.rows().size(); i++) {
            routes = expandRouteDepth(routes);
        }
        return routes;
    }

    private List<Route> getStartingRoutes() {
        // Start with a route going left and a route going right
        // This is the route of depth 2 (i.e. spans two rows)
        return Arrays.asList(
                new Route(RouteDecision.GO_LEFT),
                new Route(RouteDecision.GO_RIGHT)
        );
    }

    private List<Route> expandRouteDepth(List<Route> routesAtCurrentDepth) {
        // Expand the routes current depth by one
        List<Route> routesForNextDepth = new ArrayList<>();
        for (Route route : routesAtCurrentDepth) {
            routesForNextDepth.add(route.extend(RouteDecision.GO_LEFT));
            routesForNextDepth.add(route.extend(RouteDecision.GO_RIGHT));
        }
        return routesForNextDepth;
    }
}
