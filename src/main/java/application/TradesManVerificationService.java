package application;

import domain.exception.TradesManException;
import domain.tradesman.TradesMan;
import events.VerificationTradesManEvent;
import events.Event;
import events.EventBus;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TradesManVerificationService {

    private final EventBus<Event> eventBus;

    public TradesManVerificationService(EventBus<Event> eventBus) {
        this.eventBus = eventBus;
    }


    public void dailyTaxVerification(TradesMan tradesMan) throws TradesManException{
        if(tradesMan.getDailyTax() <= 0.0){
            throw TradesManException.withDailyTax(tradesMan.getDailyTax());
        }
    }

    public void mailAddressVerification(TradesMan tradesMan) throws TradesManException {
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(tradesMan.getEmail());

        if(!matcher.matches()){
            throw TradesManException.withEmail(tradesMan.getEmail());
        }
        eventBus.tradesManVerificationSubscriber(VerificationTradesManEvent.withUser(tradesMan));
    }

    public void userVerification(TradesMan tradesMan) {
        mailAddressVerification(tradesMan);
        dailyTaxVerification(tradesMan);
    }

}
