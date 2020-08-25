package MAIN;

import Entity.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main3 {
    public static <SET> void main(String[] args)
    {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my-persistence-unit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        Departments departments = new Departments();
        Departments departments1 = new Departments();
        JobCagetory jobCagetory =new JobCagetory();
        JobCagetory jobCagetory1 =new JobCagetory();

        departments.setName("Finance");
        departments1.setName("IT");

        jobCagetory.setName("Software");
        jobCagetory1.setName("Hardware");

        Employees employees =new Employees("Marin","Andrei",true, LocalDate.now(), LocalDate.parse("2022-05-05"),true,"here",1234,76723,"marin@yahoo.com",LocalDate.parse("1999-11-20"),false,300,"Maybe","nu are",true);
        employees.setDepartment(departments);
        employees.setJobCagetory(jobCagetory);

        Employees employees1 =new Employees("Popa","Marcu",true, LocalDate.now(),LocalDate.parse("2022-05-05"),true,"Here",1234,76723,"marin@yahoo.com",LocalDate.parse("1998-05-15"),false,500,"Maybe","nu are",true);
        employees1.setDepartment(departments1);
        employees1.setJobCagetory(jobCagetory1);

        List<Employees> employeest = new ArrayList<>();
        employeest.add(employees);
        employeest.add(employees1);

        departments.setEmployees(employeest);
        jobCagetory.setEmployees(employeest);


        entityTransaction.begin();

        entityManager.persist(departments);
        entityManager.persist(departments1);

        entityManager.persist(jobCagetory);
        entityManager.persist(jobCagetory1);


        entityManager.persist(employees);
        entityManager.persist(employees1);



        entityTransaction.commit();
        entityManager.close();
    }
}
