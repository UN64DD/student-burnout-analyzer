/**
 * Provides methods for calculating a student's burnout score based on
 * their daily activity data. Demonstrates method overloading by supporting
 * calculations with varying levels of available input data.
 *
 * The primary formula: score = (studyHours * 6) - (sleepHours * 3) -
 * (exerciseHours * 2) + (assignmentCount * 3). The result is clamped to [0, 100].
 */
package service;

import model.DailyRecord;

public class BurnoutCalculator {

    /** Maximum possible burnout score. */
    private static final double MAX_SCORE = 100.0;

    /**
     * Calculates burnout score from a complete DailyRecord object using the
     * full formula: study hours increase burnout while sleep and exercise
     * decrease it; assignment count adds pressure.
     *
     * @param record the daily record containing all activity data
     * @return the computed burnout score clamped to [0, 100]
     */
    public double calculateBurnout(DailyRecord record) {
        double studyHours = record.getStudyHours();
        double sleepHours = record.getSleepHours();
        double exerciseHours = record.getExerciseHours();
        int assignmentCount = record.getAssignmentCount();

        double score = (studyHours * 6.0)
                     - (sleepHours * 3.0)
                     - (exerciseHours * 2.0)
                     + (assignmentCount * 3.0);

        score = Math.max(0, Math.min(MAX_SCORE, score));
        return score;
    }

    /**
     * Calculates a preliminary burnout score using only study hours.
     * Useful for quick estimates when only study data is available.
     *
     * @param studyHours the number of hours spent studying
     * @return the computed burnout score clamped to [0, 100]
     */
    public double calculateBurnout(int studyHours) {
        double score = studyHours * 6.0;
        return Math.max(0, Math.min(MAX_SCORE, score));
    }

    /**
     * Calculates a burnout score using study and sleep hours.
     * Accounts for the balancing effect of sleep on study-induced burnout.
     *
     * @param studyHours the number of hours spent studying
     * @param sleepHours the number of hours spent sleeping
     * @return the computed burnout score clamped to [0, 100]
     */
    public double calculateBurnout(int studyHours, int sleepHours) {
        double score = (studyHours * 6.0) - (sleepHours * 3.0);
        return Math.max(0, Math.min(MAX_SCORE, score));
    }
}
