package common;

import event.Event;
import event.EventId;

import java.util.Date;

public class AddedUserEvent implements Event {
    private final EventId eventId;
    private final Date eventDate;
    private final User user;

    public AddedUserEvent(EventId eventId, Date eventDate, User user) {
        this.eventId = eventId;
        this.eventDate = eventDate;
        this.user = user;
    }

    public static AddedUserEvent withUser(User user){
        return new AddedUserEvent(EventId.create(), new Date(), user);
    }


    @Override
    public EventId getId() {
        return eventId;
    }

    @Override
    public Date getDate() {
        return eventDate;
    }

    public User getUser() {
        return user;
    }
}