import domain.tradesman.Location;
import events.AddedTradesManEvent;
import domain.tradesman.CreditCard;
import domain.tradesman.TradesMan;
import domain.tradesman.TradesManId;
import events.DefaultEventBus;
import module.AddedUserEventSubscription;
import module.Payment;
import module.SendMailToUser;
import application.AddedService;
import application.CreditCardVerificationService;
import application.TradesManVerificationService;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Date;


public class Main {

    public static void main(String[] args) throws Exception {
        var subscriptionMap = Collections.singletonMap(AddedTradesManEvent.class,
                        Collections.singletonList(new AddedUserEventSubscription(new SendMailToUser(), new Payment())));

        var eventBus = new DefaultEventBus(subscriptionMap);


        CreditCardVerificationService creditCardVerificationService = new CreditCardVerificationService(eventBus);
        TradesManVerificationService userVerificationService = new TradesManVerificationService(eventBus);
        AddedService addedService = new AddedService(eventBus);


        CreditCard creditCard = CreditCard.of("458729053978354612", "BERVIN", LocalDateTime.now());
        Location location = Location.of("ile de france", "Paris");
        TradesManId tradesManId = TradesManId.of("1");
        TradesMan tradesMan = TradesMan.of(tradesManId,"Kélyan ", "BERVIN", "kelyan.bervin@gmail.com",
                creditCard, "Macon", "maçon", 2.3, location, "Bac");

        creditCardVerificationService.creditCardVerification(creditCard, tradesMan);


        userVerificationService.userVerification(tradesMan);

        addedService.register(tradesMan);

        //paiement




    }
}