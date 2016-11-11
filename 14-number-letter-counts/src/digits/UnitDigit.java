package digits;

import java.util.HashMap;
import java.util.Map;

/**
 * A digit of place value 1.
 */
public final class UnitDigit extends BaseDigit{

    /**
     * Create a new digit.
     * @param digitValue the value of this digit (e.g. 4) - must be in the range 0 - 9
     */
    public UnitDigit(int digitValue) {
        super(digitValue);
    }

    @Override
    protected Map<Integer, String> createTextValuesMap() {
        Map<Integer, String> textValues = new HashMap<>();
        textValues.put(0, "");
        textValues.put(1, "one");
        textValues.put(2, "two");
        textValues.put(3, "three");
        textValues.put(4, "four");
        textValues.put(5, "five");
        textValues.put(6, "six");
        textValues.put(7, "seven");
        textValues.put(8, "eight");
        textValues.put(9, "nine");
        return textValues;
    }

}
