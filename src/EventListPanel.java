import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class EventListPanel extends JPanel {
    private final ArrayList<Event> events;  // List of events to display
    private JPanel displayPanel;       // Panel for displaying events
    private JComboBox<String> sortDropDown; // Drop down for sorting
    private JCheckBox filterCompleted; // Checkbox to filter completed events
    private JButton addEventButton;    // Button to add new events

    public EventListPanel() {
        events = new ArrayList<>();
        setLayout(new BorderLayout());

        // Control panel setup
        JPanel controlPanel = new JPanel();
        sortDropDown = new JComboBox<>(new String[]{"Sort by Name", "Sort by Date"});
        filterCompleted = new JCheckBox("Show Completed Events");
        addEventButton = new JButton("Add Event");

        // Add listeners
        sortDropDown.addActionListener(e -> updateDisplay());
        filterCompleted.addActionListener(e -> updateDisplay());
        addEventButton.addActionListener(e -> new AddEventModel(this));

        // Adding components to control panel
        controlPanel.add(sortDropDown);
        controlPanel.add(filterCompleted);
        controlPanel.add(addEventButton);
        add(controlPanel, BorderLayout.NORTH);

        // Display panel setup
        displayPanel = new JPanel();
        displayPanel.setLayout(new BoxLayout(displayPanel, BoxLayout.Y_AXIS));
        add(displayPanel, BorderLayout.CENTER);
    }

    // Method to add an event and update the display
    public void addEvent(Event event) {
        events.add(event);
        updateDisplay();
    }

    // Method to update the displayed events
    public void updateDisplay() {
        displayPanel.removeAll();
        events.stream()
                .filter(event -> filterCompleted.isSelected() || !(event instanceof Completable && ((Completable) event).isComplete()))
                .sorted((e1, e2) -> sortDropDown.getSelectedItem().equals("Sort by Name")
                        ? e1.getName().compareTo(e2.getName())
                        : e1.getDateTime().compareTo(e2.getDateTime()))
                .forEach(event -> displayPanel.add(new EventPanel(event)));

        displayPanel.revalidate();
        displayPanel.repaint();
    }
}
