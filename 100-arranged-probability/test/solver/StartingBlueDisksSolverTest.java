package solver;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests that the StartingBlueDisksSolver calculates the correct starting numbers of blue disks.
 */
public class StartingBlueDisksSolverTest {

    private StartingBlueDisksSolver startingBlueDisksSolver;

    @Before
    public void setUp() {
        RealQuadraticSolver quadraticSolver = new RealQuadraticSolver();
        startingBlueDisksSolver = new StartingBlueDisksSolver(quadraticSolver);
    }

    @Test
    public void canGetMinimumBlueDisksWhenAnExactSolution1() {
        // We know that 15 blue, 6 red is a solution. Therefore the minimum number of blue disks
        // required for a total of 21 should be 15.
        int minBlueDisks = startingBlueDisksSolver.getMinBlueDisks(21);
        assertEquals(15, minBlueDisks);
    }

    @Test
    public void canGetMinimumBlueDisksWhenAnExactSolution2() {
        // We know that 85 blue, 35 red is a solution. Therefore the minimum number of blue disks
        // required for a total of 120 should be 85.
        int minBlueDisks = startingBlueDisksSolver.getMinBlueDisks(120);
        assertEquals(85, minBlueDisks);
    }

    @Test
    public void canGetMinimumBlueDisksWhenNotAnExactSolution() {
        // We know there is an integer solution for 21 total disks (15 blue disks)
        // If we ask for a solution for 20 disks, there will be no real solution so we will get a number less than 15,
        // but this should get rounded up to 15
        int minBlueDisks = startingBlueDisksSolver.getMinBlueDisks(20);
        assertEquals(15, minBlueDisks);
    }
}