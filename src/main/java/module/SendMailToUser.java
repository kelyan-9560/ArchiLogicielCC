package module;

import use_cases.tradesman.domain.TradesMan;

public final class SendMailToUser {

    public void sendMail (TradesMan tradesMan){
        System.out.println("Mail envoyé à " + tradesMan);
    }
}