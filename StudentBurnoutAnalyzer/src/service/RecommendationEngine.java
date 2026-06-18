/**
 * Generates personalized textual recommendations for students based on their
 * daily activity data and computed burnout risk level. Currently returns a
 * default recommendation; can be extended with risk-level-specific advice.
 */
package service;

import model.DailyRecord;

public class RecommendationEngine {

    /**
     * Generates a recommendation string tailored to the student's DailyRecord.
     * The recommendation can vary based on burnout score, risk level, and
     * individual activity values.
     *
     * @param record the daily record containing activity data and computed metrics
     * @return a human-readable recommendation string
     */
    public String generateRecommendation(DailyRecord record) {
        // TODO: implement logic to tailor recommendation based on record data
        return "Maintain a balanced schedule with adequate study, sleep, and exercise.";
    }
}
