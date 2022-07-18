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
            em.persist(p);
//
//            Detail d = new Detail();
//            d.setKcal(400);
//
//            d.setProduct(p);
//            p.setDetail(d);
//
//            em.persist(d);


            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }
}
