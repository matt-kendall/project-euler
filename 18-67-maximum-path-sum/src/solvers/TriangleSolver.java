package solvers;

import model.Triangle;

/**
 * Finds routes through a triangle to calculate the maximum path sum.
 */
public interface TriangleSolver {

    /**
     * Solve for the maximum path sum through a triangle.
     * @param triangle the triangle to solve for a route through
     * @return the maximum path sum through the triangle
     */
    int findMaxPathSum(Triangle triangle);
}
