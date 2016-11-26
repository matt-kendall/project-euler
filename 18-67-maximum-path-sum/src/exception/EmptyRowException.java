package exception;

/**
 * For when a row is created in an invalid state.
 * The only circumstance in which a row can be invalid is when the row is empty.
 */
public class EmptyRowException extends RuntimeException {

    /**
     * Construct a new EmptyRowException.
     */
    public EmptyRowException() {
        super("Row must have at least one point");
    }
}
