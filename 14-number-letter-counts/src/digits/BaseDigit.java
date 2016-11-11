package digits;

import exception.NotADigitException;

import java.util.Map;

/**
 * Common digit functionality.
 */
public abstract class BaseDigit implements Digit {

    private final Integer digitValue;
    private final Map<Integer, String> textValues;

    /**
     * Returns a map of digit value (1 - 9) against the string representation of that digit.
     * @return map of digit to string representation
     */
    protected abstract Map<Integer, String> createTextValuesMap();

    /**
     * Create a digit from a given value. The value should be in the range 0 - 9 (i.e. a single digit).
     * @param digitValue the value of this digit (not counting the place value, e.g. 10s, 100s
     */
    public BaseDigit(int digitValue) {
        textValues = createTextValuesMap();
        if (digitValue < 0 || digitValue > 9) {
            throw new NotADigitException(digitValue);
        } else {
            this.digitValue = digitValue;
        }
    }

    /**
     * Get the textual representation of this digit, given the place value of this digit and the digit itself.
     * @return the textual representation of this digit.
     */
    public final String asText() {
        return textValues.get(digitValue);
    }

    @Override
    public boolean isNotEmpty() {
        return digitValue != 0;
    }

    @Override
    public int digitValue() {
        return digitValue;
    }
}
