import application.TradesManDTO;
import application.TradesManService;
import domain.exception.TradesManException;
import domain.tradesman.*;
import infrastructure.InMemoryTradesManRepository;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class TradesManServiceTest {

    @Test
    void createUser(){

        TradesManRepository tradesManRepository = new InMemoryTradesManRepository();
        TradesManService tradesManService = new TradesManService(tradesManRepository, null);

        final CreditCard creditCard = new CreditCard("1234567634", "BERVIN", new Date());
        final Location location = new Location("Ile-de-France", "Ermont");
        final TradesManDTO tradesManDTO = new TradesManDTO("Kélyan", "BERVIN", "kelyan.bervin@gmail.com",
                creditCard, "Dev", "Java", 0.5, location, "Bachelor");


        //création du TradesMan avec le DTO
        TradesManId idTradesManCreated = tradesManService.create(tradesManDTO); //la création return un id

        //ajout de l'id
        TradesMan tradesMan = TradesMan.of(idTradesManCreated,"Kélyan", "BERVIN", "kelyan.bervin@gmail.com",
        creditCard, "Dev", "Java", 0.5, location, "Bachelor");

        TradesMan tradesManCreated = tradesManRepository.getById(idTradesManCreated);

        assertEquals(tradesMan, tradesManCreated);

    }

    @Test
    void getUserById(){

        TradesManRepository inMemoryTradesManRepository = new InMemoryTradesManRepository();
        TradesManService tradesManService = new TradesManService(inMemoryTradesManRepository, null);

        final TradesManId tradesManId = tradesManService.nextId();
        final CreditCard creditCard = new CreditCard("1234567634", "BERVIN", new Date());
        final Location location = new Location("Ile-de-France", "Ermont");

        final TradesMan tradesMan = TradesMan.of(tradesManId,"Kélyan", "BERVIN", "kelyan.bervin@gmail.com",
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
        final CreditCard creditCard1 = new CreditCard("1234567634", "BERVIN1", new Date());
        final Location location1 = new Location("Ile-de-France", "Ermont1");
        final TradesMan tradesMan1 = TradesMan.of(tradesManId1, "Kélyan1", "BERVIN1", "kelyan.bervin@gmail.com",
                creditCard1, "Dev1", "Java1", 0.5, location1, "Bachelor1");

        //TradesMan2
        final TradesManId tradesManId2 = new TradesManId("2");
        final CreditCard creditCard2 = new CreditCard("1234567634", "BERVIN2", new Date());
        final Location location2 = new Location("Ile-de-France", "Ermon2");
        final TradesMan tradesMan2 = TradesMan.of(tradesManId2,"Kélyan2", "BERVIN2", "kelyan.bervin@gmail.com",
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
        final CreditCard creditCard = new CreditCard("1234567634", "BERVIN", new Date());
        final Location location = new Location("Ile-de-France", "Ermont");

        final TradesMan tradesMan = TradesMan.of(tradesManId,"Kélyan", "BERVIN", "kelyan.bervin@gmail.com",
                creditCard, "Dev", "Java", 0.5, location, "Bachelor");

        inMemoryTradesManRepository.add(tradesMan);
        inMemoryTradesManRepository.delete(tradesManId);

        try{
            tradesManService.getById(tradesManId);
            fail("Should throw exception");
            System.out.println("ok");
        } catch (TradesManException tradesManException){
            assert (true);
        }
    }
}
