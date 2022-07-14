package main;

import entities.*;

import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        // EntityManager
        // manages the context of entities (collection of instances(of entities))

        var emf = Persistence.createEntityManagerFactory("my-persistence-unit");
        var em = emf.createEntityManager();



        try {
            em.getTransaction().begin();

            Department d = new Department();
            d.setCode("ABCd");
            d.setName("Dep 1");
            d.setNo(10);
            em.persist(d);

            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
        }
    }
}
