import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class EventPanel extends JPanel {
    private final Event event;           // The event displayed by this panel
    private JButton completeButton; // Button to mark the event as complete

    public EventPanel(Event event) {
        this.event = event;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // Display event details
        add(new JLabel("Name: " + event.getName()));
        add(new JLabel("Time: " + event.getDateTime()));

        // Additional details for Meeting
        if (event instanceof Meeting meeting) {
            add(new JLabel("Duration: " + meeting.getDuration().toMinutes() + " minutes"));
            add(new JLabel("Location: " + meeting.getLocation()));
        }

        // Completion status and button for Completable events
        if (event instanceof Completable) {
            completeButton = new JButton("Complete");
            completeButton.addActionListener(e -> {
                ((Completable) event).complete();
                completeButton.setEnabled(false); // Disable after completion
                updateCompletionStatus();
            });
            add(completeButton);
            updateCompletionStatus(); // Initial status update
        }
    }

    private void updateCompletionStatus() {
        if (event instanceof Completable && ((Completable) event).isComplete()) {
            add(new JLabel("Status: Completed"));
            completeButton.setEnabled(false); // Disable button if already completed
        } else {
            add(new JLabel("Status: In Progress"));
        }
    }
}
