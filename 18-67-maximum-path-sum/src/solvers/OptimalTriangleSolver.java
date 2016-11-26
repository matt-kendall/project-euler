package solvers;

import model.Row;
import model.Triangle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Solve for a triangle max path optimally by not repeating parts of routes that have already been calculated.
 */
public class OptimalTriangleSolver implements TriangleSolver {

    @Override
    public int findMaxPathSum(Triangle triangle) {
        // The output of each iteration needs to be, for all points in a row, the max path length to reach that point.
        // Start at second row
        List<Integer> maxPaths = getPathValuesForFirstPoint(triangle);
        // Then iterate over all rows > 1 (i.e. rows with ancestors in the triangle):
        for (int rowIndex = 1; rowIndex < triangle.size(); rowIndex++) {
            Row row = triangle.row(rowIndex);
            List<Integer> newMaxPaths = new ArrayList<>();
            for (int pointIndex = 0; pointIndex < row.size(); pointIndex++) {
                int maxPath = getMaxPathToNewPoint(maxPaths, row, pointIndex);
                newMaxPaths.add(maxPath + row.point(pointIndex).value());
            }
            maxPaths = newMaxPaths;
        }
        return Collections.max(maxPaths);
    }

    private int getMaxPathToNewPoint(List<Integer> maxPaths, Row row, int pointIndex) {
        // For each point, we obtain the max of the two possible routes to that point (if there are two)
        // 0 1 2 3 4
        // 0 1 2 3 4 5
        int maxPath;
        if (pointIndex == 0) {
            // The first point can only 
            maxPath = maxPaths.get(0);
        } else if (pointIndex == row.size() - 1) {
            maxPath = maxPaths.get(pointIndex - 1);
        } else {
            // This was a move left
            int branch1 = maxPaths.get(pointIndex);
            // This was a move right
            int branch2 = maxPaths.get(pointIndex - 1);
            maxPath = Math.max(branch1, branch2);
        }
        return maxPath;
    }

    private List<Integer> getPathValuesForFirstPoint(Triangle triangle) {
        // The first point is a special case because it has no ancestors on the triangle path
        // so its max path length is defined as the point value (the only point in thw row)
        return Collections.singletonList(
                triangle.row(0).point(0).value()
        );
    }
}
