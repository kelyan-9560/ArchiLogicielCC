package services;

import common.AddedUserEvent;
import common.User;
import event.Event;
import event.EventBus;

public class AddedService {
    private final EventBus<Event> eventBus;

    public AddedService(EventBus<Event> eventBus) {
        this.eventBus = eventBus;
    }

    public void register(User user) {
        System.out.println("Ajout de :  " + user);
        eventBus.send(AddedUserEvent.addedUserEvent(user));
    }


}