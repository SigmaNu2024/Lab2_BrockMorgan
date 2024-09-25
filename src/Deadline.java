import java.time.LocalDateTime;

// Deadline class extending Event and implementing Completable
public class Deadline extends Event implements Completable {
    private boolean complete;

    public Deadline(String name, LocalDateTime deadline) {
        super(name, deadline);
        this.complete = false;
    }

    public String getName() {
        return super.name;
    }

    @Override
    public boolean isCompleted() {
        return false;
    }


    public void complete() {
        this.complete = true;
    }

    public boolean isComplete() {
        return complete;
    }
}
