package application;

import domain.tradesman.TradesMan;
import domain.tradesman.TradesManId;
import domain.tradesman.TradesManRepository;
import events.AddedUserEvent;
import events.Event;
import events.EventBus;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public final class TradesManService {

    private final TradesManRepository tradesManRepository;
    private final EventBus<Event> eventBus;

    public TradesManService(TradesManRepository tradesManRepository, EventBus<Event> eventBus) {
        this.tradesManRepository = tradesManRepository;
        this.eventBus = eventBus;
    }


    public TradesManId nextId(){
        return tradesManRepository.nextId();
    }


    @Bean
    public void create(TradesManDTO tradesManDTO){
        final TradesManId tradesManId = tradesManRepository.nextId();
        final TradesMan tradesMan = TradesMan.of(tradesManId, tradesManDTO.firstname, tradesManDTO.lastname,
                                                    tradesManDTO.email,tradesManDTO.creditCard, tradesManDTO.job,
                                                    tradesManDTO.skill, tradesManDTO.dailyTax, tradesManDTO.location,
                                                    tradesManDTO.diplomas);
        this.tradesManRepository.add(tradesMan);
        this.eventBus.send(AddedUserEvent.withUser(tradesMan));
    }


    @Bean
    public void getById(TradesManId tradesManId){
        //this.eventBus.send();
        tradesManRepository.findById(tradesManId);

    }

    @Bean
    public List<TradesMan> getAll(){
        return tradesManRepository.getAll();
        //utiliser l'eventBus
    }

    @Bean
    public void delete(TradesManId tradesManId){
        tradesManRepository.delete(tradesManId);
        //utiliser l'eventBus
    }

}
