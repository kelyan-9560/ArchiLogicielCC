package module;

import use_cases.tradesman.domain.events.AddedTradesManEvent;

import java.util.function.Consumer;

public class AddedUserEventSubscription implements Consumer<AddedTradesManEvent> {

    private final SendMailToUser sendMailToUser;
    private final Payment payment;

    public AddedUserEventSubscription(SendMailToUser sendMailToUser, Payment payement) {
        this.sendMailToUser = sendMailToUser;
        this.payment = payement;
    }


    @Override
    public void accept(AddedTradesManEvent event) {
        var user = event.getTradesMan();
        sendMailToUser.sendMail(user);
        payment.payement(user);
    }

}