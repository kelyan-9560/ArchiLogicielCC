import events.AddedUserEvent;
import domain.CreditCard;
import domain.tradesman.TradesMan;
import domain.tradesman.TradesManId;
import events.DefaultEventBus;
import module.AddedUserEventSubscription;
import module.Payment;
import module.SendMailToUser;
import application.AddedService;
import application.CreditCardVerificationService;
import application.UserVerificationService;

import java.util.Collections;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws Exception {
        var subscriptionMap = Collections.singletonMap(AddedUserEvent.class,
                        Collections.singletonList(new AddedUserEventSubscription(new SendMailToUser(), new Payment())));

        var eventBus = new DefaultEventBus(subscriptionMap);


        CreditCardVerificationService creditCardVerificationService = new CreditCardVerificationService(eventBus);
        UserVerificationService userVerificationService = new UserVerificationService(eventBus);
        AddedService addedService = new AddedService(eventBus);


        CreditCard creditCard = CreditCard.of("4587290539783546", "BERVIN", new Date());
        TradesManId tradesManId = TradesManId.of("1");
        TradesMan tradesMan = TradesMan.of(tradesManId,"Kélyan ", "BERVIN", "kelyan.bervin@gmail.com",
                creditCard, "Macon", "maçcon", 2.3);

        creditCardVerificationService.creditCardVerification(creditCard, tradesMan);


        userVerificationService.userVerification(tradesMan);

        addedService.register(tradesMan);

        //paiement




    }
}