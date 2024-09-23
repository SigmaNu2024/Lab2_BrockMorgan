import java.time.LocalDateTime;
import java.time.Duration;

// Meeting class extending Event and implementing Completable
public class Meeting extends Event implements Completable {
    private LocalDateTime endDateTime;
    private String location;
    private boolean complete;

    public Meeting(String name, LocalDateTime dateTime, LocalDateTime endDateTime, String location) {
        super();
        this.name = name;
        this.dateTime = dateTime;
        this.endDateTime = endDateTime;
        this.location = location;
        this.complete = false;
    }

    @Override
    public String getName() {
        return name;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public Duration getDuration() {
        return Duration.between(dateTime, endDateTime);
    }

    public String getLocation() {
        return location;
    }

    public void setEndDateTime(LocalDateTime EndDateTime) {
        this.endDateTime = EndDateTime;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public void complete() {
        this.complete = true;
    }

    @Override
    public boolean isComplete() {
        return complete;
    }
}
