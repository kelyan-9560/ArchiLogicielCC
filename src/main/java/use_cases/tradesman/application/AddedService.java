package use_cases.tradesman.application;

import events.AddedTradesManEvent;
import use_cases.tradesman.domain.TradesMan;
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