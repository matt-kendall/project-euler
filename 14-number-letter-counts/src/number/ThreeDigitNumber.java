package number;

import digits.Digit;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a number composed of 3 digits.
 */
public final class ThreeDigitNumber {

    private final Digit hundreds;
    private final Digit tens;
    private final Digit units;

    /**
     * Create a new three digit number.
     * @param hundreds hundreds (left most) digit
     * @param tens tens (middle) digit
     * @param units units (right most ) digit
     */
    public ThreeDigitNumber(Digit hundreds, Digit tens, Digit units) {
        this.hundreds = hundreds;
        this.tens = tens;
        this.units = units;
    }

    /**
     * Obtain the 'hundreds' digit of this three digit number.
     * @return hundreds digit
     */
    public final Digit hundreds() {
        return hundreds;
    }

    /**
     * Obtain the 'tens' digit of this three digit number.
     * @return tens digit
     */
    public final Digit tens() {
        return tens;
    }

    /**
     * Obtain the 'units' digit of this three digit number.
     * @return hundreds digit
     */
    public final Digit units() {
        return units;
    }

    /**
     * Obtain a textual representation of this number.
     *
     * @return this number as text
     */
    public String asText() {
        StringBuilder numberText = new StringBuilder();

        numberText.append(hundreds.asText());
        if (hundreds.isNotEmpty() && (tens.isNotEmpty() || units.isNotEmpty())) {
            numberText.append(" and ");
        }

        if (isTeen()) {
            numberText.append(getTeenComponent());
        } else {
            numberText.append(tens.asText());
            if (tens.isNotEmpty() && units.isNotEmpty()) {
                numberText.append("-");
            }
            numberText.append(units.asText());
        }

        return numberText.toString();
    }

    /**
     * Test for the special case where the tens and units are together a teen number (11 - 19).
     * @return true if this number has a 'teen' component, false otherwise
     */
    private boolean isTeen() {
        return tens.digitValue() == 1 && units.isNotEmpty();
    }

    /**
     * Return the teens component (composite of the tens and units digit when they are in the range 11 - 19).
     * It is a shame that this 'exception to the rule' code has to be written, but I'm not sure of a better
     * way to do this.
     * Assumes that the tens digit is one and the units digit is non zero (i.e. isTeem is True).
     * @return the teens component as text
     */
    private String getTeenComponent() {
        // Map the units onto the 'teen' component. The tens does not need to be considered
        // since we should have already checked that it is one.
        Map<Integer, String> teensAsText = new HashMap<>();
        teensAsText.put(1, "eleven");
        teensAsText.put(2, "twelve");
        teensAsText.put(3, "thirteen");
        teensAsText.put(4, "fourteen");
        teensAsText.put(5, "fifteen");
        teensAsText.put(6, "sixteen");
        teensAsText.put(7, "seventeen");
        teensAsText.put(8, "eighteen");
        teensAsText.put(9, "nineteen");

        return teensAsText.get(units.digitValue());
    }
}
