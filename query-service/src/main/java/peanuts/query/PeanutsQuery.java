package peanuts.query;

import java.util.UUID;

public class PeanutsQuery {

    private UUID id;

    public PeanutsQuery(UUID id){
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

}
