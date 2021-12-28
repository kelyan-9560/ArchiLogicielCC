package use_cases.contractor.domain;

import use_cases.tradesman.domain.TradesMan;

import java.util.List;
import java.util.UUID;

public interface ContractorRepository {

    void add(Contractor contractor);

    Contractor getById(ContractorId contractorId);

    List<Contractor> getAll();

    void delete(ContractorId contractorId);

    default ContractorId nextId(){
        return ContractorId.fromUUID(UUID.randomUUID());
    }
}
