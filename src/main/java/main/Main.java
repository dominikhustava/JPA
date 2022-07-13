package main;

import entities.Event;
import entities.Product;

import javax.persistence.Persistence;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // EntityManager
        // manages the context of entities (collection of instances(of entities))

        var emf = Persistence.createEntityManagerFactory("my-persistence-unit");
        var em = emf.createEntityManager();

        //Product product = new Product();
        //product.setName("Beer");

        Event event = new Event();
        event.setDescription("ABCD");

        try {
            em.getTransaction().begin();

            em.persist(event);//adding the instance in the context (it's not insert)

            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
        }
    }
}
