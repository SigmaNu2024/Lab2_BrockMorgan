import java.time.LocalDateTime;
import java.time.Duration;

// Meeting class extending Event and implementing Completable
public class Meeting extends Event implements Completable {
    private final LocalDateTime start;
    private LocalDateTime end;
    private String location;
    private boolean complete;

    public Meeting(String name, LocalDateTime start, LocalDateTime end, String location) {
        super(name, start);
        this.name = name;
        this.start = start;
        this.end= end;
        this.location = location;
        this.complete = false;
    }

    @Override
    public String getName() {
        return super.name;
    }

    public LocalDateTime getEndDateTime() {
        return end;
    }

    public Duration getDuration() {
        return Duration.between(start, end);
    }

    public String getLocation() {
        return location;
    }

    public void setEndDateTime(LocalDateTime end) {
        this.end = end;
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
