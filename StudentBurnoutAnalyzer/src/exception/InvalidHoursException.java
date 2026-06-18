/**
 * Custom exception thrown when an invalid number of hours is provided
 * for any activity (e.g., negative values or values exceeding 24 hours).
 * This is a checked exception, ensuring callers handle validation errors.
 */
package exception;

public class InvalidHoursException extends Exception {

    /**
     * Constructs an InvalidHoursException with a descriptive message.
     *
     * @param message the detail message explaining the validation failure
     */
    public InvalidHoursException(String message) {
        super(message);
    }
}
