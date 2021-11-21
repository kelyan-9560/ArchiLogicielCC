package common;

import java.util.Date;
import java.util.Objects;


public class CreditCard {

    private final String number;
    private final String ownerName;
    private final Date expirationDate;


    public CreditCard(String number, String ownerName, Date expirationDate) {
        this.number = Objects.requireNonNull(number);
        this.ownerName = Objects.requireNonNull(ownerName);
        this.expirationDate = Objects.requireNonNull(expirationDate);

    }
    
    public static CreditCard of(String number, String ownerName, Date expirationDate){
        return new CreditCard(number, ownerName, expirationDate);
    }


    public String getNumber() {
        return number;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }
}
