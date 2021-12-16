package domain.tradesman;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreditCard that = (CreditCard) o;
        return Objects.equals(number, that.number) && Objects.equals(ownerName, that.ownerName) && Objects.equals(expirationDate, that.expirationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, ownerName, expirationDate);
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
