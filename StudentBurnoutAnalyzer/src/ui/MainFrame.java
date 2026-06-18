/**
 * Main application window for the Student Burnout & Productivity Analyzer.
 * Uses a BorderLayout with three main regions:
 * - NORTH: styled header panel (title + subtitle on dark blue background)
 * - CENTER: RecordForm input panel (centered via GridBagLayout wrapper)
 * - EAST: ResultsPanel displaying computed burnout metrics
 *
 * The ResultsPanel and RecordForm are wired together via AnalysisCallback
 * and a Runnable clear callback, keeping them decoupled.
 */
package ui;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagLayout;

public class MainFrame extends JFrame {

    /**
     * Constructs the main frame, initializes the menu bar, layout regions,
     * and makes the window visible.
     */
    public MainFrame() {
        setTitle("Student Burnout & Productivity Analyzer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setMinimumSize(new java.awt.Dimension(750, 500));
        setLocationRelativeTo(null);

        initMenuBar();
        initComponents();

        setVisible(true);
    }

    /** Builds the File and Analysis menus. */
    private void initMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> System.exit(0));
        fileMenu.add(exitItem);
        menuBar.add(fileMenu);

        JMenu analysisMenu = new JMenu("Analysis");
        JMenuItem aboutItem = new JMenuItem("About");
        aboutItem.addActionListener(e -> handleAbout());
        analysisMenu.add(aboutItem);
        menuBar.add(analysisMenu);

        setJMenuBar(menuBar);
    }

    /**
     * Lays out the three main regions:
     * NORTH - dark blue header with title and subtitle
     * CENTER - RecordForm wrapped in a GridBagLayout panel (centers the form)
     * EAST - ResultsPanel showing burnout score, risk, recommendation, warning
     */
    private void initComponents() {
        setLayout(new BorderLayout());

        add(createHeaderPanel(), BorderLayout.NORTH);

        ResultsPanel resultsPanel = new ResultsPanel();
        add(resultsPanel, BorderLayout.EAST);

        // Wire RecordForm input to ResultsPanel output via callbacks
        RecordForm recordForm = new RecordForm((score, risk, rec) ->
            resultsPanel.updateResults(score, risk, rec),
            () -> resultsPanel.resetResults()
        );

        JPanel centerWrapper = new JPanel(new GridBagLayout());
        centerWrapper.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 10));
        centerWrapper.add(recordForm);
        add(centerWrapper, BorderLayout.CENTER);
    }

    /**
     * Creates the dark navy header with the application title and subtitle.
     *
     * @return a configured JPanel suitable for BorderLayout.NORTH
     */
    private JPanel createHeaderPanel() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.Y_AXIS));
        header.setBackground(new Color(25, 55, 105));
        header.setOpaque(true);
        header.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        JLabel title = new JLabel("Student Burnout & Productivity Analyzer");
        title.setFont(new Font("SansSerif", Font.BOLD, 22));
        title.setForeground(Color.WHITE);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel subtitle = new JLabel("Track your academic wellness and prevent burnout.");
        subtitle.setFont(new Font("SansSerif", Font.PLAIN, 13));
        subtitle.setForeground(new Color(160, 188, 225));
        subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        header.add(title);
        header.add(Box.createVerticalStrut(6));
        header.add(subtitle);
        return header;
    }

    /** Placeholder handler for the About menu item. */
    private void handleAbout() {
        // stub
    }
}
