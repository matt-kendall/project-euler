package number;

import digits.Digit;
import digits.HundredsDigit;
import digits.TensDigit;
import digits.UnitDigit;
import exception.NotThreeDigitsException;

/**
 * Can decompose a number in the range 1 - 999 into constituent hundreds, tens, thousands as a ThreeDigitNumber.
 */
public final class NumberDecomposer {

    private static final int MIN_THREE_DIGITS = 1;
    private static final int MAX_THREE_DIGITS = 999;

    /**
     * Decompose a number into its constituent digits (hundreds, tens, thousands).
     * The number must be in the range 1 - 999).
     * @param number number to decompose
     * @return ThreeDigitNumber
     * @throws NotThreeDigitsException if the number is not in the range 1 - 999
     */
    public ThreeDigitNumber decompose(int number) throws NotThreeDigitsException {
        if (number < MIN_THREE_DIGITS || number > MAX_THREE_DIGITS) {
            throw new NotThreeDigitsException(number);
        }

        // The units is the remainder when the number is divided by 10
        // eg. 623 % 10 = 3
        int units = number % 10;
        // To calculate tens, subtract the units so it can be divided by 10.
        // Then identify the remainder
        // e.g. 623 - 3 = 620; 620 / 10 = 62; 62 % 10 = 2
        int tens = ((number - units) / 10) % 10;
        // To calculate hundreds, subtract the remainder so it can be divided by 100.
        // e.g. 623 - 23 = 600; 600 / 100 = 6
        int hundreds = (number - number % 100) / 100;

        Digit hundredsDigit = new HundredsDigit(hundreds);
        Digit tensDigit = new TensDigit(tens);
        Digit unitsDigit = new UnitDigit(units);

        return new ThreeDigitNumber(hundredsDigit, tensDigit, unitsDigit);
    }
}
