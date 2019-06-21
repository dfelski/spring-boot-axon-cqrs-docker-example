package peanuts.query;

import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import peanuts.BowlFilledEvent;
import peanuts.BowlOnTablePlacedEvent;
import peanuts.PeanutsTakenOutEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
class PeanutProjection {

    private Logger LOGGER = LoggerFactory.getLogger(PeanutProjection.class);

    private Map<UUID, Integer> peanuts = new HashMap<>();

    @EventHandler
    void handle(BowlOnTablePlacedEvent bowlOnTablePlacedEvent){
        LOGGER.info("handle {}", bowlOnTablePlacedEvent);
        peanuts.put(bowlOnTablePlacedEvent.getId(), 0);
    }

    @EventHandler
    void handle(BowlFilledEvent bowlFilledEvent){
        LOGGER.info("handle {}", bowlFilledEvent);
        peanuts.put(bowlFilledEvent.getId(),
                peanuts.get(bowlFilledEvent.getId()) + bowlFilledEvent.getAmount());
    }

    @EventHandler
    void handle(PeanutsTakenOutEvent peanutsTakenOutEvent){
        LOGGER.info("handle {}", peanutsTakenOutEvent);
        peanuts.put(peanutsTakenOutEvent.getId(),
                peanuts.get(peanutsTakenOutEvent.getId()) - peanutsTakenOutEvent.getAmount());
    }

    @QueryHandler
    public PeanutsInBowlResult handle(PeanutsQuery peanutsQuery){
        if(!peanuts.containsKey(peanutsQuery.getId())) {
            throw new IllegalArgumentException("no bowl with id '"+peanutsQuery.getId()+"' found");
        }
        return new PeanutsInBowlResult(peanuts.get(peanutsQuery.getId()));
    }


}
