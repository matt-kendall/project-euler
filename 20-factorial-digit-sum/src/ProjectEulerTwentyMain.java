import math.DigitSumCalculator;
import math.FactorialCalculator;

import java.math.BigInteger;

/**
 * Entry class for solving Project Euler problem 20.
 *
 * This is finding the sum of the digits of 100 factorial
 */
public class ProjectEulerTwentyMain {

    public static void main(String[] args) {
        DigitSumCalculator digitSumCalculator = new DigitSumCalculator();
        FactorialCalculator factorialCalculator = new FactorialCalculator();

        BigInteger factorial = factorialCalculator.calculate(100);
        int digitSum = digitSumCalculator.sumDigits(factorial);

        System.out.println(String.format("Sum of the digits of 100 factorial is %d", digitSum));
    }
}
