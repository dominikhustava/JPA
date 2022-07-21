package entities.maps;

import javax.persistence.*;
import java.util.Map;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ElementCollection
    @CollectionTable(name = "phone", joinColumns = @JoinColumn(name = "person"))
    @MapKeyColumn(name = "type")
    @Column(name = "number")
    private Map<String, String> phoneNumbers;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(Map<String, String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }
}