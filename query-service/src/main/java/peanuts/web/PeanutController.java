package peanuts.web;

import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import peanuts.query.PeanutsInBowlResult;
import peanuts.query.PeanutsQuery;

import java.util.UUID;

@RestController
public class PeanutController {

    private QueryGateway queryGateway;

    PeanutController(QueryGateway queryGateway){
        this.queryGateway = queryGateway;
    }

    @GetMapping("/bowl/{id}/peanuts")
    String query(@PathVariable("id") UUID id) throws Exception {
        PeanutsInBowlResult peanutsInBowlResult = queryGateway.query(
                new PeanutsQuery(id), PeanutsInBowlResult.class).get();
        return "peanuts in bowl: "+peanutsInBowlResult.getAmount();
    }

}
