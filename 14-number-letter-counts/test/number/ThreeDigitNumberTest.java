package number;

import digits.Digit;
import digits.HundredsDigit;
import digits.TensDigit;
import digits.UnitDigit;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests for the ThreeDigitNumber class.
 */
public class ThreeDigitNumberTest {

    @Test
    public void testNumberOne() {
        ThreeDigitNumber number = makeNumber(0, 0, 1);
        assertEquals("one", number.asText());
    }

    @Test
    public void testNumberTen() {
        ThreeDigitNumber number = makeNumber(0, 1, 0);
        assertEquals("ten", number.asText());
    }

    @Test
    public void testNumberOneHundred() {
        ThreeDigitNumber number = makeNumber(1, 0, 0);
        assertEquals("one hundred", number.asText());
    }

    @Test
    public void testNumberOneHundredAndTen() {
        ThreeDigitNumber number = makeNumber(1, 1, 0);
        assertEquals("one hundred and ten", number.asText());
    }

    @Test
    public void testNumberOneHundredAndOne() {
        ThreeDigitNumber number = makeNumber(1, 0, 1);
        assertEquals("one hundred and one", number.asText());
    }

    @Test
    public void testNumberOneHundredAndTwentyOne() {
        ThreeDigitNumber number = makeNumber(1, 2, 1);
        assertEquals("one hundred and twenty-one", number.asText());
    }

    @Test
    public void testNumberNineHundredAndNinetyNine() {
        ThreeDigitNumber number = makeNumber(9, 9, 9);
        assertEquals("nine hundred and ninety-nine", number.asText());
    }

    @Test
    public void testNumberEleven() {
        ThreeDigitNumber number = makeNumber(0, 1, 1);
        assertEquals("eleven", number.asText());
    }

    @Test
    public void testNumberNineteen() {
        ThreeDigitNumber number = makeNumber(0, 1, 9);
        assertEquals("nineteen", number.asText());
    }

    @Test
    public void testNumberSixHundredAndSeventeen() {
        ThreeDigitNumber number = makeNumber(6, 1, 7);
        assertEquals("six hundred and seventeen", number.asText());
    }

    @Test
    public void canGetDigits() {
        ThreeDigitNumber number = makeNumber(1, 2, 3);
        assertEquals(1, number.hundreds().digitValue());
        assertEquals(2, number.tens().digitValue());
        assertEquals(3, number.units().digitValue());
    }

    private ThreeDigitNumber makeNumber(int hundreds, int tens, int units) {
        Digit hundredsDigit = new HundredsDigit(hundreds);
        Digit tensDigit = new TensDigit(tens);
        Digit unitsDigit = new UnitDigit(units);
        return new ThreeDigitNumber(hundredsDigit, tensDigit, unitsDigit);
    }

}