package digits;

import java.util.HashMap;
import java.util.Map;

/**
 * A digit of place value 10.
 */
public final class TensDigit extends BaseDigit {

    /**
     * Create a new digit.
     * Note that this is the digit itself, not its numerical value. E.g. if this digit represents 40 (or four tens),
     * the value of digitValue should be 4.
     * @param digitValue the value of this digit (e.g. 4) - must be in the range 0 - 9
     */
    public TensDigit(int digitValue) {
        super(digitValue);
    }

    @Override
    protected Map<Integer, String> createTextValuesMap() {
        Map<Integer, String> textValues = new HashMap<>();
        textValues.put(0, "");
        textValues.put(1, "ten");
        textValues.put(2, "twenty");
        textValues.put(3, "thirty");
        textValues.put(4, "forty");
        textValues.put(5, "fifty");
        textValues.put(6, "sixty");
        textValues.put(7, "seventy");
        textValues.put(8, "eighty");
        textValues.put(9, "ninety");
        return textValues;
    }
}
