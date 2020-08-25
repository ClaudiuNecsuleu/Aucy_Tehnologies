package MAIN;

import javax.persistence.*;
import Entity.Product;
import java.util.List;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;


public class MainSelectAll {

    public static void main (String[] args)
    {
        try {
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my-persistence-unit");
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            EntityTransaction entityTransaction = entityManager.getTransaction();

            entityTransaction.begin();
            //  Product product = entityManager.find(Product.class ,4);
            //  System.out.println("Found: "+product.getId());

            //  Query q= entityManager.createQuery("select a from  Product  a group by a.id");
            Query q = entityManager.createQuery("select a from  Product  a order by a.price");
            @SuppressWarnings("unchecked")
            List<Product> results = q.getResultList();

            System.out.println("Elements of tabel \"product\" are: ");
            for (Product product : results) {
                System.out.println(product.getId() + " " + product.getName() + " " + product.getPrice() + " " + product.getDate());
            }


            entityTransaction.commit();
            entityManager.close();
        }catch (Exception e)
        {
            System.err.println(e.getMessage()+e);
        }
    }
}
