package solvers;

import model.Triangle;
import routing.PossibleRouteFinder;
import routing.Route;
import routing.RouteSumEvaluator;

import java.util.List;

/**
 * Solves triangle paths by trying all possible routes.
 */
public class BruteForceTriangleSolver implements TriangleSolver {

    private final PossibleRouteFinder routeFinder;

    public BruteForceTriangleSolver(PossibleRouteFinder possibleRouteFinder) {
        this.routeFinder = possibleRouteFinder;
    }

    @Override
    public int findMaxPathSum(Triangle triangle) {
        RouteSumEvaluator sumEvaluator = new RouteSumEvaluator(triangle);
        List<Route> routes = routeFinder.findRoutes(triangle);

        int maxSum = Integer.MIN_VALUE;
        for (Route route : routes) {
            int sum = sumEvaluator.evaluate(route);
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }
}
