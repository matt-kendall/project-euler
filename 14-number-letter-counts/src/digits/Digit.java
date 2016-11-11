package digits;

/**
 * Represents a digit in a number (e.g hundreds, tens, thousands).
 */
public interface Digit {

    /**
     * The value of this digit (0 - 9)
     * @return digit value
     */
    int digitValue();

    /**
     * A textual representation of the digit.
     * @return digit in text form
     */
    String asText();

    /**
     * Does this digit have any value or is it a placeholder? i.e. is it zero?
     * @return true if non-zero, false otherwise
     */
    boolean isNotEmpty();

}
