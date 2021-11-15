package common;

public class User {

    private final String firstname;
    private final String lastname;
    private final String mailAddress;
    private final CreditCard creditCard;

    private User(String firstname, String lastname, String mailAddress, CreditCard creditCard){
        this.firstname = firstname;
        this.lastname = lastname;
        this.mailAddress = mailAddress;

        if(!checkMailAddress(mailAddress)){
            throw new IllegalArgumentException("Mail address must be set");
        }

        this.creditCard = creditCard;

    }

    public static User of(String firstname, String lastname, String mailAddress, CreditCard creditCard){
        return new User(lastname, firstname, mailAddress, creditCard);
    }

    public boolean checkMailAddress(String mailAddress){
        return mailAddress != null;
    }


    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    @Override
    public String toString(){
        return "common.User{" +
                "lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", mailAddress= " + mailAddress + '\'' +
                '}';
    }
}