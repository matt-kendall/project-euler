package exception;

/**
 * A triangle is only valid if it contains rows for values 1 - N in sequential order.
 */
public class InvalidTriangleException extends RuntimeException {

    /**
     * Create a new InvalidTriangleException with a given message.
     * @param message exception message
     */
    public InvalidTriangleException(String message) {
        super(message);
    }
}
