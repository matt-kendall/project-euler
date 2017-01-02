package math;

/**
 * Calculates the sum of all digits in a number.
 */
public final class DigitSumCalculator {

    /**
     * Sum the digits of a number.
     * E.g. sumDigits(123) = 1 + 2 + 3 = 6
     * @param value the value whose digits to sum
     * @return the sum of the digits of the given number
     */
    public int sumDigits(int value) {
        int digitSum = 0;
        // Take the rightmost digit each turn by taking the remainder modulo 10
        while (value > 0) {
            int rightMostDigit = value % 10;
            digitSum += rightMostDigit;
            value /= 10; // Divide by 10 to lose the rightmost digit (integer division)
        }
        return digitSum;
    }
}
