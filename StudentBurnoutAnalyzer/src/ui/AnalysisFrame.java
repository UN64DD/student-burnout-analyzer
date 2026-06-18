/**
 * Secondary window that displays burnout analysis results in a scrollable
 * text area. Retained for backward compatibility; the main application now
 * uses ResultsPanel for inline display instead of opening a separate window.
 */
package ui;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;

public class AnalysisFrame extends JFrame {

    /** Text area for displaying analysis results. */
    private JTextArea resultArea;

    /** Constructs an empty AnalysisFrame. */
    public AnalysisFrame() {
        this("");
    }

    /**
     * Constructs an AnalysisFrame and immediately displays the given text.
     *
     * @param text the analysis results to display
     */
    public AnalysisFrame(String text) {
        setTitle("Burnout Analysis Results");
        setSize(500, 400);
        setLocationRelativeTo(null);

        initComponents();
        displayResults(text);

        setVisible(true);
    }

    /** Initializes the scrollable text area for result display. */
    private void initComponents() {
        resultArea = new JTextArea();
        resultArea.setEditable(false);
        resultArea.setLineWrap(true);
        resultArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(resultArea);
        add(scrollPane, BorderLayout.CENTER);
    }

    /**
     * Sets the text content to display in the result area.
     *
     * @param text the analysis results to show
     */
    public void displayResults(String text) {
        resultArea.setText(text);
    }
}
