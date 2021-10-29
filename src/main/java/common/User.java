package common;

public class User {

    private final String firstname;
    private final String lastname;
    private final String mailAddress;

    private User(String firstname, String lastname, String mailAddress){
        this.firstname = firstname;
        this.lastname = lastname;
        this.mailAddress = mailAddress;
    }

    public static User of(String firstname, String lastname, String mailAddress){
        return new User(lastname, firstname, mailAddress);
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