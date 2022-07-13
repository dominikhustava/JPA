package entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

//Example when we need to use not numeric ID cuz there is huge amount of records even bigger than Long
@Entity
public class Event {

    @Id
    private String id;

    private String description;

    //This is not good usage of UUID as ID
    public Event() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
