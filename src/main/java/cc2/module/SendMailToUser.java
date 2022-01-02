package cc2.module;

import cc2.use_cases.tradesman.domain.TradesMan;

public final class SendMailToUser {

    public void sendMail (TradesMan tradesMan){
        System.out.println("Mail envoyé à " + tradesMan);
    }
}