/**
 * Functional callback interface for communicating analysis results from
 * RecordForm to the ResultsPanel. Enables loose coupling between the
 * input form and the results display via the Observer pattern.
 */
package ui;

@FunctionalInterface
public interface AnalysisCallback {

    /**
     * Called when a burnout analysis completes successfully.
     *
     * @param score          the computed burnout score (0.0 - 100.0)
     * @param riskLevel      the determined risk level label
     * @param recommendation the generated recommendation text
     */
    void onAnalysisComplete(double score, String riskLevel, String recommendation);
}
