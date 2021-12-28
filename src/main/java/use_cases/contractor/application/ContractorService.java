package use_cases.contractor.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import use_cases.contractor.domain.Contractor;
import use_cases.contractor.domain.ContractorId;
import use_cases.contractor.domain.ContractorRepository;
import use_cases.tradesman.domain.events.Event;
import use_cases.tradesman.domain.events.EventBus;

import java.util.List;

@Service
public class ContractorService {

    private final ContractorRepository contractorRepository;
    private final EventBus<Event> eventBus;

    @Autowired
    public ContractorService(ContractorRepository contractorRepository, EventBus<Event> eventBus) {
        this.contractorRepository = contractorRepository;
        this.eventBus = eventBus;
    }

    public ContractorId nextId(){
        return contractorRepository.nextId();
    }


    public ContractorId create(ContractorDTO contractorDTO){
        final ContractorId contractorId = contractorRepository.nextId();
        final Contractor contractor = Contractor.of(contractorId, contractorDTO.firstname, contractorDTO.lastname);

        contractorRepository.add(contractor);
        //eventBus.send(AddedUserEvent.withUser(tradesMan));
        return contractorId;
    }

    public Contractor getById(ContractorId contractorId){
        //this.eventBus.send();
        return contractorRepository.getById(contractorId);
    }


    public List<Contractor> getAll(){
        //this.eventBus.
        return contractorRepository.getAll();
    }


    public void delete(ContractorId contractorId){
        //eventBus
        contractorRepository.delete(contractorId);
    }
}
