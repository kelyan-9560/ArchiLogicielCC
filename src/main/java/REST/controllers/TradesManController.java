package REST.controllers;

import application.TradesManDTO;
import application.TradesManService;
import domain.tradesman.TradesMan;
import domain.tradesman.TradesManId;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TradesManController {

    private final TradesManService tradesManService;


    public TradesManController(TradesManService tradesManService) {
        this.tradesManService = tradesManService;
    }


    @PostMapping(path = "/tradesMan", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void create(@RequestBody TradesManDTO tradesManDTO){
        tradesManService.create(tradesManDTO);
    }


    void getById(TradesManId tradesManId){
        tradesManService.getById(tradesManId);
    }

    List<TradesMan> getAll(){
        return tradesManService.getAll();
    }

    void delete(TradesManId tradesManId){
        tradesManService.delete(tradesManId);
    }


}
