package peanuts;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.UUID;

public class FillBowlCommand {

    @TargetAggregateIdentifier
    private final UUID id;
    private final int amount;

    public FillBowlCommand(UUID id, int amount) {
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
        return "FillBowlCommand{" +
                "id=" + id +
                ", amount=" + amount +
                '}';
    }
}
