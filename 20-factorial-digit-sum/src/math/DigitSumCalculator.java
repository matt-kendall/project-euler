package math;

import java.math.BigInteger;

/**
 * Calculates the sum of all digits in a number.
 */
public final class DigitSumCalculator {

    private static final BigInteger DECIMAL_BASE = BigInteger.TEN;

    /**
     * Sum the digits of a number.
     * E.g. sumDigits(123) = 1 + 2 + 3 = 6
     * @param value the value whose digits to sum
     * @return the sum of the digits of the given number
     */
    public int sumDigits(BigInteger value) {
        int digitSum = 0;
        // Take the rightmost digit each turn by taking the remainder modulo 10
        while (value.signum() == 1) {
            long rightMostDigit = value.mod(DECIMAL_BASE).intValue();
            digitSum += rightMostDigit;
            value = value.divide(DECIMAL_BASE) ; // Divide by 10 to lose the rightmost digit (integer division)
        }
        return digitSum;
    }
}
