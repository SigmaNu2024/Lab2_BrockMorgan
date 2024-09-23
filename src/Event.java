import java.time.LocalDateTime;

// Abstract class representing an Event
abstract class Event implements Comparable<Event> {
    protected String name;
    protected LocalDateTime dateTime;

    public Event(String name, LocalDateTime dateTime) {
    }

    public Event() {

    }

    public String getName() {
        return null;
    }

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
