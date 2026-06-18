/**
 * Entry point for the Student Burnout & Productivity Analyzer application.
 * Launches the main GUI window on the Event Dispatch Thread (EDT)
 * to ensure thread-safe Swing component creation.
 */
package app;

import ui.MainFrame;
import javax.swing.SwingUtilities;

public class Main {

    /**
     * Application entry point.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MainFrame();
        });
    }
}
