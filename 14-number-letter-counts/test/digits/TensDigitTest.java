package digits;

import exception.NotADigitException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Tests for Unit digits.
 */
public class TensDigitTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testDigitZero() {
        Digit tensDigit = new TensDigit(0);
        assertEquals("", tensDigit.asText());
    }

    @Test
    public void testDigitOne() {
        Digit tensDigit = new TensDigit(1);
        assertEquals("ten", tensDigit.asText());
    }

    @Test
    public void testDigitTwo() {
        Digit tensDigit = new TensDigit(2);
        assertEquals("twenty", tensDigit.asText());
    }

    @Test
    public void testDigitThree() {
        Digit tensDigit = new TensDigit(3);
        assertEquals("thirty", tensDigit.asText());
    }

    @Test
    public void testDigitFour() {
        Digit tensDigit = new TensDigit(4);
        assertEquals("forty", tensDigit.asText());
    }

    @Test
    public void testDigitFive() {
        Digit tensDigit = new TensDigit(5);
        assertEquals("fifty", tensDigit.asText());
    }

    @Test
    public void testDigitSix() {
        Digit tensDigit = new TensDigit(6);
        assertEquals("sixty", tensDigit.asText());
    }

    @Test
    public void testDigitSeven() {
        Digit tensDigit = new TensDigit(7);
        assertEquals("seventy", tensDigit.asText());
    }

    @Test
    public void testDigitEight() {
        Digit tensDigit = new TensDigit(8);
        assertEquals("eighty", tensDigit.asText());
    }

    @Test
    public void testDigitNine() {
        Digit tensDigit = new TensDigit(9);
        assertEquals("ninety", tensDigit.asText());
    }

    @Test
    public void digitLessThanZeroThrowsNotADigitException() {
        expectedException.expect(NotADigitException.class);
        new TensDigit(-1);
    }

    @Test
    public void digitGreaterThanNineThrowsNotADigitException() {
        expectedException.expect(NotADigitException.class);
        new TensDigit(10);
    }

    @Test
    public void digitIsZeroThenIsNotEmptyReturnsFalse() {
        Digit zeroDigit = new TensDigit(0);
        assertFalse(zeroDigit.isNotEmpty());
    }

    @Test
    public void digitIsOneThenIsEmptyReturnsTrue() {
        Digit zeroDigit = new TensDigit(1);
        assertTrue(zeroDigit.isNotEmpty());
    }

    @Test
    public void canGetDigitValue() {
        Digit digit = new TensDigit(8);
        assertEquals(8, digit.digitValue());
    }
}