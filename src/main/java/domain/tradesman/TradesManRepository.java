package domain.tradesman;

import java.util.List;
import java.util.UUID;

public interface TradesManRepository {

    void add(TradesMan tradesMan);

    TradesMan findById(TradesManId tradesManId);

    List<TradesMan> getAll();

    void delete(TradesManId tradesManId);

    default TradesManId nextId(){
        return TradesManId.fromUUID(UUID.randomUUID());
    }
}
