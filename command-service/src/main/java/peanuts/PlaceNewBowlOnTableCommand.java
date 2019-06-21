package peanuts;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.Objects;
import java.util.UUID;

public class PlaceNewBowlOnTableCommand {

    @TargetAggregateIdentifier
    private final UUID id;

    public PlaceNewBowlOnTableCommand(UUID id) {
        this.id = Objects.requireNonNull(id);
    }

    public UUID getId() {
        return id;
    }

    @Override
    public String toString() {
        return "PlaceNewBowlOnTableCommand{" +
                "id=" + id +
                '}';
    }

}
