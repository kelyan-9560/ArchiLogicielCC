package use_cases.tradesman.domain.events;

import java.util.function.Consumer;

public interface Subscriber <E extends Event> extends Consumer<E> {
}
