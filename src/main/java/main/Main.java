package main;

import entities.*;
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

            Student s1 = new Student();
            s1.setName("Student 1");

            Professor p1 = new Professor();
            p1.setName("Professor 1");
            p1.setStudents(new ArrayList<>());
            p1.getStudents().add(s1);

            em.persist(p1);
            em.persist(s1);

            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }
}
