package exception;

/**
 * A triangle is only valid if it contains rows for values 1 - N in sequential order.
 */
public class InvalidTriangleException extends RuntimeException {

    /**
     * Create a new InvalidTriangleException.
     */
    public InvalidTriangleException() {
        super("Triangle must be made of at least one row in sequential size order from 1 - N");
    }
}
