import common.AddedUserEvent;
import common.CreditCard;
import common.User;
import event.DefaultEventBus;
import module.AddedUserEventSubscription;
import module.SendMailToUser;
import services.AddedService;

import java.util.Collections;
import java.util.Date;

public class Main {

    public static void main(String[] args){
        var subscriptionMap = Collections.singletonMap(
                AddedUserEvent.class, new AddedUserEventSubscription(new SendMailToUser()));

        var eventBus = new DefaultEventBus(subscriptionMap);

        AddedService addedService = new AddedService(eventBus);

        CreditCard creditCard = CreditCard.of("4587 2905 3978 3546", "BERVIN", new Date());

        User user = User.of("Kélyan ", "BERVIN", "kelyan.bervin@gmail.com", creditCard);
        addedService.register(user);
    }
}