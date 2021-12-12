package application;

import events.AddedUserEvent;
import domain.tradesman.TradesMan;
import events.Event;
import events.EventBus;

public class AddedService {
    private final EventBus<Event> eventBus;

    public AddedService(EventBus<Event> eventBus) {
        this.eventBus = eventBus;
    }

    public void register(TradesMan tradesMan) {
        System.out.println("Ajout de :  " + tradesMan);
        eventBus.send(AddedUserEvent.withUser(tradesMan));
    }

}