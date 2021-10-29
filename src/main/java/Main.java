import common.AddedUserEvent;
import common.User;
import event.DefaultEventBus;
import module.AddedUserEventSubscription;
import module.SendMailToUser;
import services.AddedService;

import java.util.Collections;

public class Main {

    public static void main(String[] args){
        var subscriptionMap = Collections.singletonMap(
                AddedUserEvent.class, new AddedUserEventSubscription(new SendMailToUser()));

        var eventBus = new DefaultEventBus(subscriptionMap);

        AddedService addedService = new AddedService(eventBus);

        User user = User.of("Kélyan ", "BERVIN", "kelyan.bervin@gmail.com");
        addedService.register(user);
    }
}