package exception;

/**
 * Exception for the case where an invalid digit has been used (not in the range 0 - 9).
 */
public class NotADigitException extends RuntimeException {

    /**
     * Construct a NotADigitException by providing the offending 'digit'.
     * @param digit number which is not a digit
     */
    public NotADigitException(int digit) {
        super(String.format("'%d' is not a valid digit (should be in the range 0 - 9)", digit));
    }

    /**
     * Construct a NotADigitException by providing a custom message.
     * @param message exception message
     */
    public NotADigitException(String message) {
        super(message);
    }
}
