package solver;

import model.QuadraticRoots;

/**
 * Solves quadratic equations using the well-known quadratic formula.
 */
public class RealQuadraticSolver {

    /**
     * Solve for the two roots of the quadratic equation defined by the three standard parameters a, b and c.
     * If the roots are not real, they will be returned as NaN (complex numbers are not handled).
     * @param a the quadratic coefficient
     * @param b the linear coefficient
     * @param c the constant
     * @return the roots to the equation
     */
    public QuadraticRoots solve(double a, double b, double c) {
        double root1 = solveForNegativePlusMinus(a, b, c);
        double root2 = solveForPositivePlusMinus(a, b, c);
        return new QuadraticRoots(root1, root2);
    }

    private double solveForPositivePlusMinus(double a, double b, double c) {
        // Solve the quadratic equation in the case where the 'plus/minus' is evaluated as '+'
        double squareRootTerm = calculateSquareRootTermAbsValue(a, b, c);
        return ( - b  + squareRootTerm) / (2 * a);
    }

    private double solveForNegativePlusMinus(double a, double b, double c) {
        // Solve the quadratic equation in the case where the 'plus/minus' is evaluated as '-'
        double squareRootTerm = calculateSquareRootTermAbsValue(a, b, c);
        return ( - b  - squareRootTerm) / (2 * a);
    }

    private double calculateSquareRootTermAbsValue(double a, double b, double c) {
        // Calculate the absolute value of the square root ter
        // This term can be negative or positive
        double discriminant = Math.pow(b, 2) - 4 * a * c;
        return Math.sqrt(discriminant);
    }
}
