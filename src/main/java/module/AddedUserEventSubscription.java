package module;

import events.AddedTradesManEvent;

import java.util.function.Consumer;

public class AddedUserEventSubscription implements Consumer<AddedTradesManEvent> {

    private final SendMailToUser sendMailToUser;
    private final Payment payement;

    public AddedUserEventSubscription(SendMailToUser sendMailToUser, Payment payement) {
        this.sendMailToUser = sendMailToUser;
        this.payement = payement;
    }


    @Override
    public void accept(AddedTradesManEvent event) {
        var user = event.getTradesMan();
        sendMailToUser.sendMail(user);
        payement.payement(user);
    }

}