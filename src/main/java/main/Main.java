package main;

import entities.*;
import entities.association_override.Professor;
import entities.association_override.ProfessorDetails;
import entities.association_override.Student;
import entities.embeddables.BuildingPK;

import javax.persistence.Persistence;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // EntityManager
        // manages the context of entities (collection of instances(of entities))

        var emf = Persistence.createEntityManagerFactory("my-persistence-unit");
        var em = emf.createEntityManager();



        try {
            em.getTransaction().begin();

//           Department d1 = new Department();
//           d1.setName("Department 1");
//
//           DepartmentDetails dd1 = new DepartmentDetails();
//           dd1.setContractNo("ABC123");
//           dd1.setDepartment(d1);
//
//           Employee e1 = new Employee();
//           e1.setName("Emplo 1");
//           e1.setDepartmentDetails(dd1);
//
//           em.persist(e1);
//           em.persist(d1);

            Professor p1 = new Professor();
            p1.setName("Professor H");

            ProfessorDetails pd = new ProfessorDetails();
            pd.setProfessors(new ArrayList<>());
            pd.getProfessors().add(p1);

            Student s1 = new Student();
            s1.setName("Student D");
            s1.setProfessorDetails(pd);

            em.persist(p1);
            em.persist(s1);


            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }
}
