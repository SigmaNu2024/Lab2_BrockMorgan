import java.time.LocalDateTime;

// Abstract class representing an Event
public abstract class Event implements Comparable<Event> {
    public String name;
    public LocalDateTime dateTime;

    public Event(String name, LocalDateTime dateTime) {
        this.name = name;
        this.dateTime = dateTime;
    }


    public abstract String getName();

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Event e) {
        return this.dateTime.compareTo(e.dateTime);
    }
}
