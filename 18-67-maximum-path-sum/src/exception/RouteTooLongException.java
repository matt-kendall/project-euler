package exception;

/**
 * Exception for the case where the route is too long for a given triangle.
 */
public class RouteTooLongException extends RuntimeException {

    /**
     * Create a new RouteTooLongException with a given message.
     * @param message exception message
     */
    public RouteTooLongException(String message) {
        super(message);
    }
}
