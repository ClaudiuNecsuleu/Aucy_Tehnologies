package MAIN;

import javax.persistence.*;
import Entity.Product;

import static java.sql.Types.NULL;

public class MainDelete {

    public static void main (String[] args)
    {
        try {

            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my-persistence-unit");
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            EntityTransaction entityTransaction = entityManager.getTransaction();


            entityTransaction.begin();

            Query q = entityManager.createQuery("delete Product a where a.id=12");
            q.executeUpdate();
            System.err.println("Delete successful.");
            Product product = entityManager.find(Product.class, 4);
            if (product.getId() != NULL)
                System.out.println("Found: " + product.getId());
            else
                System.out.println("Unavailable .");

            entityTransaction.commit();
            entityManager.close();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage()+e);
        }
    }
}
