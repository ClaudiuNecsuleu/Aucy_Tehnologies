package MAIN;

import javax.persistence.*;
import Entity.Product;

import java.util.List;

public class MainUpdate {

    public static void main (String[] args)
    {
        try{
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my-persistence-unit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();


        entityTransaction.begin();

          Query q= entityManager.createQuery("update Product a set a.price=33.3 where a.id=13");
          q.executeUpdate();
          System.err.println("Update successful.");
            Product product = entityManager.find(Product.class ,13 );
            System.out.println("The product is: ");
            System.out.println(product.getId() +" "+ product.getName() +" "+ product.getPrice() +" "+ product.getDate());


        entityTransaction.commit();
        entityManager.close();}
        catch (Exception e)
        {
            System.err.println(e.getMessage()+e);
        }
    }
}
