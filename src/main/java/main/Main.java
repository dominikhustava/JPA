package main;



import entities.maps.Person;

import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        // EntityManager
        // manages the context of entities (collection of instances(of entities))

        var emf = Persistence.createEntityManagerFactory("my-persistence-unit");
        var em = emf.createEntityManager();



        try {
            em.getTransaction().begin();

        Person p = new Person();
        p.setName("P1");
        p.setPhoneNumbers(new HashMap<>());

        p.getPhoneNumbers().put("Mobile", "12345");
        p.getPhoneNumbers().put("Home", "45678");

        em.persist(p);

            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }
}
