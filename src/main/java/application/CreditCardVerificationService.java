package application;

import domain.CreditCard;
import domain.tradesman.TradesMan;
import events.Event;
import events.EventBus;

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

    public boolean ownerNameIsSameAsUserName(CreditCard creditCard, TradesMan tradesMan){
        if(Objects.equals(creditCard.getOwnerName(), tradesMan.getLastname())){
            return true;
        }
        System.out.println("Carte de crédit : nom invalide");
        return false;
    }

    public void creditCardVerification(CreditCard creditCard, TradesMan tradesMan) throws Exception {
        if(numberIsValid(creditCard) && expirationDateIsValid(creditCard) && ownerNameIsSameAsUserName(creditCard, tradesMan)){
            System.out.println("La carte de crédit est valide");
            return;
        }
        throw new Exception("Carte de crédit non valide");
    }


}
