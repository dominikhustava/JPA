package entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "key_generator")
    private Integer id;
/*TABLE type is similar to sequence(sequence not supported mysql)
* We have to create table in DB with custom name -> in this example "key_generator"
* It has to have 2 columns with default names:
* sequence_name(VARCHAR(100))
* next_val(INT)
* */


    @Basic(optional = false)//must be filled
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}