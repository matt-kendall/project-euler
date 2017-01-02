package math;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test the digit summation.
 */
public class DigitSumCalculatorTest {

    private DigitSumCalculator digitSumCalculator;
    
    @Before
    public void onSetUp() {
        digitSumCalculator = new DigitSumCalculator();
    }
    
    @Test
    public void canCalculateSumOfZero() {
        assertDigitSum(0, 0);
    }
    
    @Test
    public void canCalculateSumOfOne() {
        assertDigitSum(1, 1);
    }

    @Test
    public void canCalculateSumOfFive() {
        assertDigitSum(5, 5);
    }

    @Test
    public void canCalculateSumOfTen() {
        assertDigitSum(10, 1);
    }

    @Test
    public void canCalculateSumOfOneHundredAndOne() {
        assertDigitSum(101, 2);
    }

    @Test
    public void canCalculateSumOfOneHundredTwentySeven() {
        assertDigitSum(127, 10);
    }
    
    private void assertDigitSum(int digits, int expectedSum) {
        int calculatedSum = digitSumCalculator.sumDigits(digits);
        assertEquals(expectedSum, calculatedSum);
    }
    
}