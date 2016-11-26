package model;

/**
 * Represents a set of quadratic roots (i.e. two values).
 */
public final class QuadraticRoots {

    private final double lower;
    private final double upper;

    /**
     * Generate a new QuadraticRoots given two roots.
     * @param root1 the first root
     * @param root2 the second root
     */
    public QuadraticRoots(double root1, double root2) {
        lower = Math.min(root1, root2);
        upper = Math.max(root1, root2);
    }

    /**
     * Returns the greater of the two roots.
     * @return the upper root
     */
    public double upper() {
        return upper;
    }

    /**
     * Returns the lower of the two roots.
     * @return the lower root
     */
    public double lower() {
        return lower;
    }
}
