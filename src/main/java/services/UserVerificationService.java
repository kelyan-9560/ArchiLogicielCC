package services;

import common.User;
import common.VerificationUserEvent;
import event.Event;
import event.EventBus;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserVerificationService {

    private final EventBus<Event> eventBus;

    public UserVerificationService(EventBus<Event> eventBus) {
        this.eventBus = eventBus;
    }

    public boolean mailAddressVerification(User user) {
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(user.getEmail());

        if(matcher.matches()){
            eventBus.userVerificationSubscriber(VerificationUserEvent.withUser(user));
            return true;
        }
        System.out.println("User : Adresse mail erronée");
        return false;
    }

    public void userVerification(User user) throws Exception {
        if(mailAddressVerification(user)){
            System.out.println("Le user est valide");
            return;
        }
        throw new Exception("Le user n'est pas valide");
    }

}
