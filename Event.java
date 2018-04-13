import java.time.LocalDateTime;

public class Event {

    private Edge location; // edge where an event is located
    private int priority; // priority/urgency of the event
    private LocalDateTime time; // time that event is registered

    // constructor
    public Event(Edge loc, int p, LocalDateTime t) {
        location = loc;
        priority = p;
        time = t;
    }

    public Edge getLocation() {
        return location;
    }

    public int getPriority() {
        return priority;
    }

    public LocalDateTime getTime() {
        return time;
    }
}