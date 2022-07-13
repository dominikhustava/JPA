package main;

import entities.Price;
import entities.enums.Currency;

import javax.persistence.Persistence;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // EntityManager
        // manages the context of entities (collection of instances(of entities))

        var emf = Persistence.createEntityManagerFactory("my-persistence-unit");
        var em = emf.createEntityManager();



        try {
            em.getTransaction().begin();

            Price price = new Price();
            price.setAmount(100.0);
            price.setCurrency(Currency.USD);
            em.persist(price);//adding the instance in the context (it's not insert)

            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
        }
    }
}
