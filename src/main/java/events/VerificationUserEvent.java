package events;


import domain.tradesman.TradesMan;

import java.util.Date;

public class VerificationUserEvent {
    private final EventId eventId;
    private final Date createdAt;
    private final TradesMan tradesMan;

    public VerificationUserEvent(EventId eventId, Date createdAt, TradesMan tradesMan) {
        this.eventId = eventId;
        this.createdAt = createdAt;
        this.tradesMan = tradesMan;
    }

    public static VerificationUserEvent withUser(TradesMan tradesMan){
        return new VerificationUserEvent(EventId.create(), new Date(), tradesMan);
    }

}
