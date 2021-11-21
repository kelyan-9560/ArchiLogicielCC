package services;

import common.CreditCard;
import common.User;
import event.Event;
import event.EventBus;

import java.util.Date;
import java.util.Objects;

public class CreditCardVerificationService {

    private final EventBus<Event> eventBus;

    public CreditCardVerificationService(EventBus<Event> eventBus) {
        this.eventBus = eventBus;
    }

    public boolean numberIsValid(CreditCard creditCard){
        if(creditCard.getNumber().length() != 18){
            return true;
        }
        System.out.println("Carte de crédit : numéro invalide");
        return false;
    }

    public boolean expirationDateIsValid(CreditCard creditCard){
        if(creditCard.getExpirationDate().before(new Date())){
            return true;
        }
        System.out.println("Carte de crédit : date d'expiration invalide");
        return false;
    }

    public boolean ownerNameIsSameAsUserName(CreditCard creditCard, User user){
        if(Objects.equals(creditCard.getOwnerName(), user.getLastname())){
            return true;
        }
        System.out.println("Carte de crédit : nom invalide");
        return false;
    }

    public void creditCardVerification(CreditCard creditCard, User user) throws Exception {
        if(numberIsValid(creditCard) && expirationDateIsValid(creditCard) && ownerNameIsSameAsUserName(creditCard, user)){
            System.out.println("La carte de crédit est valide");
            return;
        }
        throw new Exception("Carte de crédit non valide");
    }


}
