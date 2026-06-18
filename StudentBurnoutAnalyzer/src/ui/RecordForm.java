/**
 * Input form panel that collects daily activity data from the user.
 * Uses a card-like layout with GridBagLayout for neatly aligned label-field pairs.
 *
 * The form contains:
 * - Four text fields: Study Hours, Sleep Hours, Exercise Hours, Assignment Count
 * - Three action buttons: Analyze Burnout, Save Record, Clear Form
 * - Tooltips on all input fields
 *
 * On "Analyze Burnout": validates input via ValidationUtil, creates a DailyRecord,
 * calculates burnout via BurnoutCalculator, determines risk level, generates a
 * recommendation via RecommendationEngine, and passes results to the AnalysisCallback.
 *
 * On "Clear Form": resets all input fields and invokes the clearCallback Runnable
 * to reset the ResultsPanel.
 */
package ui;

import model.DailyRecord;
import service.BurnoutCalculator;
import service.RecommendationEngine;
import util.ValidationUtil;
import exception.InvalidHoursException;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

public class RecordForm extends JPanel {

    private JTextField studyField;
    private JTextField sleepField;
    private JTextField exerciseField;
    private JTextField assignmentField;
    private JButton analyzeButton;
    private JButton saveButton;
    private JButton clearButton;

    private ValidationUtil validationUtil;
    private BurnoutCalculator burnoutCalculator;
    private RecommendationEngine recommendationEngine;
    private AnalysisCallback callback;
    private Runnable clearCallback;

