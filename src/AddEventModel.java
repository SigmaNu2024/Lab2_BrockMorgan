import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class AddEventModel extends JDialog {
    private JTextField nameField;
    private JTextField dateTimeField;
    private JTextField endTimeField; // For meetings
    private JTextField locationField; // For meetings
    private EventListPanel eventListPanel;

    public AddEventModel(EventListPanel eventListPanel) {
        this.eventListPanel = eventListPanel;
        setTitle("Add Event");
        setSize(300, 300);
        setLayout(new GridLayout(0, 1));

        nameField = new JTextField();
        dateTimeField = new JTextField();
        endTimeField = new JTextField();
        locationField = new JTextField();

        add(new JLabel("Name:"));
        add(nameField);
        add(new JLabel("DateTime (YYYY-MM-DD HH:MM):"));
        add(dateTimeField);
        add(new JLabel("EndTime (for Meeting, YYYY-MM-DD HH:MM):"));
        add(endTimeField);
        add(new JLabel("Location (for Meeting):"));
        add(locationField);

        JButton addButton = new JButton("Add Event");
        addButton.addActionListener(this::addEvent);
        add(addButton);

        setVisible(true);
    }

    private void addEvent(ActionEvent e) {
        String name = nameField.getText();
        // Parse the dateTime inputs here
        // For example: LocalDateTime.parse(dateTimeField.getText())
        // Create Deadline or Meeting based on user input

        // Update the EventListPanel
        eventListPanel.updateDisplay();
        dispose();
    }
}

