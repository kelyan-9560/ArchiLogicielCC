package event;

import common.VerificationUserEvent;

import java.util.List;

public interface EventBus<E extends Event> {
    void send(E event);

    void registerSubscriber(Class<E> classE, List<Subscriber<E>> subscribers);

    void userVerificationSubscriber(VerificationUserEvent verificationUserEvent);
    void creditCardVerificationSubscriber(VerificationUserEvent verificationUserEvent);
}
