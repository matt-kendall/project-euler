import io.FileLoader;
import io.TriangleLoader;
import model.Triangle;
import routing.PossibleRouteFinder;
import solvers.BruteForceTriangleSolver;
import solvers.OptimalTriangleSolver;
import solvers.TriangleSolver;

import java.io.FileNotFoundException;

/**
 * Main entry class for solving Project Euler exercises 18 and 67.
 */
public class MaximumPathSumMain {

    public static void main(String[] args) throws FileNotFoundException {
        solve18BruteForce();
        solve67Optimally();
    }

    private static void solve18BruteForce() throws FileNotFoundException {
        System.out.println("Solving Project Euler puzzle 18...");
        Triangle triangle = getTriangle("triangle-15-rows.txt");

        TriangleSolver solver = new BruteForceTriangleSolver(new PossibleRouteFinder());
        solveAndOutput(triangle, solver);
    }

    private static void solve67Optimally() throws FileNotFoundException {
        System.out.println("Solving Project Euler puzzle 67...");
        Triangle triangle = getTriangle("triangle-100-rows.txt");

        TriangleSolver solver = new OptimalTriangleSolver();
        solveAndOutput(triangle, solver);
    }

    private static void solveAndOutput(Triangle triangle, TriangleSolver solver) {
        int maxPathSum = solver.findMaxPathSum(triangle);
        System.out.println(String.format("Maximum Path Sum is %d", maxPathSum));
    }

    private static Triangle getTriangle(String filename) throws FileNotFoundException {
        TriangleLoader triangleLoader = new TriangleLoader(new FileLoader());
        return triangleLoader.loadFile(filename);
    }
}
