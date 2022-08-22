package main;



import entities.inheritance.Product;
import entities.enums.PhoneType;
import entities.inheritance.Animal;
import entities.inheritance.Cat;
import entities.inheritance.Chocolate;
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

            Product p = new Product();
            p.setName("P");

            Chocolate c = new Chocolate();
            c.setkCal(100);
            c.setName("Milka");

            em.persist(p);
            em.persist(c);

            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }
}
