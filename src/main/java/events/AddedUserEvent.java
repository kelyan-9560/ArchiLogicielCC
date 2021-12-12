package events;

import domain.tradesman.TradesMan;

import java.util.Date;

public class AddedUserEvent implements Event {
    private final EventId eventId;
    private final Date eventDate;
    private final TradesMan tradesMan;

    public AddedUserEvent(EventId eventId, Date eventDate, TradesMan tradesMan) {
        this.eventId = eventId;
        this.eventDate = eventDate;
        this.tradesMan = tradesMan;
    }

    public static AddedUserEvent withUser(TradesMan tradesMan){
        return new AddedUserEvent(EventId.create(), new Date(), tradesMan);
    }


    @Override
    public EventId getId() {
        return eventId;
    }

    @Override
    public Date getDate() {
        return eventDate;
    }

    public TradesMan getUser() {
        return tradesMan;
    }
}