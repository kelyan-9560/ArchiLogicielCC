package event;

import java.util.Date;

public interface Event {
    EventId getId();
    Date getDate();
}
