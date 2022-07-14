package main;

import entities.*;
import entities.embeddables.Address;
import entities.enums.Currency;

import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

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

            Product p = new Product();
            p.setExpDate(LocalDate.now());
            em.persist(p);

            Event e = new Event();
            e.setEventTime(LocalDateTime.now());
            em.persist(e);

            Employee emp = new Employee();
            emp.setEmpDate(new Date());
            em.persist(emp);

            Company c = new Company();
            c.setName("Amazon");
            c.setAddress(new Address());
            c.getAddress().setCity("London");
            c.getAddress().setStr("london street");
            c.getAddress().setNo("4");
            em.persist(c);

            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
        }
    }
}
