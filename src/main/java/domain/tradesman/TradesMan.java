package domain.tradesman;

import domain.CreditCard;

import java.util.Objects;

public class TradesMan {

    private final TradesManId tradesManId;
    private final String firstname;
    private final String lastname;
    private final String email;
    private final CreditCard creditCard;
    private final String job;
    private final String skill;
    private final Double dailyTax;

    private TradesMan(TradesManId tradesManId, String firstname, String lastname, String mailAddress, CreditCard creditCard,
                      String job, String skill, Double dailyTax){
        this.tradesManId = Objects.requireNonNull(tradesManId);
        this.firstname = Objects.requireNonNull(firstname);
        this.lastname = Objects.requireNonNull(lastname);
        this.email = Objects.requireNonNull(mailAddress);
        this.creditCard = Objects.requireNonNull(creditCard);
        this.job = Objects.requireNonNull(job);
        this.skill = Objects.requireNonNull(skill);
        this.dailyTax = Objects.requireNonNull(dailyTax);
    }

    public static TradesMan of(TradesManId tradesManId, String firstname, String lastname, String mailAddress,
                               CreditCard creditCard, String job, String skills,
                               Double dailyTax){
        return new TradesMan(tradesManId, firstname, lastname, mailAddress, creditCard, job, skills, dailyTax);
    }

    //TODO : générer -> getter, toString, equals, hashCode


    @Override
    public String toString() {
        return "TradesMan{" +
                "tradesManId=" + tradesManId +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", creditCard=" + creditCard +
                ", job='" + job + '\'' +
                ", skill='" + skill + '\'' +
                ", dailyTax=" + dailyTax +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TradesMan tradesMan = (TradesMan) o;
        return Objects.equals(tradesManId, tradesMan.tradesManId) && Objects.equals(firstname, tradesMan.firstname)
                && Objects.equals(lastname, tradesMan.lastname) && Objects.equals(email, tradesMan.email)
                && Objects.equals(creditCard, tradesMan.creditCard) && Objects.equals(job, tradesMan.job)
                && Objects.equals(skill, tradesMan.skill) && Objects.equals(dailyTax, tradesMan.dailyTax);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tradesManId, firstname, lastname, email, creditCard, job, skill, dailyTax);
    }

    public TradesManId getTradesManId() {
        return tradesManId;
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

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public String getJob() {
        return job;
    }

    public String getSkill() {
        return skill;
    }

    public Double getDailyTax() {
        return dailyTax;
    }

}