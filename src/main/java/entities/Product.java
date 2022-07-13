package entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Product {

    @Id
    @TableGenerator(name = "key_generator",
            pkColumnName = "key_name", pkColumnValue = "Product",
            valueColumnName = "key_value"
            //allocationSize = 20 //for id intervals

    )
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "key_generator")
    private Integer id;
/*TABLE type is similar to sequence(sequence not supported mysql)
* We have to create table in DB with custom name -> in this example "key_generator"
* It has to have 2 columns with  names:
* key_name(VARCHAR(100))
* key_value(INT)
* for this entity the value in key_name(pkColumnValue) will be "Product"
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