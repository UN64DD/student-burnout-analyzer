/**
 * Core data object representing a single day's record of a student's activities
 * and computed burnout metrics. Acts as the data transfer object (DTO) between
 * the UI layer and service layer. Stores both raw inputs and computed results.
 */
package model;

public class DailyRecord {

    /** Hours the student spent studying. */
    private double studyHours;

    /** Hours the student slept. */
    private double sleepHours;

    /** Hours the student exercised. */
    private double exerciseHours;

    /** Number of assignments the student completed. */
    private int assignmentCount;

    /** Computed burnout score (0.0 - 100.0). Populated after analysis. */
    private double burnoutScore;

    /** Risk level label ("Low", "Moderate", "High", "Critical"). Populated after analysis. */
    private String riskLevel;

    /** Default constructor for creating an empty record. */
    public DailyRecord() {
    }

    /**
     * Constructs a DailyRecord with input fields only. Burnout score and risk
     * level are left at their defaults and must be set separately.
     *
     * @param studyHours      hours spent studying
     * @param sleepHours      hours spent sleeping
     * @param exerciseHours   hours spent exercising
     * @param assignmentCount number of assignments completed
     */
    public DailyRecord(double studyHours, double sleepHours,
                       double exerciseHours, int assignmentCount) {
        this.studyHours = studyHours;
        this.sleepHours = sleepHours;
        this.exerciseHours = exerciseHours;
        this.assignmentCount = assignmentCount;
    }

    /**
     * Constructs a fully populated DailyRecord including computed metrics.
     *
     * @param studyHours      hours spent studying
     * @param sleepHours      hours spent sleeping
     * @param exerciseHours   hours spent exercising
     * @param assignmentCount number of assignments completed
     * @param burnoutScore    computed burnout score
     * @param riskLevel       burnout risk level label
     */
    public DailyRecord(double studyHours, double sleepHours,
                       double exerciseHours, int assignmentCount,
                       double burnoutScore, String riskLevel) {
        this.studyHours = studyHours;
        this.sleepHours = sleepHours;
        this.exerciseHours = exerciseHours;
        this.assignmentCount = assignmentCount;
        this.burnoutScore = burnoutScore;
        this.riskLevel = riskLevel;
    }

    public double getStudyHours()           { return studyHours; }
    public void setStudyHours(double studyHours)  { this.studyHours = studyHours; }

    public double getSleepHours()           { return sleepHours; }
    public void setSleepHours(double sleepHours)  { this.sleepHours = sleepHours; }

    public double getExerciseHours()        { return exerciseHours; }
    public void setExerciseHours(double exerciseHours) { this.exerciseHours = exerciseHours; }

    public int getAssignmentCount()         { return assignmentCount; }
    public void setAssignmentCount(int assignmentCount) { this.assignmentCount = assignmentCount; }

    public double getBurnoutScore()         { return burnoutScore; }
    public void setBurnoutScore(double burnoutScore) { this.burnoutScore = burnoutScore; }

    public String getRiskLevel()            { return riskLevel; }
    public void setRiskLevel(String riskLevel) { this.riskLevel = riskLevel; }

    @Override
    public String toString() {
        return "DailyRecord{"
                + "studyHours=" + studyHours
                + ", sleepHours=" + sleepHours
                + ", exerciseHours=" + exerciseHours
                + ", assignmentCount=" + assignmentCount
                + ", burnoutScore=" + burnoutScore
                + ", riskLevel='" + riskLevel + '\''
                + '}';
    }
}
