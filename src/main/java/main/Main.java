package main;

import entities.*;
import entities.embeddables.BuildingPK;

import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        // EntityManager
        // manages the context of entities (collection of instances(of entities))

        var emf = Persistence.createEntityManagerFactory("my-persistence-unit");
        var em = emf.createEntityManager();



        try {
            em.getTransaction().begin();

            Company c1 = new Company();
            c1.setName("XYZ");
            c1.setStreet("street");
            c1.setNumber("123");
            em.persist(c1);

            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
        }
    }
}
