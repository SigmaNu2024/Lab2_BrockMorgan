import javax.swing.*;
import java.awt.*;
//import java.time.LocalDateTime;
//import java.time.Month;


public class EventPlanner {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Event Planner");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

        EventListPanel eventListPanel = new EventListPanel();
        //addDefaultEvents(eventListPanel);

        frame.add(eventListPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
