import javax.swing.*;
import java.awt.*;


public class EventPlanner {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Event Planner");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

        EventListPanel eventListPanel = new EventListPanel();
        addDefaultEvents(eventListPanel);

        frame.add(eventListPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
    static void addDefaultEvents(EventListPanel eventListPanel) {
        // Default Meeting and Deadline
        Deadline defaultDeadline = new Deadline("First Deadline", EventTester.deadline.minusDays(20) );
        Meeting defaultMeeting = new Meeting("First Meeting", EventTester.start, EventTester.end, EventTester.location);

        // Adds default events to the EventListPanel
        eventListPanel.addEvent(defaultDeadline);
        eventListPanel.addEvent(defaultMeeting);
    }
}
