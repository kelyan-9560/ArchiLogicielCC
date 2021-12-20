import application.TradesManVerificationService;
import domain.exception.TradesManException;
import domain.tradesman.CreditCard;
import domain.tradesman.Location;
import domain.tradesman.TradesMan;
import domain.tradesman.TradesManId;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.fail;

public class TradesManVerificationServiceTest {

    @Test
    public void dailyTaxMoreThanZero(){

        final Double dailyTax = 0.1;

        TradesManVerificationService tradesManVerificationService = new TradesManVerificationService(null);

        final TradesManId tradesManId = TradesManId.of("1");
        final CreditCard creditCard = new CreditCard("1234567634", "BERVIN", LocalDateTime.now());
        final Location location = new Location("Ile-de-France", "Ermont");
        final TradesMan tradesMan = TradesMan.of(tradesManId, "Kélyan", "BERVIN", "kelyan.bervin@gmail.com",
                creditCard, "Dev", "Java", dailyTax, location, "Bachelor");


        try{
            tradesManVerificationService.dailyTaxVerification(tradesMan);
        } catch (TradesManException tradesManException){
            fail("Should'nt throw exception");
            assert (false);
        }

    }

    @Test
    public void dailyTaxLessThanZero(){

        final Double dailyTax = -1.1;

        TradesManVerificationService tradesManVerificationService = new TradesManVerificationService(null);

        final TradesManId tradesManId = TradesManId.of("1");
        final CreditCard creditCard = new CreditCard("1234567634", "BERVIN", LocalDateTime.now());
        final Location location = new Location("Ile-de-France", "Ermont");
        final TradesMan tradesMan = TradesMan.of(tradesManId, "Kélyan", "BERVIN", "kelyan.bervin@gmail.com",
                creditCard, "Dev", "Java", dailyTax, location, "Bachelor");


        try{
            tradesManVerificationService.dailyTaxVerification(tradesMan);
            fail("Should throw exception");
        } catch (TradesManException tradesManException){
            assert (true);
        }


    }

    @Test
    public void dailyTaxEqualToZero(){

        final Double dailyTax = 0.0;

        TradesManVerificationService tradesManVerificationService = new TradesManVerificationService(null);

        final TradesManId tradesManId = TradesManId.of("1");
        final CreditCard creditCard = new CreditCard("1234567634", "BERVIN", LocalDateTime.now());
        final Location location = new Location("Ile-de-France", "Ermont");
        final TradesMan tradesMan = TradesMan.of(tradesManId, "Kélyan", "BERVIN", "kelyan.bervin@gmail.com",
                creditCard, "Dev", "Java", dailyTax, location, "Bachelor");

        try{
            tradesManVerificationService.dailyTaxVerification(tradesMan);
            fail("Should throw exception");
        } catch (TradesManException tradesManException){
            assert (true);
        }


    }

    @Test
    public void mailAddressValid(){

        final String mailAddress = "kelyan.bervin@gmail.com";

        TradesManVerificationService tradesManVerificationService = new TradesManVerificationService(null);

        final TradesManId tradesManId = TradesManId.of("1");
        final CreditCard creditCard = new CreditCard("1234567634", "BERVIN", LocalDateTime.now());
        final Location location = new Location("Ile-de-France", "Ermont");
        final TradesMan tradesMan = TradesMan.of(tradesManId, "Kélyan", "BERVIN", mailAddress,
                creditCard, "Dev", "Java", 0.1, location, "Bachelor");


        try{
            tradesManVerificationService.mailAddressVerification(tradesMan);
        } catch (TradesManException tradesManException){
            fail("Should'nt throw exception");
            assert (false);
        }

    }

    @Test
    public void mailAddressNotValid(){

        final String mailAddress = "kelyan.bervingmail.com";

        TradesManVerificationService tradesManVerificationService = new TradesManVerificationService(null);

        final TradesManId tradesManId = TradesManId.of("1");
        final CreditCard creditCard = new CreditCard("1234567634", "BERVIN", LocalDateTime.now());
        final Location location = new Location("Ile-de-France", "Ermont");
        final TradesMan tradesMan = TradesMan.of(tradesManId, "Kélyan", "BERVIN", mailAddress,
                creditCard, "Dev", "Java", 0.0, location, "Bachelor");

        try{
            tradesManVerificationService.mailAddressVerification(tradesMan);
            fail("Should throw exception");
        } catch (TradesManException tradesManException){
            assert (true);
        }

    }
}
