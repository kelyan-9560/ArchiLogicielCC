import java.util.Objects;

public class User {

    private final String firstname;
    private final String lastname;
    private final String schoolName;

    public User(String firstname, String lastname, String schoolName){
        this.firstname = Objects.requireNonNull(firstname);
        this.lastname = Objects.requireNonNull(lastname);
        this.schoolName = Objects.requireNonNull(schoolName);
    }

    public static User of(String firstname, String lastname, String schoolName){
        return  new User(firstname, lastname, schoolName);
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getSchoolName() {
        return schoolName;
    }
}
