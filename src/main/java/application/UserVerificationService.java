package application;

import domain.tradesman.TradesMan;
import events.VerificationUserEvent;
import events.Event;
import events.EventBus;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserVerificationService {

    private final EventBus<Event> eventBus;

    public UserVerificationService(EventBus<Event> eventBus) {
        this.eventBus = eventBus;
    }

    public boolean mailAddressVerification(TradesMan tradesMan) {
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(tradesMan.getEmail());

        if(matcher.matches()){
            eventBus.userVerificationSubscriber(VerificationUserEvent.withUser(tradesMan));
            return true;
        }
        System.out.println("User : Adresse mail erronée");
        return false;
    }

    public void userVerification(TradesMan tradesMan) throws Exception {
        if(mailAddressVerification(tradesMan)){
            System.out.println("Le user est valide");
            return;
        }
        throw new Exception("Le user n'est pas valide");
    }

}
