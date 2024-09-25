import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AddEventModel extends JDialog {
    private final JTextField nameField = new JTextField();
    private final JTextField dateTimeField = new JTextField();
    private final JTextField endTimeField = new JTextField();
    private final JTextField locationField = new JTextField();
    private final EventListPanel eventListPanel;

    public AddEventModel(EventListPanel eventListPanel) {
        this.eventListPanel = eventListPanel;
        setTitle("Add Event");
        setSize(300, 200);
        setLayout(new GridLayout(5, 2));
        setModal(true);
        setLocationRelativeTo(null);

        add(new JLabel("Name:"));
        add(nameField);
        add(new JLabel("Start Time (YYYY-MM-DD HH:MM):"));
        add(dateTimeField);
        add(new JLabel("End Time (optional):"));
        add(endTimeField);
        add(new JLabel("Location (optional):"));
        add(locationField);

        JButton addButton = new JButton("Add Event");
        addButton.addActionListener(this::addEvent);
        add(addButton);

        setVisible(true);
    }

    private void addEvent(ActionEvent e) {
        String name = nameField.getText().trim();
        String dateTimeStr = dateTimeField.getText().trim();
        LocalDateTime startDateTime = LocalDateTime.parse(dateTimeStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

        Event newEvent;
        if (endTimeField.getText().trim().isEmpty()) {
            newEvent = new Deadline(name, startDateTime); // Create Deadline
        } else {
            LocalDateTime endDateTime = LocalDateTime.parse(endTimeField.getText().trim(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
            String location = locationField.getText().trim();
            newEvent = new Meeting(name, startDateTime, endDateTime, location); // Create Meeting
        }

        eventListPanel.addEvent(newEvent);
        dispose();
    }
}


