package digits;

import exception.NotADigitException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

/**
 * Tests for Unit digits.
 */
public class UnitDigitTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testDigitZero() {
        Digit unitDigit = new UnitDigit(0);
        assertEquals("", unitDigit.asText());
    }

    @Test
    public void testDigitOne() {
        Digit unitDigit = new UnitDigit(1);
        assertEquals("one", unitDigit.asText());
    }

    @Test
    public void testDigitTwo() {
        Digit unitDigit = new UnitDigit(2);
        assertEquals("two", unitDigit.asText());
    }

    @Test
    public void testDigitThree() {
        Digit unitDigit = new UnitDigit(3);
        assertEquals("three", unitDigit.asText());
    }

    @Test
    public void testDigitFour() {
        Digit unitDigit = new UnitDigit(4);
        assertEquals("four", unitDigit.asText());
    }

    @Test
    public void testDigitFive() {
        Digit unitDigit = new UnitDigit(5);
        assertEquals("five", unitDigit.asText());
    }

    @Test
    public void testDigitSix() {
        Digit unitDigit = new UnitDigit(6);
        assertEquals("six", unitDigit.asText());
    }

    @Test
    public void testDigitSeven() {
        Digit unitDigit = new UnitDigit(7);
        assertEquals("seven", unitDigit.asText());
    }

    @Test
    public void testDigitEight() {
        UnitDigit unitDigit = new UnitDigit(8);
        assertEquals("eight", unitDigit.asText());
    }

    @Test
    public void testDigitNine() {
        Digit unitDigit = new UnitDigit(9);
        assertEquals("nine", unitDigit.asText());
    }

    @Test
    public void digitLessThanZeroThrowsNotADigitException() {
        expectedException.expect(NotADigitException.class);
        new UnitDigit(-1);
    }

    @Test
    public void digitGreaterThanNineThrowsNotADigitException() {
        expectedException.expect(NotADigitException.class);
        new UnitDigit(10);
    }

    @Test
    public void digitIsZeroThenIsNotEmptyReturnsFalse() {
        Digit zeroDigit = new UnitDigit(0);
        assertFalse(zeroDigit.isNotEmpty());
    }

    @Test
    public void digitIsOneThenIsEmptyReturnsTrue() {
        Digit zeroDigit = new UnitDigit(1);
        assertTrue(zeroDigit.isNotEmpty());
    }

    @Test
    public void canGetDigitValue() {
        Digit digit = new UnitDigit(7);
        assertEquals(7, digit.digitValue());
    }
}