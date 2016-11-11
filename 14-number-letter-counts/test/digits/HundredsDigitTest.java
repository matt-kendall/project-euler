package digits;

import exception.NotADigitException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Tests for Hundreds digits.
 */
public class HundredsDigitTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testDigitZero() {
        Digit hundredsDigit = new HundredsDigit(0);
        assertEquals("", hundredsDigit.asText());
    }

    @Test
    public void testDigitOne() {
        Digit hundredsDigit = new HundredsDigit(1);
        assertEquals("one hundred", hundredsDigit.asText());
    }

    @Test
    public void testDigitTwo() {
        Digit hundredsDigit = new HundredsDigit(2);
        assertEquals("two hundred", hundredsDigit.asText());
    }

    @Test
    public void testDigitThree() {
        Digit hundredsDigit = new HundredsDigit(3);
        assertEquals("three hundred", hundredsDigit.asText());
    }

    @Test
    public void testDigitFour() {
        Digit hundredsDigit = new HundredsDigit(4);
        assertEquals("four hundred", hundredsDigit.asText());
    }

    @Test
    public void testDigitFive() {
        Digit hundredsDigit = new HundredsDigit(5);
        assertEquals("five hundred", hundredsDigit.asText());
    }

    @Test
    public void testDigitSix() {
        Digit hundredsDigit = new HundredsDigit(6);
        assertEquals("six hundred", hundredsDigit.asText());
    }

    @Test
    public void testDigitSeven() {
        Digit hundredsDigit = new HundredsDigit(7);
        assertEquals("seven hundred", hundredsDigit.asText());
    }

    @Test
    public void testDigitEight() {
        Digit hundredsDigit = new HundredsDigit(8);
        assertEquals("eight hundred", hundredsDigit.asText());
    }

    @Test
    public void testDigitNine() {
        Digit hundredsDigit = new HundredsDigit(9);
        assertEquals("nine hundred", hundredsDigit.asText());
    }

    @Test
    public void digitLessThanZeroThrowsNotADigitException() {
        expectedException.expect(NotADigitException.class);
        new HundredsDigit(-1);
    }

    @Test
    public void digitGreaterThanNineThrowsNotADigitException() {
        expectedException.expect(NotADigitException.class);
        new HundredsDigit(10);
    }

    @Test
    public void digitIsZeroThenIsNotEmptyReturnsFalse() {
        Digit zeroDigit = new HundredsDigit(0);
        assertFalse(zeroDigit.isNotEmpty());
    }

    @Test
    public void digitIsOneThenIsEmptyReturnsTrue() {
        Digit zeroDigit = new HundredsDigit(1);
        assertTrue(zeroDigit.isNotEmpty());
    }

    @Test
    public void canGetDigitValue() {
        Digit digit = new HundredsDigit(1);
        assertEquals(1, digit.digitValue());
    }
}