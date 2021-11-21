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

    public static VerificationUserEvent withUser(User user){
        return new VerificationUserEvent(EventId.create(), new Date(), user);
    }

}
