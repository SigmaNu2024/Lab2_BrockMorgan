import java.util.Date;

// Abstract class representing an Event
abstract class Event implements Comparable<Event> {
    private String name;
    private Date dateTime;

    public Event(String name, Date dateTime) {
        this.name = name;
        this.dateTime = dateTime;
    }

    public String getName() {
        return null;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
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

// Interface for Completable
interface Completable {
    void complete();
    boolean isComplete();
}

// Deadline class extending Event and implementing Completable
class Deadline extends Event implements Completable {
    private boolean complete;

    public Deadline(String name, Date dateTime) {
        super(name, dateTime);
        this.complete = false;
    }

    @Override
    public String getName() {
        return super.getDateTime().toString() + ": " + super.getName();
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

// Meeting class extending Event and implementing Completable
class Meeting extends Event implements Completable {
    private Date endDateTime;
    private String location;
    private boolean complete;

    public Meeting(String name, Date dateTime, Date endDateTime, String location) {
        super(name, dateTime);
        this.endDateTime = endDateTime;
        this.location = location;
        this.complete = false;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void complete() {
        this.complete = true;
    }

    @Override
    public boolean isComplete() {
        return complete;
    }

    public Date getEndTime() {
        return endDateTime;
    }

    public int getDuration() {
        return (int) ((endDateTime.getTime() - super.getDateTime().getTime()) / 60000); // duration in minutes
    }

    public String getLocation() {
        return location;
    }

    public void setEndTime(Date end) {
        this.endDateTime = end;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}

