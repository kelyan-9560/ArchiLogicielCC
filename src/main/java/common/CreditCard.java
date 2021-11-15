package common;

import java.util.Date;

public class CreditCard {

    private final String number;
    private final String ownerName;
    private final Date expirationDate;

    public CreditCard(String number, String ownerName, Date expirationDate) {
        this.number = number;
        this.ownerName = ownerName;
        this.expirationDate = expirationDate;

        if(!isValidExpirationDate(expirationDate)){
            throw new IllegalArgumentException("The expiration date has passed");
        }
    }
    
    public static CreditCard of(String number, String ownerName, Date expirationDate){
        return new CreditCard(number, ownerName, expirationDate);
    }

    private boolean isValidExpirationDate(Date expirationDate) {
        return !expirationDate.before(new Date());
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
