package peanuts.web;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import peanuts.FillBowlCommand;
import peanuts.PlaceNewBowlOnTableCommand;
import peanuts.TakeOutPeanutsCommand;

import java.util.UUID;

@RestController
class PeanutBowlController {

    @Autowired
    private CommandGateway commandGateway;

    @PostMapping("/bowl")
    String create(){
        UUID id = UUID.randomUUID();
        commandGateway.sendAndWait(new PlaceNewBowlOnTableCommand(id));
        return "Oh, look! A new bowl on the table! "+id;
    }

    @PutMapping("/bowl/{id}/peanuts")
    void fill(@PathVariable("id") UUID id, @RequestBody FillingDTO fillingDTO){
        commandGateway.sendAndWait(new FillBowlCommand(id, fillingDTO.getAmount()));
    }

    @DeleteMapping("/bowl/{id}/peanuts")
    void takeOut(@PathVariable("id") UUID id, @RequestBody TakeOutDTO takeOutDTO){
        commandGateway.sendAndWait(new TakeOutPeanutsCommand(id, takeOutDTO.getAmount()));
    }

}
