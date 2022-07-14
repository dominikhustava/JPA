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

            Product p = new Product();
            p.setName("Beer");
            p.setPrice(20.5);
            em.persist(p);// yes we have to persist it to context here cuz it would not be known in context at line 29
            //yes there is configuration alternative - to use cascade=CascadeType.PERSIST (or CascadeType.ALL)
            // on @OneToOne

            Detail d = new Detail();
            d.setKcal(400);
            d.setProduct(p);
            em.persist(d);


            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
        }
    }
}
