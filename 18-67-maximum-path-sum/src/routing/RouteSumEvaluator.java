package routing;

import model.Triangle;

/**
 * Evaluates the sum of a route for a given triangle
 */
public class RouteSumEvaluator {

    private final Triangle triangle;

    /**
     * Construct a new RouteSumEvaluator for a given triangle
     * @param triangle triangle to be calculating routes against
     */
    public RouteSumEvaluator(Triangle triangle) {
        this.triangle = triangle;
    }

    /**
     * Evaluate the sum of a route through a triangle by adding every point the route passes through.
     * @param route the route to evaluate
     * @return the sum of all points touched by the route
     */
    public int evaluate(Route route) {
        int sum = 0;
        // Start at row 1, point 1
        int pointIndex = 0; // The horizontal position in the row (i.e. which point in the row to look at).
        for (int rowIndex = 0; rowIndex < triangle.size(); rowIndex++) {
            sum += getPointValue(rowIndex, pointIndex);
            pointIndex = nextIndexForRoute(route, pointIndex, rowIndex);
        }
        return sum;
    }

    private int nextIndexForRoute(Route route, int pointIndex, int rowIndex) {
        RouteDecision routeDecision = route.decision(rowIndex);
        // If the route decision is to go right, move the point cursor one place right.
        // If the decision is to go left we can leave the index as it is.
        // This can be understood by reshaping a symmetrical triangle as a left-anchored triangle:
        //     10        -->       10
        //   11  12      -->       11 12          in which case 'left' can just be seen as 'straight down'
        // 13  14  15    -->       13 14 15
        if (routeDecision == RouteDecision.GO_RIGHT) {
            pointIndex++;
        }
        return pointIndex;
    }

    private int getPointValue(int rowIndex, int pointIndex) {
        return triangle.row(rowIndex).point(pointIndex).value();
    }
}
