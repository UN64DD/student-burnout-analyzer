/**
 * Utility class for validating user input before processing. Provides
 * validation for activity hours and assignment counts, throwing appropriate
 * exceptions when values fall outside acceptable ranges.
 */
package util;

import exception.InvalidHoursException;

public class ValidationUtil {

    /** Maximum allowed hours for any daily activity (24h in a day). */
    private static final double MAX_HOURS = 24.0;

    /** Maximum allowed assignment count. */
    private static final int MAX_ASSIGNMENTS = 50;

    /**
     * Validates that the given number of hours is within [0, MAX_HOURS].
     *
     * @param hours the hours value to validate
     * @throws InvalidHoursException if hours are negative or exceed MAX_HOURS
     */
    public void validateHours(double hours) throws InvalidHoursException {
        if (hours < 0) {
            throw new InvalidHoursException("Hours cannot be negative (got: " + hours + ")");
        }
        if (hours > MAX_HOURS) {
            throw new InvalidHoursException("Hours cannot exceed " + MAX_HOURS + " (got: " + hours + ")");
        }
    }

    /**
     * Validates that the given assignment count is within [0, MAX_ASSIGNMENTS].
     *
     * @param count the number of assignments to validate
     * @throws IllegalArgumentException if count is negative or exceeds MAX_ASSIGNMENTS
     */
    public void validateAssignments(int count) throws IllegalArgumentException {
        if (count < 0) {
            throw new IllegalArgumentException("Assignment count cannot be negative (got: " + count + ")");
        }
        if (count > MAX_ASSIGNMENTS) {
            throw new IllegalArgumentException("Assignment count cannot exceed " + MAX_ASSIGNMENTS + " (got: " + count + ")");
        }
    }
}
