package solvers;

import model.Triangle;
import org.junit.Test;
import routing.PossibleRouteFinder;
import testingtools.BaseTriangleTest;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Tests the Brute Force Triangle Solver gets the right answers.
 */
public class BruteForceTriangleSolverTest extends BaseTriangleTest {

    @Test
    public void triangleSolverCalculatesCorrectAnswer() {
        Triangle triangle = new Triangle(Arrays.asList(
                makeRow(100),
                makeRow(1, 99),
                makeRow(10, 20, 5),
                makeRow(12, 5, 3, 1)
        ));

        BruteForceTriangleSolver triangleSolver = new BruteForceTriangleSolver(new PossibleRouteFinder());
        int sum = triangleSolver.findMaxPathSum(triangle);

        // The best path through the triangle is 100 -> 99 -> 20 -> 5 for a total of 224
        assertEquals(224, sum);
    }
}