package entities;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

//Example when we need to use not numeric ID cuz there is huge amount of records even bigger than Long
@Entity
public class Event {

    @Id
    @GenericGenerator(name = "uuid",
            strategy = "org.hibernate.id.UUIDHexGenerator",
            parameters = {@Parameter(name = "separator", value = "-")}
    )
    @GeneratedValue(generator = "uuid")
    private String id;

    private String description;

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
