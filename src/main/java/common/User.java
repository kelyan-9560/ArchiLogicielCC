package common;

import java.util.Objects;

public class User {

    private final String firstname;
    private final String lastname;
    private final String email;
    private final CreditCard creditCard;

    private User(String firstname, String lastname, String mailAddress, CreditCard creditCard){
        this.firstname = Objects.requireNonNull(firstname);
        this.lastname = Objects.requireNonNull(lastname);
        this.email = Objects.requireNonNull(mailAddress);
        this.creditCard = Objects.requireNonNull(creditCard);
    }

    public static User of(String firstname, String lastname, String mailAddress, CreditCard creditCard){
        return new User(firstname, lastname, mailAddress, creditCard);
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString(){
        return "common.User{" +
                "lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", mailAddress= " + email + '\'' +
                '}';
    }
}