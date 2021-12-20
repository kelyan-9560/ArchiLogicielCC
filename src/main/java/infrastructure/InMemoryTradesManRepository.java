package infrastructure;

import domain.exception.TradesManException;
import domain.tradesman.TradesMan;
import domain.tradesman.TradesManId;
import domain.tradesman.TradesManRepository;

import java.util.*;

public class InMemoryTradesManRepository implements TradesManRepository {

    private final Map<TradesManId, TradesMan> data = new HashMap<>();


    @Override
    public void add(TradesMan tradesMan) {
        try {
            data.put(tradesMan.getTradesManId(), tradesMan);
        } catch (Exception e) {
            throw TradesManException.failedInsertion();
        }
    }

    @Override
    public TradesMan getById(TradesManId tradesManId) {
        final TradesMan tradesMan = data.get(tradesManId);
        if (tradesMan == null) {
            throw TradesManException.tradesManNotFound();
        }
        return tradesMan;
    }

    @Override
    public List<TradesMan> getAll() {
        if(data.isEmpty()){
            throw TradesManException.noTradesMan();
        }
        return List.copyOf(data.values());
    }

    @Override
    public void delete(TradesManId tradesManId) {
        try {
            data.remove(tradesManId);
        } catch (Exception e) {
            throw TradesManException.failedInsertion();
        }
    }
}