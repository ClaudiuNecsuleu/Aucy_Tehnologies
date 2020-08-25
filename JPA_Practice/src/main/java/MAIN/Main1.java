package MAIN;

import Entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Main1 {

      public static void main(String[] args)
      {
          EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my-persistence-unit");
          EntityManager entityManager = entityManagerFactory.createEntityManager();
          EntityTransaction entityTransaction = entityManager.getTransaction();

          Product product1 = new Product();
          product1.setName("Piersici");
          product1.setPrice(29.1);
          product1.setDate(LocalDate.now());

          Product product2 = new Product();
          product2.setName("Mere");
          product2.setPrice(5.7);
          product2.setDate(LocalDate.now());

          entityTransaction.begin();
          entityManager.persist(product1);
          entityManager.persist(product2);
          entityTransaction.commit();
          entityManager.close();


      }

}
