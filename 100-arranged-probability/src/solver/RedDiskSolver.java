package solver;

import model.QuadraticRoots;

/**
 * Solves for the number of red disks required for a given number of blue disks to satisfy the condition
 * that the probability of pulling two consecutive blue disks is exactly one half.
 */
public class RedDiskSolver {

    private final RealQuadraticSolver quadraticSolver;

    /**
     * Create a new RedDiskSolver given a quadratic solver.
     * @param quadraticSolver quadratic solver to use.
     */
    public RedDiskSolver(RealQuadraticSolver quadraticSolver) {
        this.quadraticSolver = quadraticSolver;
    }

    /**
     * Given a number of blue disks, determine the number of red disks required to satisfy the condition
     * that the probability of pulling two consecutive blue disks is 50%.
     * @param blueDisks the number of blue disks
     * @return the number of red disks (may or may not be an integer depending on whether an exact solution
     * exists for that number of blue disks).
     */
    public double calculateRedDisks(int blueDisks) {
        // The solutions to this condition are given by a quadratic in r:
        QuadraticRoots roots = solveQuadraticForRoots(blueDisks);
        // The quadratic will return two roots. One will be negative and one positive.
        // This can be seen because the probability of pulling consecutive blue disks must always decrease as red disks
        // are added. Therefore there can only be one point (b,r) in the b,r > 0 domain where this equality is true
        return roots.upper();
    }

    private QuadraticRoots solveQuadraticForRoots(int b) {
        // By starting with the equation that defines the problem
        // P(BB) = P(B1) * P(B2)
        // 0.5 = (b  / (b + r)) * ((b - 1) / (b + r - 1))
        // We can re-arrange to provide a polynomial in r which can then be solved quadratically:
        // r^2 + (2b - 1)r + (b - b^2) = 0
        double quadraticCoefficient = 1;
        double linearCoefficient = 2 * b - 1;
        double constant = b - Math.pow(b, 2);
        return quadraticSolver.solve(quadraticCoefficient, linearCoefficient, constant);
    }
}
