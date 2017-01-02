package math;

import sun.awt.image.BufferedImageGraphicsConfig;

import java.math.BigInteger;

/**
 * Calculate the factorial of a number.
 */
public final class FactorialCalculator {

    /**
     * Calculate the factorial of a given number
     * @param number the number to calculate factorial of
     * @return the calculated factorial
     */
    public BigInteger calculate(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Factorial of negative number is not defined");
        } else if (number == 0) {
            // 0! is defined as 1
            return BigInteger.ONE;
        } else {
            return calculateFactorial(number);
        }
    }

    private BigInteger calculateFactorial(int number) {
        BigInteger factorial = BigInteger.ONE;
        while (number > 1) {
             factorial = factorial.multiply(BigInteger.valueOf(number));
                number -= 1;
        }
        return factorial;
    }
}
