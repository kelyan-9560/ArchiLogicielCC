package cc2.module;

import cc2.use_cases.tradesman.domain.events.AddedTradesManEvent;
import cc2.use_cases.tradesman.domain.events.Subscriber;


public class AddedUserEventSubscription implements Subscriber<AddedTradesManEvent> {

    private final SendMailToUser sendMailToUser;
    private final Payment payment;

    public AddedUserEventSubscription(SendMailToUser sendMailToUser, Payment payment) {
        this.sendMailToUser = sendMailToUser;
        this.payment = payment;
    }


    @Override
    public void accept(AddedTradesManEvent event) {
        var user = event.getTradesMan();
        sendMailToUser.sendMail(user);
        payment.payment(user);
    }

}