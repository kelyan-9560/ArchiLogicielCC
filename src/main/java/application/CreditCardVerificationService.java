package application;

import domain.tradesman.CreditCard;
import domain.exception.CreditCardException;
import domain.tradesman.TradesMan;
import events.Event;
import events.EventBus;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

public class CreditCardVerificationService {

    private final EventBus<Event> eventBus;

    public CreditCardVerificationService(EventBus<Event> eventBus) {
        this.eventBus = eventBus;
    }


    public void numberIsValid(CreditCard creditCard) throws CreditCardException{
        if(creditCard.getNumber().length() != 18){
            throw CreditCardException.withNumber(creditCard.getNumber());
        }
    }

    public void expirationDateIsValid(CreditCard creditCard) throws CreditCardException{
        if(creditCard.getExpirationDate().isBefore(LocalDateTime.now())){
            throw CreditCardException.withDate(creditCard.getExpirationDate());
        }
    }

    public void ownerNameIsSameAsUserName(CreditCard creditCard, TradesMan tradesMan) throws CreditCardException{
        if(!Objects.equals(creditCard.getOwnerName(), tradesMan.getLastname())){
            throw CreditCardException.withOwnerName(creditCard.getOwnerName());
        }
    }

    public void creditCardVerification(CreditCard creditCard, TradesMan tradesMan) {
        numberIsValid(creditCard);
        //expirationDateIsValid(creditCard);
        ownerNameIsSameAsUserName(creditCard, tradesMan);
    }

}
