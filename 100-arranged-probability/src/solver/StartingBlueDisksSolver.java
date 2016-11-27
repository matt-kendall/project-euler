package solver;

import model.QuadraticRoots;

/**
 * Given a required minimum total number of disks, calculates the first (integer) number of blue disks that could
 * possibly satisfy the condition that the probability of selecting two consecutive disks is 50%.
 * The given number of blue disks may not have an exact solution for red disks, but this should form a starting point
 * for iterative solutions.
 */
public class StartingBlueDisksSolver {

    private final RealQuadraticSolver quadraticSolver;

    /**
     * Create a new StartingBlueDisksSolver.
     * @param quadraticSolver quadratic solver to use.
     */
    public StartingBlueDisksSolver(RealQuadraticSolver quadraticSolver) {
        this.quadraticSolver = quadraticSolver;
    }

    /**
     * Gets the smallest number of blue disks that could possibly satisfy the required probability condition, given
     * a required minimum total number of disks.
     * @param minimumTotalDisks required total number of disks (red and blue)
     * @return minimum number of blue disks that could possibly be valid
     */
    public int getMinBlueDisks(int minimumTotalDisks) {
        // THe solutions to this condition are given by a quadratic:
        QuadraticRoots quadraticRoots = solveQuadraticForRoots(minimumTotalDisks);
        // There can only be one positive (i.e. real-world) answer, so we take just the positive (upper) root.
        double minBlueDisks = quadraticRoots.upper();
        // If the minimum number of blue disks is not an integer then the actual minimum number of disks must be
        // the next integer up from this (we can't have partial disks!)
        return (int) Math.ceil(minBlueDisks);
    }

    private QuadraticRoots solveQuadraticForRoots(int t) {
        // By starting with the equation that defines the problem
        // P(BB) = P(B1) * P(B2)
        // 0.5 = (b  / (b + r)) * ((b - 1) / (b + r - 1))
        // We have b + r = t (total number of disks), allowing us to substitute:
        // 0.5 = (b / t) * ((b - 1) / (t - 1))
        // We can re-arrange to provide a polynomial in b which can then be solved quadratically:
        // b^2 - b - (t * (t - 1)) / 2 = 0
        double quadraticCoefficient = 1;
        double linearCoefficient = - 1;
        double constant = - (t * (t - 1)) / 2.0;
        return quadraticSolver.solve(quadraticCoefficient, linearCoefficient, constant);
    }
}
