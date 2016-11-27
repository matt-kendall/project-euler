package solver;

import model.QuadraticRoots;
import org.junit.Before;
import org.junit.Test;
import testingtools.TestBase;

import static org.junit.Assert.*;

/**
 * Tests for the correct behaviour of the quadratic equation solver
 */
public class RealQuadraticSolverTest extends TestBase {

    private RealQuadraticSolver quadraticSolver;

    @Before
    public void setUp() {
        quadraticSolver = new RealQuadraticSolver();
    }

    @Test
    public void canSolveForTwoRealRoots() {
        // Solve the equation 5x^2 + 6x + 1 = 0
        QuadraticRoots roots = quadraticSolver.solve(5, 6, 1);
        assertEquals(-1, roots.lower(), TEST_DELTA);
        assertEquals(-0.2, roots.upper(), TEST_DELTA);
    }

    @Test
    public void canSolveForOneRealRoot() {
        // Solve the equation x^2 - 2x + 1 = 0
        QuadraticRoots roots = quadraticSolver.solve(1, -2, 1);
        assertEquals(1, roots.lower(), TEST_DELTA);
        assertEquals(1, roots.upper(), TEST_DELTA);
    }

    @Test
    public void solveForNoRealRootsReturnsNaNRoots() {
        // Solve the equation 5x^2 + 2x + 1 = 0
        QuadraticRoots roots = quadraticSolver.solve(5, 2, 1);
        assertTrue(Double.isNaN(roots.lower()));
        assertTrue(Double.isNaN(roots.upper()));
    }
}