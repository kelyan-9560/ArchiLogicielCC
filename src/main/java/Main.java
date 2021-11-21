import common.AddedUserEvent;
import common.CreditCard;
import common.User;
import event.DefaultEventBus;
import module.AddedUserEventSubscription;
import module.Payment;
import module.SendMailToUser;
import services.AddedService;
import services.CreditCardVerificationService;
import services.UserVerificationService;

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
        User user = User.of("Kélyan ", "BERVIN", "kelyan.bervin@gmail.com", creditCard);

        creditCardVerificationService.creditCardVerification(creditCard, user);


        userVerificationService.userVerification(user);

        addedService.register(user);

        //paiement




    }
}