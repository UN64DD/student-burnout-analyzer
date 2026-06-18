/**
 * Represents a sleep-related activity. Extends the Activity base class
 * and provides the specific calculation logic for how sleep hours
 * affect a student's burnout level. Adequate sleep typically reduces burnout.
 */
package model;

public class SleepActivity extends Activity {

    /**
     * Constructs a SleepActivity with the specified hours.
     *
     * @param hours the number of hours spent sleeping
     */
    public SleepActivity(double hours) {
        super(hours);
    }

    /**
     * Calculates the burnout impact of sleep hours.
     * More sleep generally reduces the burnout score (negative impact).
     *
     * @return the calculated impact value
     */
    @Override
    public double calculateImpact() {
        // TODO: implement actual burnout impact calculation for sleep activity
        return 0.0;
    }
}
