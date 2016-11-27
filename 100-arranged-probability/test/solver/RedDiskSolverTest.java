package solver;

import org.junit.Before;
import org.junit.Test;
import testingtools.TestBase;

import static org.junit.Assert.*;

/**
 * Tests that the red disk solver correctly calculates the required numbers of red disks
 * from the input number of blue disks.
 */
public class RedDiskSolverTest extends TestBase {

    private RedDiskSolver redDiskSolver;

    @Before
    public void setUp() {
        RealQuadraticSolver solver = new RealQuadraticSolver();
        redDiskSolver = new RedDiskSolver(solver);
    }

    @Test
    public void canSolveExampleOne() {
        // The first example given in the Project Euler problem description is 15 blue, 6 red.
        double redDisks = redDiskSolver.calculateRedDisks(15);
        assertEquals(6, redDisks, TEST_DELTA);
    }

    @Test
    public void canSolveExampleTwo() {
        // The second example given in the Project Euler problem description is 85 blue, 35 red.
        double redDisks = redDiskSolver.calculateRedDisks(85);
        assertEquals(35, redDisks, TEST_DELTA);
    }
}