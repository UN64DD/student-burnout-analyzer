/**
 * Represents an exercise-related activity. Extends the Activity base class
 * and provides the specific calculation logic for how physical activity
 * influences a student's burnout level. Exercise typically reduces burnout.
 */
package model;

public class ExerciseActivity extends Activity {

    /**
     * Constructs an ExerciseActivity with the specified hours.
     *
     * @param hours the number of hours spent exercising
     */
    public ExerciseActivity(double hours) {
        super(hours);
    }

    /**
     * Calculates the burnout impact of exercise hours.
     * More exercise generally reduces the burnout score (negative impact).
     *
     * @return the calculated impact value
     */
    @Override
    public double calculateImpact() {
        // TODO: implement actual burnout impact calculation for exercise activity
        return 0.0;
    }
}
