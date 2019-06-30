package peanuts;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;
import java.util.UUID;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
class PeanutBowl {

    private static final Logger LOGGER = LoggerFactory.getLogger(PeanutBowl.class);

    @AggregateIdentifier
    private UUID id;
    private int amount;

    // required for axon
    private PeanutBowl(){}

    @CommandHandler
    PeanutBowl(PlaceNewBowlOnTableCommand placeNewBowlOnTableCommand){
        LOGGER.info("handle {}", placeNewBowlOnTableCommand);

        //validation
        Objects.requireNonNull(placeNewBowlOnTableCommand.getId());
        apply(new BowlPlacedOnTableEvent(placeNewBowlOnTableCommand.getId()));
    }

    @CommandHandler
    void handle(FillBowlCommand fillBowlCommand){
        LOGGER.info("handle {}", fillBowlCommand);
        apply(new BowlFilledEvent(id, fillBowlCommand.getAmount()));
    }

    @CommandHandler
    void handle(TakeOutPeanutsCommand takeOutPeanutsCommand){
        LOGGER.info("handle {}", takeOutPeanutsCommand);
        //validation
        if(amount < takeOutPeanutsCommand.getAmount()){
            throw new IllegalArgumentException("not enough peanuts :(");
        }
        apply(new PeanutsTakenOutEvent(id, takeOutPeanutsCommand.getAmount()));
    }

    @EventHandler
    void handle(BowlPlacedOnTableEvent bowlPlacedOnTableEvent){
        LOGGER.info("handle {}", bowlPlacedOnTableEvent);
        this.id = bowlPlacedOnTableEvent.getId();
    }

    @EventHandler
    void handle(BowlFilledEvent bowlFilledEvent){
        LOGGER.info("handle {}", bowlFilledEvent);
        amount += bowlFilledEvent.getAmount();
    }

    @EventHandler
    void handle(PeanutsTakenOutEvent peanutsTakenOutEvent){
        LOGGER.info("handle {}", peanutsTakenOutEvent);
        amount -= peanutsTakenOutEvent.getAmount();
    }

}
