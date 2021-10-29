package module;

import common.AddedUserEvent;
import common.User;
import event.DefaultEventBus;
import event.EventBus;

import java.util.Collection;
import java.util.Collections;

public class SendMailToUser {

    public void sendMail (User user){
        System.out.println("Mail envoyé à " + user);
    }
}