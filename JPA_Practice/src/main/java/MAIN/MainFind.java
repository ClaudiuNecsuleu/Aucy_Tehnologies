package MAIN;

import javax.persistence.*;
import Entity.Product;

public class MainFind {

    public static void main (String[] args)
    {
        try {
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my-persistence-unit");
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            EntityTransaction entityTransaction = entityManager.getTransaction();


            entityTransaction.begin();

            Product product = entityManager.find(Product.class, 3);
            System.out.println("Found: " + product.getName());


            entityTransaction.commit();
            entityManager.close();
        }catch (Exception e)
        {
            System.err.println(e.getMessage()+e);
        }
    }
}
