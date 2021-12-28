package TradesMan;

import use_cases.tradesman.application.TradesManDTO;
import use_cases.tradesman.application.TradesManService;
import use_cases.tradesman.domain.exception.TradesManException;
import use_cases.tradesman.domain.*;
import use_cases.tradesman.infrastructure.InMemoryTradesManRepository;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class TradesManServiceTest {

    @Test
    void createUser(){

        TradesManRepository tradesManRepository = new InMemoryTradesManRepository();
        TradesManService tradesManService = new TradesManService(tradesManRepository, null);

        final Email email = new Email("kelyan.bervin@gmail.com");
        final CreditCard creditCard = new CreditCard("1234567634", "BERVIN", LocalDateTime.now());
        final Location location = new Location("Ile-de-France", "Ermont");
        final TradesManDTO tradesManDTO = new TradesManDTO("Kélyan", "BERVIN", email,
                creditCard, "Dev", "Java", 0.5, location, "Bachelor");


        //création du TradesMan avec le DTO
        TradesManId idTradesManCreated = tradesManService.create(tradesManDTO); //la création return un id

        //ajout de l'id
        TradesMan tradesMan = TradesMan.of(idTradesManCreated,"Kélyan", "BERVIN", email,
        creditCard, "Dev", "Java", 0.5, location, "Bachelor");

        TradesMan tradesManCreated = tradesManRepository.getById(idTradesManCreated);

        assertEquals(tradesMan, tradesManCreated);

    }

    @Test
    void getUserById(){

        TradesManRepository inMemoryTradesManRepository = new InMemoryTradesManRepository();
        TradesManService tradesManService = new TradesManService(inMemoryTradesManRepository, null);

        final Email email = new Email("kelyan.bervin@gmail.com");
        final TradesManId tradesManId = tradesManService.nextId();
        final CreditCard creditCard = new CreditCard("1234567634", "BERVIN", LocalDateTime.now());
        final Location location = new Location("Ile-de-France", "Ermont");

        final TradesMan tradesMan = TradesMan.of(tradesManId,"Kélyan", "BERVIN", email,
                creditCard, "Dev", "Java", 0.5, location, "Bachelor");


        inMemoryTradesManRepository.add(tradesMan);

        assertEquals(tradesMan, tradesManService.getById(tradesManId));
    }

    @Test
    void getAllUsers(){
        TradesManRepository inMemoryTradesManRepository = new InMemoryTradesManRepository();
        TradesManService tradesManService = new TradesManService(inMemoryTradesManRepository, null);

        //TradesMan1
        final TradesManId tradesManId1 = new TradesManId("1");
        final Email email = new Email("kelyan.bervin@gmail.com");
        final CreditCard creditCard1 = new CreditCard("1234567634", "BERVIN1", LocalDateTime.now());
        final Location location1 = new Location("Ile-de-France", "Ermont1");
        final TradesMan tradesMan1 = TradesMan.of(tradesManId1, "Kélyan1", "BERVIN1", email,
                creditCard1, "Dev1", "Java1", 0.5, location1, "Bachelor1");

        //TradesMan2
        final TradesManId tradesManId2 = new TradesManId("2");
        final Email email2 = new Email("kelyan.bervin2@gmail.com");
        final CreditCard creditCard2 = new CreditCard("1234567634", "BERVIN2", LocalDateTime.now());
        final Location location2 = new Location("Ile-de-France", "Ermon2");
        final TradesMan tradesMan2 = TradesMan.of(tradesManId2,"Kélyan2", "BERVIN2", email2,
                creditCard2, "Dev2", "Java2", 12.0, location2, "Bachelor2");

        List<TradesMan> tradesManList = new ArrayList<>();
        tradesManList.add(tradesMan1);
        tradesManList.add(tradesMan2);

        inMemoryTradesManRepository.add(tradesMan1);
        inMemoryTradesManRepository.add(tradesMan2);

        assertEquals(tradesManService.getAll(), tradesManList);
    }

    @Test
    void deleteUser(){
        TradesManRepository inMemoryTradesManRepository = new InMemoryTradesManRepository();
        TradesManService tradesManService = new TradesManService(inMemoryTradesManRepository, null);

        final TradesManId tradesManId = tradesManService.nextId();
        final Email email = new Email("kelyan.bervin@gmail.com");
        final CreditCard creditCard = new CreditCard("1234567634", "BERVIN", LocalDateTime.now());
        final Location location = new Location("Ile-de-France", "Ermont");

        final TradesMan tradesMan = TradesMan.of(tradesManId,"Kélyan", "BERVIN", email,
                creditCard, "Dev", "Java", 0.5, location, "Bachelor");

        inMemoryTradesManRepository.add(tradesMan);
        inMemoryTradesManRepository.delete(tradesManId);

        try{
            tradesManService.getById(tradesManId);
            fail("Should throw exception");
        } catch (TradesManException tradesManException){
            assert (true);
        }

    }
}
