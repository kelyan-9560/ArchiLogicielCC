package application;

import domain.tradesman.CreditCard;
import domain.tradesman.Location;
import domain.tradesman.TradesManId;
import org.springframework.lang.NonNull;

public class TradesManDTO {

    @NonNull
    public TradesManId tradesManId;
    @NonNull
    public String firstname;
    @NonNull
    public String lastname;
    @NonNull
    public String email;
    @NonNull
    public CreditCard creditCard;
    @NonNull
    public String job;
    @NonNull
    public String skill;
    @NonNull
    public Double dailyTax;
    @NonNull
    public Location location;
    @NonNull
    public String diplomas;
}
