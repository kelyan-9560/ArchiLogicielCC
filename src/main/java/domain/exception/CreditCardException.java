package domain.exception;

import java.time.LocalDateTime;
import java.util.Date;

public final class CreditCardException extends RuntimeException {

    private final int errorCode;

    public CreditCardException(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public static CreditCardException withNumber(String creditCardNumber){
        return new CreditCardException(creditCardNumber + " is a bad CreditCard number", 1);
    }

    public static CreditCardException withDate(LocalDateTime expirationDate){
        return new CreditCardException(expirationDate + " is a bad CreditCard expiration date", 2);
    }

    public static CreditCardException withOwnerName(String ownerName){
        return new CreditCardException(ownerName + " is a bad CreditCard owner name", 3);
    }
}
