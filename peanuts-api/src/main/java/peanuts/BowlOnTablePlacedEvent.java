package peanuts;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.UUID;

public class BowlOnTablePlacedEvent {

    @TargetAggregateIdentifier
    private UUID id;

    public BowlOnTablePlacedEvent(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    @Override
    public String toString() {
        return "BowlOnTablePlacedEvent{" +
                "id=" + id +
                '}';
    }
}
