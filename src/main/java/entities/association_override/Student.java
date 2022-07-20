package entities.association_override;

import javax.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Embedded
    @AssociationOverride(name = "professors", //name of the field in ProfessorDetails
            joinTable = @JoinTable(name = "student_prof", //name of the JoinTable in the DB
                    joinColumns = @JoinColumn(name = "student"), //name of the field from DB join table. FK1
                    inverseJoinColumns = @JoinColumn(name = "prof")))//name of the field from DB join table. FK2
    private ProfessorDetails professorDetails;

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

    public ProfessorDetails getProfessorDetails() {
        return professorDetails;
    }

    public void setProfessorDetails(ProfessorDetails professorDetails) {
        this.professorDetails = professorDetails;
    }
}
