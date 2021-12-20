import application.CreditCardVerificationService;
import domain.exception.CreditCardException;
import domain.tradesman.CreditCard;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.fail;

public class CreditCardVerificationServiceTest {

    @Test
    public void numberIsValid(){

        CreditCardVerificationService creditCardVerificationService = new CreditCardVerificationService(null);
        CreditCard creditCard = new CreditCard("123456789009876543", "Jean", LocalDateTime.now());

        try{
            creditCardVerificationService.numberIsValid(creditCard);
        } catch (CreditCardException creditCardException){
            fail("Should'nt throw exception");
            assert (false);
        }
    }


    @Test
    public void numberNotValid(){

        CreditCardVerificationService creditCardVerificationService = new CreditCardVerificationService(null);
        CreditCard creditCard = new CreditCard("1234567890", "Jean", LocalDateTime.now());

        try{
            creditCardVerificationService.numberIsValid(creditCard);
            fail("Should throw exception");
        } catch (CreditCardException creditCardException){
            assert (true);
        }

    }

    @Test
    public void expirationDateValid(){
        CreditCardVerificationService creditCardVerificationService = new CreditCardVerificationService(null);
        CreditCard creditCard = new CreditCard("123456789009876543", "Jean", LocalDateTime.now());

        try{
            creditCardVerificationService.expirationDateIsValid(creditCard);
        } catch (CreditCardException creditCardException){
            fail("Should'nt throw exception");
            assert (false);
        }

    }

    @Test
    public void expirationDateNotValid(){
        CreditCardVerificationService creditCardVerificationService = new CreditCardVerificationService(null);
        CreditCard creditCard = new CreditCard("123456789009876543", "Jean", LocalDateTime.of(2010, 12, 15,0,0,0));

        try{
            creditCardVerificationService.expirationDateIsValid(creditCard);
            fail("Should throw exception");
        } catch (CreditCardException creditCardException){
            assert (true);
        }
    }
}
