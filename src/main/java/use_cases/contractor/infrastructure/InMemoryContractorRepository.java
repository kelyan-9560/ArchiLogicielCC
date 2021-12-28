package use_cases.contractor.infrastructure;

import use_cases.contractor.domain.Contractor;
import use_cases.contractor.domain.ContractorId;
import use_cases.contractor.domain.ContractorRepository;
import use_cases.contractor.domain.exception.ContractorException;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryContractorRepository implements ContractorRepository {

    private final Map<ContractorId, Contractor> data = new HashMap<>();


    @Override
    public void add(Contractor contractor) {
        try {
            data.put(contractor.getContractorId(), contractor);
        } catch (Exception e) {
            throw ContractorException.failedInsertion();
        }

    }

    @Override
    public Contractor getById(ContractorId contractorId) {
        final Contractor contractor = data.get(contractorId);
        if (contractor == null) {
            throw ContractorException.contractorNotFound();
        }
        return contractor;
    }

    @Override
    public List<Contractor> getAll() {
        if(data.isEmpty()){
            throw ContractorException.noContractor();
        }
        return List.copyOf(data.values());
    }

    @Override
    public void delete(ContractorId contractorId) {
        try {
            data.remove(contractorId);
        } catch (Exception e) {
            throw ContractorException.failedInsertion();
        }
    }
}
