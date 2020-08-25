package MAIN;

import javax.persistence.*;
import java.util.List;
import Entity.Employee;
import Entity.Department;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

public class MainDepartamentList {
    public static void main (String[] args)
    {

        try{
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my-persistence-unit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();




        entityTransaction.begin();
        //  Product product = entityManager.find(Product.class ,4);
        //  System.out.println("Found: "+product.getId());

        Query q= entityManager.createQuery("select a from  Department a group by a.id");
        @SuppressWarnings("unchecked")
        List<Department> results = q.getResultList();

        System.out.println("Elements of table \"department\" are: ");
        for (Department department : results)
        {
            System.out.print( department.getName()+" : ");

            for( Employee employee : department.getEmployees())
            {
                System.out.print(employee.getName()+" ");

            }

            System.out.println();
        }
        System.out.println("list of employees sorted by name : ");
            Query query= entityManager.createQuery("select b from Employee b  order by b.name,b.salary asc ");
            @SuppressWarnings("unchecked")
            List<Employee> newResults = query.getResultList();
            for (Employee employee : newResults) {
                System.out.println(employee.getName() + " "+employee.getSalary());
            }

            System.out.println("*****************************************");
            System.out.println("list of employees sorted by salary : ");
            
            Query query1= entityManager.createQuery("select g from Employee g  order by g.salary ");
            @SuppressWarnings("unchecked")
            List<Employee> newResults1 = query1.getResultList();
            for (Employee employee1 : newResults1) {
                System.out.println(employee1.getName() + " "+employee1.getSalary());
            }

        entityTransaction.commit();
        entityManager.close();}
        catch (Exception e)
        {
            System.err.println(e.getMessage()+e);
        }
    }
}
