package number;

import exception.NotThreeDigitsException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

/**
 * Test that the Number Decomposer can correctly convert primitive numbers into ThreeDigitNumbers.
 */
public class NumberDecomposerTest {

    private NumberDecomposer numberDecomposer;

    @Before
    public void setUp() {
        numberDecomposer = new NumberDecomposer();
    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void ifNumberIsLessThanZeroThrowsNotThreeDigitsException() throws NotThreeDigitsException {
        expectedException.expect(NotThreeDigitsException.class);
        numberDecomposer.decompose(-1);
    }

    @Test
    public void ifNumberIsZeroThrowsNotThreeDigitsException() throws NotThreeDigitsException {
        expectedException.expect(NotThreeDigitsException.class);
        numberDecomposer.decompose(0);
    }

    @Test
    public void ifNumberIsOneThousandThrowsNotThreeDigitsException() throws NotThreeDigitsException {
        expectedException.expect(NotThreeDigitsException.class);
        numberDecomposer.decompose(1000);
    }

    @Test
    public void canDecomposeNumberOne() throws NotThreeDigitsException {
        ThreeDigitNumber number = numberDecomposer.decompose(1);
        assertEquals(0, number.hundreds().digitValue());
        assertEquals(0, number.tens().digitValue());
        assertEquals(1, number.units().digitValue());
    }

    @Test
    public void canDecomposeNumberTwenty() throws NotThreeDigitsException {
        ThreeDigitNumber number = numberDecomposer.decompose(20);
        assertEquals(0, number.hundreds().digitValue());
        assertEquals(2, number.tens().digitValue());
        assertEquals(0, number.units().digitValue());
    }

    @Test
    public void canDecomposeNumberThreeHundred() throws NotThreeDigitsException {
        ThreeDigitNumber number = numberDecomposer.decompose(300);
        assertEquals(3, number.hundreds().digitValue());
        assertEquals(0, number.tens().digitValue());
        assertEquals(0, number.units().digitValue());
    }

    @Test
    public void canDecomposeNumberOneHundredAndTwentyThree() throws NotThreeDigitsException {
        ThreeDigitNumber number = numberDecomposer.decompose(123);
        assertEquals(1, number.hundreds().digitValue());
        assertEquals(2, number.tens().digitValue());
        assertEquals(3, number.units().digitValue());
    }

    @Test
    public void canDecomposeNumberNineHundredNinetyNine() throws NotThreeDigitsException {
        ThreeDigitNumber number = numberDecomposer.decompose(999);
        assertEquals(9, number.hundreds().digitValue());
        assertEquals(9, number.tens().digitValue());
        assertEquals(9, number.units().digitValue());
    }
}