package routing;

import java.util.Arrays;
import java.util.List;

/**
 * Represents a route through a triangle from the first point a point further down the triangle.
 */
public class Route {

    private final List<RouteDecision> decisions;

    /**
     * Create a new route from a series of decisions.
     * @param routeDecisions the route decisions which define the route
     */
    public Route(RouteDecision... routeDecisions) {
        this.decisions = Arrays.asList(routeDecisions);
    }

    /**
     * The depth of this route, i.e. how many rows it traverses.
     * This is the number of route decisions plus one (a route of one decision traverses two rows).
     * @return the route's depth
     */
    public int depth() {
        return decisions.size() +1;
    }

    /**
     * Get the decision at a given index.
     * @param index index to obtain route at
     * @return route decision
     */
    public RouteDecision decision(int index) {
        return decisions.get(index);
    }

    /**
     * Extend the route by adding another RouteDecision to the end of this Route.
     * This creates a new Route rather than mutating this route.
     * @param routeDecision new RouteDecision to add
     * @return extended route
     */
    public Route extend(RouteDecision routeDecision) {
        RouteDecision[] newDecisions = decisions.toArray(new RouteDecision[decisions.size() + 1]);
        newDecisions[newDecisions.length - 1] = routeDecision;
        return new Route(newDecisions);
    }
}
