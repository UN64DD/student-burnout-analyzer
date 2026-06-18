/**
 * Represents a study-related activity. Extends the Activity base class
 * and provides the specific calculation logic for how study hours
 * contribute to a student's burnout level.
 */
package model;

public class StudyActivity extends Activity {

    /**
     * Constructs a StudyActivity with the specified hours.
     *
     * @param hours the number of hours spent studying
     */
    public StudyActivity(double hours) {
        super(hours);
    }

    /**
     * Calculates the burnout impact of study hours.
     * Higher study hours generally increase the burnout score.
     *
     * @return the calculated impact value
     */
    @Override
    public double calculateImpact() {
        // TODO: implement actual burnout impact calculation for study activity
        return 0.0;
    }
}
