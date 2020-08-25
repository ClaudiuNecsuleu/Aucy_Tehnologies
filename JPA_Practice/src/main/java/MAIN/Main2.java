package MAIN;

import Entity.Department;
import Entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class Main2 {
    public static void main(String[] args)
    {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my-persistence-unit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        Department department = new Department();
        Department department1 = new Department();
        department.setName("Finance");
        department1.setName("IT");

        Employee employee =new Employee();
        employee.setName("Elis");
        employee.setSalary(445);
        employee.setHasDrivingLicente(true);
        employee.setDepartment(department);
        Employee employee1 =new Employee();
        employee1.setName("Vasile");
        employee1.setSalary(654);
        employee1.setHasDrivingLicente(false);
        employee1.setDepartment(department1);
        Employee employee2 =new Employee();
        employee2.setName("Stela");
        employee2.setSalary(300);
        employee2.setHasDrivingLicente(false);
        employee2.setDepartment(department1);

        List<Employee> employees = new ArrayList<>();
        employees.add(employee);
        employees.add(employee1);
        employees.add(employee2);

        department.setEmployees(employees);

        entityTransaction.begin();

        entityManager.persist(department);
        entityManager.persist(department1);
      //  entityManager.persist(employees);
        entityManager.persist(employee);
        entityManager.persist(employee1);
        entityManager.persist(employee2);

        entityTransaction.commit();
        entityManager.close();
    }
}
