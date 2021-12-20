package application;

import domain.tradesman.TradesMan;
import domain.tradesman.TradesManId;
import domain.tradesman.TradesManRepository;
import events.Event;
import events.EventBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public final class TradesManService {

    private final TradesManRepository tradesManRepository;
    private final EventBus<Event> eventBus;

    @Autowired
    public TradesManService(TradesManRepository tradesManRepository, EventBus<Event> eventBus) {
        this.tradesManRepository = tradesManRepository;
        this.eventBus = eventBus;
    }


    public TradesManId nextId(){
        return tradesManRepository.nextId();
    }


    public TradesManId create(TradesManDTO tradesManDTO){
        final TradesManId tradesManId = tradesManRepository.nextId();
        final TradesMan tradesMan = TradesMan.of(tradesManId, tradesManDTO.firstname, tradesManDTO.lastname,
                                                    tradesManDTO.email,tradesManDTO.creditCard, tradesManDTO.job,
                                                    tradesManDTO.skill, tradesManDTO.dailyTax, tradesManDTO.location,
                                                    tradesManDTO.diplomas);
        tradesManRepository.add(tradesMan);
        //eventBus.send(AddedUserEvent.withUser(tradesMan));
        return tradesManId;
    }


    public TradesMan getById(TradesManId tradesManId){
        //this.eventBus.send();
        return tradesManRepository.getById(tradesManId);
    }


    public List<TradesMan> getAll(){
        //this.eventBus.
        return tradesManRepository.getAll();
    }


    public void delete(TradesManId tradesManId){
        //eventBus
        tradesManRepository.delete(tradesManId);
    }

}