    /**
     * Constructs the RecordForm with callbacks for communicating results.
     *
     * @param callback      invoked when analysis completes with score, risk, recommendation
     * @param clearCallback invoked when the Clear Form button is clicked
     */
    public RecordForm(AnalysisCallback callback, Runnable clearCallback) {
        this.callback = callback;
        this.clearCallback = clearCallback;
        validationUtil = new ValidationUtil();
        burnoutCalculator = new BurnoutCalculator();
        recommendationEngine = new RecommendationEngine();

        setLayout(new GridBagLayout());
        setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createTitledBorder("Daily Activity Input"),
            BorderFactory.createEmptyBorder(15, 15, 15, 15)
        ));

        initFields();
        initButtons();
    }

    /**
     * Creates the label-field pairs using GridBagLayout.
     * Labels are right-aligned (EAST) and fields expand horizontally (HORIZONTAL fill).
     * Each field has a tooltip for user guidance.
     */
    private void initFields() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6, 8, 6, 8);

        Font labelFont = new Font("SansSerif", Font.PLAIN, 13);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0.0;
        JLabel studyLabel = new JLabel("Study Hours:");
        studyLabel.setFont(labelFont);
        add(studyLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        studyField = new JTextField(15);
        studyField.setToolTipText("Total study hours today");
        add(studyField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0.0;
        JLabel sleepLabel = new JLabel("Sleep Hours:");
        sleepLabel.setFont(labelFont);
        add(sleepLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        sleepField = new JTextField(15);
        sleepField.setToolTipText("Hours slept last night");
        add(sleepField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0.0;
        JLabel exerciseLabel = new JLabel("Exercise Hours:");
        exerciseLabel.setFont(labelFont);
        add(exerciseLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        exerciseField = new JTextField(15);
        exerciseField.setToolTipText("Physical activity duration");
        add(exerciseField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0.0;
        JLabel assignmentLabel = new JLabel("Assignment Count:");
        assignmentLabel.setFont(labelFont);
        add(assignmentLabel, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        assignmentField = new JTextField(15);
        assignmentField.setToolTipText("Number of active assignments");
        add(assignmentField, gbc);
    }

    /**
     * Creates the action button row with consistent sizing and spacing.
     * Buttons are placed in a FlowLayout panel centered below the input fields.
     */
    private void initButtons() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;
        gbc.insets = new Insets(12, 8, 4, 8);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        buttonPanel.setOpaque(false);

        // Uniform button size for a professional look
        Dimension buttonSize = new Dimension(130, 32);

        analyzeButton = new JButton("Analyze Burnout");
        analyzeButton.setPreferredSize(buttonSize);
        analyzeButton.setMinimumSize(buttonSize);
        analyzeButton.addActionListener(e -> handleAnalyze());
        buttonPanel.add(analyzeButton);

        saveButton = new JButton("Save Record");
        saveButton.setPreferredSize(buttonSize);
        saveButton.setMinimumSize(buttonSize);
        saveButton.addActionListener(e -> handleSave());
        buttonPanel.add(saveButton);

        clearButton = new JButton("Clear Form");
        clearButton.setPreferredSize(buttonSize);
        clearButton.setMinimumSize(buttonSize);
        clearButton.addActionListener(e -> handleClear());
        buttonPanel.add(clearButton);

        add(buttonPanel, gbc);

        // Vertical filler to push content to the top when the panel expands
        gbc.gridy = 5;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.VERTICAL;
        add(Box.createVerticalGlue(), gbc);
    }

    /** Placeholder for Save Record functionality. */
    private void handleSave() {
        // TODO: validate input, create DailyRecord, save via HistoryManager
    }

    /**
     * Main analysis workflow triggered by the Analyze Burnout button.
     * Flow: parse inputs -> validate -> create DailyRecord -> calculate burnout
     * -> determine risk level -> generate recommendation -> callback to display.
     * Errors are shown via JOptionPane error dialogs.
     */
    private void handleAnalyze() {
        try {
            double studyHours = parseDoubleField(studyField, "Study Hours");
            double sleepHours = parseDoubleField(sleepField, "Sleep Hours");
            double exerciseHours = parseDoubleField(exerciseField, "Exercise Hours");
            int assignmentCount = parseIntegerField(assignmentField, "Assignment Count");

            validationUtil.validateHours(studyHours);
            validationUtil.validateHours(sleepHours);
            validationUtil.validateHours(exerciseHours);
            validationUtil.validateAssignments(assignmentCount);

            DailyRecord record = new DailyRecord(studyHours, sleepHours, exerciseHours, assignmentCount);

            double burnoutScore = burnoutCalculator.calculateBurnout(record);

            String riskLevel = determineRiskLevel(burnoutScore);
            record.setBurnoutScore(burnoutScore);
            record.setRiskLevel(riskLevel);

            String recommendation = recommendationEngine.generateRecommendation(record);

            callback.onAnalysisComplete(burnoutScore, riskLevel, recommendation);

        } catch (InvalidHoursException e) {
            JOptionPane.showMessageDialog(this,
                "Invalid input: " + e.getMessage(),
                "Validation Error",
                JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                "Please enter valid numeric values for all fields.",
                "Input Error",
                JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this,
                "Invalid input: " + e.getMessage(),
                "Validation Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Clears all input fields and resets the ResultsPanel via the clear callback.
     */
    private void handleClear() {
        studyField.setText("");
        sleepField.setText("");
        exerciseField.setText("");
        assignmentField.setText("");
        if (clearCallback != null) {
            clearCallback.run();
        }
    }

    /**
     * Parses a JTextField as a double. Throws NumberFormatException if the
     * field is empty, contains non-numeric content, or holds a negative value.
     *
     * @param field     the text field to parse
     * @param fieldName the display name of the field (for error messages)
     * @return the parsed double value
     * @throws NumberFormatException if validation fails
     */
    private double parseDoubleField(JTextField field, String fieldName) {
        String text = field.getText().trim();
        if (text.isEmpty()) {
            throw new NumberFormatException(fieldName + " is empty");
        }
        double value = Double.parseDouble(text);
        if (value < 0) {
            throw new NumberFormatException(fieldName + " cannot be negative");
        }
        return value;
    }

    /**
     * Parses a JTextField as an integer. Throws NumberFormatException if the
     * field is empty, contains non-numeric content, or holds a negative value.
     *
     * @param field     the text field to parse
     * @param fieldName the display name of the field (for error messages)
     * @return the parsed integer value
     * @throws NumberFormatException if validation fails
     */
    private int parseIntegerField(JTextField field, String fieldName) {
        String text = field.getText().trim();
        if (text.isEmpty()) {
            throw new NumberFormatException(fieldName + " is empty");
        }
        int value = Integer.parseInt(text);
        if (value < 0) {
            throw new NumberFormatException(fieldName + " cannot be negative");
        }
        return value;
    }

    /**
     * Maps a numerical burnout score to a human-readable risk level label.
     *
     * @param score the burnout score (0.0 - 100.0)
     * @return "Critical" for 80+, "High" for 60-79, "Moderate" for 30-59, "Low" for below 30
     */
    private String determineRiskLevel(double score) {
        if (score >= 80) return "Critical";
        if (score >= 60) return "High";
        if (score >= 30) return "Moderate";
        return "Low";
    }
}
