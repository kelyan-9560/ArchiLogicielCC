package use_cases.tradesman.domain.events;

import java.util.Date;

public interface Event {
    EventId getId();
    Date getDate();
}
