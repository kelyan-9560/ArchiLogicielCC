package module;

import common.AddedUserEvent;
import event.Subscriber;
import module.SendMailToUser;

import java.util.function.Consumer;

public class AddedUserEventSubscription implements Consumer<AddedUserEvent> {
    private final SendMailToUser sendMailToUser;

    public AddedUserEventSubscription(SendMailToUser sendMailToUser) {
        this.sendMailToUser = sendMailToUser;
    }


    @Override
    public void accept(AddedUserEvent event) {
        var user = event.getUser();
        sendMailToUser.sendMail(user);
    }

}