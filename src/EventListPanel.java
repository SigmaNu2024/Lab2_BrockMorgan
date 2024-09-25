import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Comparator;

public class EventListPanel extends JPanel {
    private ArrayList<Event> events = new ArrayList<>(); // List of events
    private JPanel controlPanel = new JPanel(); // Control panel for buttons
    private JPanel displayPanel = new JPanel(); // Display panel for event details
    private JComboBox<String> sortDropDown; // Sort dropdown
    private JCheckBox filterCompleted; // Filter checkbox for completed events
    private JRadioButton showAll; // Radio button to show all events
    private JRadioButton showDeadlines; // Radio button for deadlines
    private JRadioButton showMeetings; // Radio button for meetings
    private JButton addEventButton; // Button to add events

    public EventListPanel() {
        setLayout(new BorderLayout());
        setupControls();
        setupDisplayPanel();
    }

    private void setupControls() {
        controlPanel.setLayout(new FlowLayout());

        // Sort dropdown
        sortDropDown = new JComboBox<>(new String[]{"Sort by Name", "Sort by Date"});
        sortDropDown.addActionListener(e -> sortEvents());
        controlPanel.add(sortDropDown);

        // Filter for completed events
        filterCompleted = new JCheckBox("Hide Completed Events");
        filterCompleted.addItemListener(e -> updateDisplay());
        controlPanel.add(filterCompleted);

        // Event type filters
        showAll = new JRadioButton("Show All", true);
        showDeadlines = new JRadioButton("Show Deadlines");
        showMeetings = new JRadioButton("Show Meetings");
        ButtonGroup group = new ButtonGroup();
        group.add(showAll);
        group.add(showDeadlines);
        group.add(showMeetings);

        showAll.addActionListener(e -> updateDisplay());
        showDeadlines.addActionListener(e -> updateDisplay());
        showMeetings.addActionListener(e -> updateDisplay());

        controlPanel.add(showAll);
        controlPanel.add(showDeadlines);
        controlPanel.add(showMeetings);

        // Add event button
        addEventButton = new JButton("Add Event");
        addEventButton.addActionListener(this::openAddEventModal);
        controlPanel.add(addEventButton);

        add(controlPanel, BorderLayout.NORTH);
    }

    private void setupDisplayPanel() {
        displayPanel.setLayout(new BoxLayout(displayPanel, BoxLayout.Y_AXIS));
        add(displayPanel, BorderLayout.CENTER);
    }

    private void openAddEventModal(ActionEvent e) {
        AddEventModel modal = new AddEventModel(this);
        modal.setVisible(true);
    }

    public void addEvent(Event event) {
        events.add(event);
        updateDisplay();
    }

    public void updateDisplay() {
        displayPanel.removeAll();
        for (Event event : events) {
            boolean showEvent = true;

            // Apply filtering based on the selected radio button
            if (showDeadlines.isSelected() && !(event instanceof Deadline)) {
                showEvent = false;
            } else if (showMeetings.isSelected() && !(event instanceof Meeting)) {
                showEvent = false;
            }

            // Apply filter for completed events
            if (filterCompleted.isSelected() && event.isCompleted()) {
                showEvent = false;
            }

            if (showEvent) {
                displayPanel.add(new EventPanel(event));
            }
        }
        revalidate();
        repaint();
    }

    private void sortEvents() {
        String selected = (String) sortDropDown.getSelectedItem();
        if ("Sort by Name".equals(selected)) {
            events.sort(Comparator.comparing(Event::getName));
        } else {
            events.sort(Comparator.comparing(Event::getDateTime));
        }
        updateDisplay();
    }
}
