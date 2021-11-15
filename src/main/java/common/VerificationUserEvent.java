package common;


import event.EventId;

import java.util.Date;

public class VerificationUserEvent {
    private final EventId eventId;
    private final Date createdAt;
    private final User user;

    public VerificationUserEvent(EventId eventId, Date createdAt, User user) {
        this.eventId = eventId;
        this.createdAt = createdAt;
        this.user = user;
    }

}
