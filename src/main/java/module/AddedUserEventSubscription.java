package module;

import events.AddedUserEvent;

import java.util.function.Consumer;

public class AddedUserEventSubscription implements Consumer<AddedUserEvent> {

    private final SendMailToUser sendMailToUser;
    private final Payment payement;

    public AddedUserEventSubscription(SendMailToUser sendMailToUser, Payment payement) {
        this.sendMailToUser = sendMailToUser;
        this.payement = payement;
    }


    @Override
    public void accept(AddedUserEvent event) {
        var user = event.getUser();
        sendMailToUser.sendMail(user);
        payement.payement(user);
    }

}