import exception.NotThreeDigitsException;
import number.NumberDecomposer;

/**
 * Entry class for solving Project Euler problem 14.
 */
public class ProjectEulerFourteenMain {

    public static void main(String[] args) throws NotThreeDigitsException {
        NumberDecomposer numberDecomposer = new NumberDecomposer();
        NumberLetterCounter numberLetterCounter = new NumberLetterCounter(numberDecomposer);

        System.out.println("Calculating number of letters used in numbers 1 - 1000 ...");
        int letterCount = numberLetterCounter.countRange(1, 999);
        // 1000 does not fit into the three digit system so add it here:
        // One thousand -> 11 characters
        letterCount += 11;
        System.out.println(String.format("Number of letters was: %d", letterCount));
    }
}
