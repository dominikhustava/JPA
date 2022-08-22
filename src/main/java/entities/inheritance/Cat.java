package entities.inheritance;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Cat extends Animal{

    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

//three inheritance strategies in jpa SINGLE_TABLE(DEFAULT), TABLE_PER_CLASS, JOINED
//TABLE PER CLASS is not much used
//Single table should have Id, name, color and the discriminator column to specify the class for distinction