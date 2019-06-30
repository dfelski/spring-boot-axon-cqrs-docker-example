package peanuts;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.UUID;

public class PeanutsTakenOutEvent {

    @TargetAggregateIdentifier
    private UUID id;
    private int amount;

    public PeanutsTakenOutEvent(UUID id, int amount) {
        this.id = id;
        this.amount = amount;
    }

    public UUID getId() {
        return id;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "PeanutsTakenOutEvent{" +
                "id=" + id + ", amount=" + amount +'}';
    }

}
