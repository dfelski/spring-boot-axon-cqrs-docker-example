package peanuts;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.UUID;

public class BowlPlacedOnTableEvent {

    @TargetAggregateIdentifier
    private UUID id;

    public BowlPlacedOnTableEvent(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    @Override
    public String toString() {
        return "BowlPlacedOnTableEvent{" +
                "id=" + id +
                '}';
    }
}
