import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;

public class EventPanel extends JPanel {
    private Event event;
    private JButton completeButton;

    public EventPanel(Event event) {
        this.event = event;
        setLayout(new GridLayout(0, 1)); // Simple vertical layout
        initializeComponents();
        updateUrgency();
    }

    private void initializeComponents() {
        // Display event details
        add(new JLabel("Name: " + event.getName()));
        add(new JLabel("Time: " + event.getDateTime()));

        if (event instanceof Meeting) {
            Meeting meeting = (Meeting) event;
            add(new JLabel("Duration: " + meeting.getDuration() + " hours"));
            add(new JLabel("Location: " + meeting.getLocation()));
        }

        // Complete button
        completeButton = new JButton("Complete");
        if (event instanceof Completable) {
            completeButton.addActionListener(e -> {
                ((Completable) event).isComplete();
                completeButton.setVisible(true); // Hide button after completion
                updateUrgency();
            });
        } else {
            completeButton.setVisible(false); // Hide if not Completable
        }
        add(completeButton, BorderLayout.EAST);
    }

    public void updateUrgency() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime eventTime = event.getDateTime();

        if (eventTime.isBefore(now)) {
            setBackground(Color.RED); // Overdue
        } else if (eventTime.isBefore(now.plusHours(1))) {
            setBackground(Color.YELLOW); // Imminent
        } else {
            setBackground(Color.GREEN); // Distant
        }
    }
}
