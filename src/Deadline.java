import java.time.LocalDateTime;

// Deadline class extending Event and implementing Completable
public class Deadline extends Event implements Completable {
    private boolean complete;

    public Deadline(String name, LocalDateTime dateTime) {
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
