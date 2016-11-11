package exception;

/**
 * Exception for the case where a number with too many digits is being decomposed.
 */
public class NotThreeDigitsException extends Exception {

    /**
     * Construct a NotThreeDigitsException by providing the offending number.
     * @param number number which is not three digits
     */
    public NotThreeDigitsException(int number) {
        super(String.format("%d is not a three digit number (should be in the range 1 - 999)", number));
    }


    /**
     * Construct a NotThreeDigitsException by providing a custom message.
     * @param message exception message
     */
    public NotThreeDigitsException(String message) {
        super(message);
    }
}
