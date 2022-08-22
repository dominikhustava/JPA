package main;



import entities.enums.PhoneType;
import entities.inheritance.Animal;
import entities.inheritance.Cat;
import entities.maps.Person;
import entities.maps.Professor;
import entities.maps.Student;

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

            Animal a = new Animal();
            a.setName("B");

            Cat cat = new Cat();
            cat.setName("Duna");
            cat.setColor("white");

            em.persist(a);
            em.persist(cat);

            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }
}
