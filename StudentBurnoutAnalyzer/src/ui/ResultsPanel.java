/**
 * Results display panel shown in the EAST region of the main frame.
 * Displays computed burnout metrics in titled, bordered sections:
 *
 * - Burnout Score: large numeric display
 * - Risk Level: text label with color coding (green/orange/red/dark red)
 * - Recommendation: word-wrapped text area with scroll
 * - Warning: contextual text based on risk level
 *
 * The panel uses BoxLayout Y_AXIS to stack sections vertically with
 * consistent spacing. Colors update automatically based on risk level.
 */
package ui;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

public class ResultsPanel extends JPanel {

    private JLabel scoreValueLabel;
    private JLabel riskValueLabel;
    private JTextArea recommendationArea;
    private JLabel warningValueLabel;

    /** Constructs the results panel with four metric sections and a glue spacer. */
    public ResultsPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Analysis Results",
                TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION,
                new Font("SansSerif", Font.BOLD, 14)),
            BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));
        setPreferredSize(new Dimension(280, 0));

        add(createScoreSection());
        add(Box.createVerticalStrut(10));
        add(createRiskSection());
        add(Box.createVerticalStrut(10));
        add(createRecommendationSection());
        add(Box.createVerticalStrut(10));
        add(createWarningSection());
        add(Box.createVerticalGlue());
    }

    /**
     * Creates the Burnout Score section with a large centered numeric label.
     *
     * @return a JPanel containing the score display
     */
    private JPanel createScoreSection() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Burnout Score"));

        scoreValueLabel = new JLabel("0.0", SwingConstants.CENTER);
        scoreValueLabel.setFont(new Font("SansSerif", Font.BOLD, 28));
        panel.add(scoreValueLabel, BorderLayout.CENTER);
        return panel;
    }

    /**
     * Creates the Risk Level section with a color-coded label.
     *
     * @return a JPanel containing the risk level display
     */
    private JPanel createRiskSection() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Risk Level"));

        riskValueLabel = new JLabel("LOW", SwingConstants.CENTER);
        riskValueLabel.setFont(new Font("SansSerif", Font.BOLD, 22));
        riskValueLabel.setForeground(new Color(0, 150, 0));
        panel.add(riskValueLabel, BorderLayout.CENTER);
        return panel;
    }

    /**
     * Creates the Recommendation section with a word-wrapping read-only text area.
     *
     * @return a JPanel containing the recommendation display
     */
    private JPanel createRecommendationSection() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Recommendation"));

        recommendationArea = new JTextArea("Waiting for analysis...");
        recommendationArea.setEditable(false);
        recommendationArea.setLineWrap(true);
        recommendationArea.setWrapStyleWord(true);
        recommendationArea.setFont(new Font("SansSerif", Font.PLAIN, 12));
        recommendationArea.setRows(4);

        JScrollPane scrollPane = new JScrollPane(recommendationArea);
        scrollPane.setPreferredSize(new Dimension(250, 80));
        panel.add(scrollPane, BorderLayout.CENTER);
        return panel;
    }

    /**
     * Creates the Warning section with a color-coded label.
     *
     * @return a JPanel containing the warning display
     */
    private JPanel createWarningSection() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Warning"));

        warningValueLabel = new JLabel("None", SwingConstants.CENTER);
        warningValueLabel.setFont(new Font("SansSerif", Font.BOLD, 12));
        warningValueLabel.setForeground(new Color(0, 150, 0));
        panel.add(warningValueLabel, BorderLayout.CENTER);
        return panel;
    }

    /**
     * Updates all four result sections with newly computed values.
     * Colors are automatically adjusted based on the risk level.
     *
     * @param score          the burnout score to display
     * @param riskLevel      the risk level label
     * @param recommendation the recommendation text
     */
    public void updateResults(double score, String riskLevel, String recommendation) {
        scoreValueLabel.setText(String.format("%.1f", score));

        riskValueLabel.setText(riskLevel);
        riskValueLabel.setForeground(getRiskColor(riskLevel));

        recommendationArea.setText(recommendation);

        warningValueLabel.setText(getWarningText(riskLevel));
        warningValueLabel.setForeground(getRiskColor(riskLevel));
    }

    /**
     * Resets all result displays to their default/initial state.
     * Called when the Clear Form button is clicked.
     */
    public void resetResults() {
        scoreValueLabel.setText("0.0");
        riskValueLabel.setText("LOW");
        riskValueLabel.setForeground(new Color(0, 150, 0));
        recommendationArea.setText("Waiting for analysis...");
        warningValueLabel.setText("None");
        warningValueLabel.setForeground(new Color(0, 150, 0));
    }

    /**
     * Returns the display color associated with a given risk level.
     *
     * @param riskLevel the risk level label (case-insensitive)
     * @return green for LOW, orange for MODERATE, red for HIGH, dark red for CRITICAL
     */
    private Color getRiskColor(String riskLevel) {
        switch (riskLevel.toUpperCase()) {
            case "LOW":      return new Color(0, 150, 0);
            case "MODERATE": return new Color(230, 140, 0);
            case "HIGH":     return new Color(200, 30, 30);
            case "CRITICAL": return new Color(120, 0, 0);
            default:         return Color.BLACK;
        }
    }

    /**
     * Returns the contextual warning text for a given risk level.
     *
     * @param riskLevel the risk level label (case-insensitive)
     * @return a human-readable warning string
     */
    private String getWarningText(String riskLevel) {
        switch (riskLevel.toUpperCase()) {
            case "LOW":      return "None. You are maintaining good balance.";
            case "MODERATE": return "Mild concern. Consider adjusting your schedule.";
            case "HIGH":     return "Warning: Potential burnout detected.";
            case "CRITICAL": return "Critical: Immediate action required.";
            default:         return "None";
        }
    }
}
