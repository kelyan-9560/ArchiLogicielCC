package application;

import events.AddedTradesManEvent;
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
        eventBus.send(AddedTradesManEvent.withUser(tradesMan));
    }

}