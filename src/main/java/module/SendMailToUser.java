package module;

import domain.tradesman.TradesMan;

public final class SendMailToUser {

    public void sendMail (TradesMan tradesMan){
        System.out.println("Mail envoyé à " + tradesMan);
    }
}