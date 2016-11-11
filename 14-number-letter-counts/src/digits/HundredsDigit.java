package digits;

import java.util.HashMap;
import java.util.Map;

/**
 * A digit of place value 100.
 */
public final class HundredsDigit extends BaseDigit {

    /**
     * Create a new digit.
     * Note that this is the digit itself, not its numerical value. E.g. if this digit represents 600 (or six hundreds),
     * the value of digitValue should be 6.
     * @param digitValue the value of this digit (e.g. 6) - must be in the range 0 - 9
     */
    public HundredsDigit(int digitValue) {
        super(digitValue);
    }

    @Override
    protected Map<Integer, String> createTextValuesMap() {
        Map<Integer, String> textValues = new HashMap<>();
        textValues.put(0, "");
        textValues.put(1, "one hundred");
        textValues.put(2, "two hundred");
        textValues.put(3, "three hundred");
        textValues.put(4, "four hundred");
        textValues.put(5, "five hundred");
        textValues.put(6, "six hundred");
        textValues.put(7, "seven hundred");
        textValues.put(8, "eight hundred");
        textValues.put(9, "nine hundred");
        return textValues;
    }
}
