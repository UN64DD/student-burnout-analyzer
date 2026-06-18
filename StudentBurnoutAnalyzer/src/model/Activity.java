/**
 * Abstract base class representing a daily student activity (study, sleep, exercise).
 * Uses the Template Method pattern: subclasses must implement calculateImpact()
 * to define their specific contribution to the burnout score.
 */
package model;

public abstract class Activity {

    /** Number of hours spent on this activity (e.g., 3.5 hours of study). */
    protected double hours;

    /**
     * Constructs an Activity with the specified hours.
     *
     * @param hours the number of hours spent on the activity
     */
    public Activity(double hours) {
        this.hours = hours;
    }

    /**
     * Returns the number of hours spent on this activity.
     *
     * @return the hours value
     */
    public double getHours() {
        return hours;
    }

    /**
     * Updates the number of hours spent on this activity.
     *
     * @param hours the new hours value
     */
    public void setHours(double hours) {
        this.hours = hours;
    }

    /**
     * Calculates this activity's specific impact on the student's burnout level.
     * Each subclass provides its own formula based on the type of activity.
     *
     * @return a double representing the calculated impact score
     */
    public abstract double calculateImpact();
}
