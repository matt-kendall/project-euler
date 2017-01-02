package math;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.math.BigInteger;

import static org.junit.Assert.*;

/**
 * Verify the behaviour of the Factorial Calculator.
 */
public class FactorialCalculatorTest {

    private FactorialCalculator factorialCalculator;
    @Rule public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp() {
        factorialCalculator = new FactorialCalculator();
    }

    @Test
    public void factorialOfZeroIsOne() {
        // 0! is defined as 1
        assertFactorialEquals(0, 1);
    }

    @Test
    public void factorialOfMinusOneThrowsIllegalArgumentException() {
        expectedException.expect(IllegalArgumentException.class);
        factorialCalculator.calculate(-1);
    }

    @Test
    public void factorialOfThreeIsSix() {
        assertFactorialEquals(3, 6);
    }

    @Test
    public void factorialOfFiveIsOneHundredTwenty() {
        assertFactorialEquals(5, 120);
    }

    @Test
    public void factorialOfTenIs3628800() {
        assertFactorialEquals(10, 3628800);
    }

    @Test
    public void factorialOfOneHundred() {
        BigInteger factorial = factorialCalculator.calculate(100);
        // Verify no overflow occurred
        assertTrue(factorial.signum() > 0);
    }

    private void assertFactorialEquals(int number, int expectedFactorial) {
        BigInteger calculatedFactorial = factorialCalculator.calculate(number);
        assertTrue(calculatedFactorial.equals(BigInteger.valueOf(expectedFactorial)));
    }

}