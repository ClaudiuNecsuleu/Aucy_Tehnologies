package MAIN;

import javax.persistence.*;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

import Entity.Departments;
import Entity.JobCagetory;
import Entity.Employees;

import static java.sql.Types.NULL;


public class MainConsole {

    public static void main (String[] args) throws InterruptedException {




    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my-persistence-unit");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    EntityTransaction entityTransaction = entityManager.getTransaction();


      int choose;
      int choose2=0;

      Scanner sc = new Scanner(System.in);

        do{
        System.out.println("Choose one of the tables : "
                + "\n 1 -> Department" +
                "\n 2 -> JobCategory" +
                "\n 3 -> Employees" +
                "\n 4 -> Employees order by salary and name" +
                "\n 5 -> Exit"
        );


        choose = sc.nextInt();

        if (choose < 4) {
            System.out.println("What do you want?" +
                    "\n 1-> ShowAll " +
                    "\n 2-> Find" +
                    "\n 3-> Update" +
                    "\n 4-> Delete"
            );
            choose2 = sc.nextInt();
        }


        switch (choose) {
            case 1: {
                switch (choose2) {
                    case 1: {
                        try {
                            entityTransaction.begin();
                            Query q = entityManager.createQuery("select a from  Departments a order by a.name");
                            @SuppressWarnings("unchecked")
                            List<Departments> results = q.getResultList();

                            System.out.println("Elements of tabel \"departments\" are: ");
                            for (Departments departments : results) {
                                System.out.println(departments.getId() + " " + departments.getName());
                            }


                            entityTransaction.commit();
                            entityManager.close();
                        } catch (Exception e) {
                            System.err.println(e.getMessage() + e);
                        }
                    }break;
                    case 2: {
                        int id;
                        try {
                            entityTransaction.begin();

                            System.out.println("Introduceti un id: ");
                            id = sc.nextInt();
                            Departments departments = entityManager.find(Departments.class, id);
                            if (departments.getId() != NULL) {
                                System.out.println("Found: " + departments.getName());
                            } else {
                                System.out.println("Not found!");
                            }


                            entityTransaction.commit();
                            entityManager.close();
                        } catch (Exception e) {
                            System.err.println(e.getMessage() + e);
                        }

                    }break;
                    case 3: {
                        try {
                            entityTransaction.begin();
                            Query query = entityManager.createQuery("select a from  Departments a order by a.name");
                            @SuppressWarnings("unchecked")
                            List<Departments> results1 = query.getResultList();

                            System.out.println("Elements of tabel \"departments\" are: ");
                            for (Departments department : results1) {
                                System.out.println(department.getId() + " " + department.getName());
                            }
                            int id_dep;
                            String new_name;
                            System.out.println("Select id: ");
                            id_dep = sc.nextInt();
                            System.out.println("Inset new name: ");
                            new_name = sc.nextLine();

                            Query q1 = entityManager.createQuery("update Departments a set a.name=:name1 where a.id=:id_dep");
                            q1.setParameter("name1", new_name);
                            q1.setParameter("id_dep", id_dep);
                            q1.executeUpdate();
                            System.err.println("Update successful.");
                            Departments departments = entityManager.find(Departments.class, id_dep);
                            System.out.println("The product is: ");
                            System.out.println(departments.getId() + " " + departments.getName());


                            entityTransaction.commit();
                            entityManager.close();
                        } catch (Exception e) {
                            entityTransaction.rollback();
                            System.err.println(e.getMessage() + e);
                        }
                    }break;
                    case 4: {
                        try {
                            entityTransaction.begin();
                            Query query = entityManager.createQuery("select a from  Departments a order by a.name");
                            @SuppressWarnings("unchecked")
                            List<Departments> results1 = query.getResultList();

                            System.out.println("Elements of tabel \"departments\" are: ");
                            for (Departments department : results1) {
                                System.out.println(department.getId() + " " + department.getName());
                            }

                            int id_del;
                            System.out.println("what id do you want to delete?");
                            id_del = sc.nextInt();

                            Query q = entityManager.createQuery("delete Departments a where a.id=:id_del");
                            q.setParameter("id_del", id_del);
                            q.executeUpdate();
                            System.err.println("Delete successful.");
                            Departments departments = entityManager.find(Departments.class, 4);
                            if (departments.getId() != NULL)
                                System.out.println("Found: " + departments.getId());
                            else
                                System.out.println("Unavailable .");

                            System.out.println();
                            System.out.println("The new list is: ");
                            Query query1 = entityManager.createQuery("select a from  Departments a order by a.name");
                            @SuppressWarnings("unchecked")
                            List<Departments> results2 = query1.getResultList();

                            System.out.println("Elements of tabel \"departments\" are: ");
                            for (Departments department1 : results2) {
                                System.out.println(department1.getId() + " " + department1.getName());
                            }

                            entityTransaction.commit();
                            entityManager.close();
                        } catch (Exception e) {
                            entityTransaction.rollback();
                            System.out.println(e.getMessage() + e);
                        }

                    }break;

                }

            }
            break;
            case 2: {
                switch (choose2) {
                    case 1: {
                        try {
                            entityTransaction.begin();
                            Query q = entityManager.createQuery("select a from  JobCagetory a order by a.name");
                            @SuppressWarnings("unchecked")
                            List<JobCagetory> results = q.getResultList();

                            System.out.println("Elements of tabel \"jobCagetory\" are: ");
                            for (JobCagetory jobCagetory : results) {
                                System.out.println(jobCagetory.getId() + " " + jobCagetory.getName());
                            }


                            entityTransaction.commit();
                            entityManager.close();
                        } catch (Exception e) {
                            System.err.println(e.getMessage() + e);
                        }
                    }break;
                    case 2: {
                        int id;
                        try {
                            entityTransaction.begin();

                            System.out.println("Insert id: ");
                            id = sc.nextInt();
                            JobCagetory jobCagetory = entityManager.find(JobCagetory.class, id);
                            if (jobCagetory.getId() != NULL) {
                                System.out.println("Found: " + jobCagetory.getName());
                            } else {
                                System.out.println("Not found!");
                            }


                            entityTransaction.commit();
                            entityManager.close();
                        } catch (Exception e) {
                            System.err.println(e.getMessage() + e);
                        }

                    }break;
                    case 3: {
                        try {
                            entityTransaction.begin();
                            Query query = entityManager.createQuery("select a from  JobCagetory a order by a.name");
                            @SuppressWarnings("unchecked")
                            List<JobCagetory> results1 = query.getResultList();

                            System.out.println("Elements of tabel \"departments\" are: ");
                            for (JobCagetory jobCagetory : results1) {
                                System.out.println(jobCagetory.getId() + " " + jobCagetory.getName());
                            }
                            int id_dep;
                            String new_name;
                            System.out.println("Select id: ");
                            id_dep = sc.nextInt();
                            System.out.println("Inset new name: ");
                            new_name = sc.nextLine();

                            Query q1 = entityManager.createQuery("update JobCagetory a set a.name=:name1 where a.id=:id_dep");
                            q1.setParameter("name1", new_name);
                            q1.setParameter("id_dep", id_dep);
                            q1.executeUpdate();
                            System.err.println("Update successful.");
                            JobCagetory jobCagetory = entityManager.find(JobCagetory.class, id_dep);
                            System.out.println("The product is: ");
                            System.out.println(jobCagetory.getId() + " " + jobCagetory.getName());


                            entityTransaction.commit();
                            entityManager.close();
                        } catch (Exception e) {
                            entityTransaction.rollback();
                            System.err.println(e.getMessage() + e);
                        }
                    }break;
                    case 4: {
                        try {
                            entityTransaction.begin();
                            Query query = entityManager.createQuery("select a from  JobCagetory a order by a.name");
                            @SuppressWarnings("unchecked")
                            List<JobCagetory> results1 = query.getResultList();

                            System.out.println("Elements of tabel \"jobCagetory\" are: ");
                            for (JobCagetory jobCagetory : results1) {
                                System.out.println(jobCagetory.getId() + " " + jobCagetory.getName());
                            }

                            int id_del;
                            System.out.println("what id do you want to delete?");
                            id_del = sc.nextInt();

                            Query q = entityManager.createQuery("delete JobCagetory a where a.id=:id_del");
                            q.setParameter("id_del", id_del);
                            q.executeUpdate();
                            System.err.println("Delete successful.");
                            JobCagetory jobCagetory = entityManager.find(JobCagetory.class, 4);
                            if (jobCagetory.getId() != NULL)
                                System.out.println("Found: " + jobCagetory.getId());
                            else
                                System.out.println("Unavailable .");

                            System.out.println();
                            System.out.println("The new list is: ");
                            Query query1 = entityManager.createQuery("select a from  JobCagetory a order by a.name");
                            @SuppressWarnings("unchecked")
                            List<JobCagetory> results2 = query1.getResultList();

                            System.out.println("Elements of tabel \"departments\" are: ");
                            for (JobCagetory jobCagetory1 : results2) {
                                System.out.println(jobCagetory1.getId() + " " + jobCagetory1.getName());
                            }

                            entityTransaction.commit();
                            entityManager.close();
                        } catch (Exception e) {
                            entityTransaction.rollback();
                            System.out.println(e.getMessage() + e);
                        }

                    }
                   break;
                }

            }
            break;
            case 3: {
                switch (choose2) {
                    case 1: {
                        try {
                            entityTransaction.begin();
                            Query q = entityManager.createQuery("select a from  Employees a order by a.fistName");
                            @SuppressWarnings("unchecked")
                            List<Employees> results = q.getResultList();

                            System.out.println("Elements of tabel \"Employees\" are: ");
                            for (Employees employees : results) {
                                System.out.println(employees.getId() + " " + employees.getFistName() + " " + employees.getLastName() + " " + employees.getSalary());
                            }


                            entityTransaction.commit();
                            entityManager.close();
                        } catch (Exception e) {
                            System.err.println(e.getMessage() + e);
                        }
                    }
                    break;
                    case 2: {
                        int id;
                        try {
                            entityTransaction.begin();

                            System.out.println("Insert id: ");
                            id = sc.nextInt();
                            Employees employees = entityManager.find(Employees.class, id);
                            if (employees.getId() != NULL) {
                                System.out.println("Found: " + employees.getFistName() + " " + employees.getSalary());
                            } else {
                                System.out.println("Not found!");
                            }


                            entityTransaction.commit();
                            entityManager.close();
                        } catch (Exception e) {
                            System.err.println(e.getMessage() + e);
                        }

                    }
                    break;
                    case 3: {

                        try {
                            entityTransaction.begin();
                            Query query = entityManager.createQuery("select a from  Employees a order by a.fistName");
                            @SuppressWarnings("unchecked")
                            List<Employees> results1 = query.getResultList();

                            System.out.println("Elements of tabel \"employees\" are: ");
                            for (Employees employees : results1) {
                                System.out.println(employees.getId() + " " + employees.getFistName() + " " + employees.getSalary());
                            }
                            int id_dep;
                            double new_salary;
                            System.out.println("Select id: ");
                            id_dep = sc.nextInt();

                            System.out.println("Inset new salary: ");
                            new_salary = sc.nextDouble();

                            Query q1 = entityManager.createQuery("update Employees a set a.salary=:name1 where a.id=:id_dep");
                            q1.setParameter("name1", new_salary);
                            q1.setParameter("id_dep", id_dep);
                            q1.executeUpdate();
                            System.err.println("Update successful.");

                            entityTransaction.commit();
                            entityManager.close();

                            //************

                        } catch (Exception e) {
                            entityTransaction.rollback();
                            System.err.println(e.getMessage() + e);
                        }

                    }
                    break;
                    case 4: {
                        try {
                            entityTransaction.begin();
                            Query query = entityManager.createQuery("select a from  Employees a order by a.fistName");
                            @SuppressWarnings("unchecked")
                            List<Employees> results1 = query.getResultList();

                            System.out.println("Elements of tabel \"employees\" are: ");
                            for (Employees employees : results1) {
                                System.out.println(employees.getId() + " " + employees.getFistName() + " " + employees.getSalary());
                            }

                            int id_del;
                            System.out.println("what id do you want to delete?");
                            id_del = sc.nextInt();

                            Query q = entityManager.createQuery("delete Employees a where a.id=:id_del");
                            q.setParameter("id_del", id_del);
                            q.executeUpdate();
                            System.err.println("Delete successful.");
                            Employees employees1 = entityManager.find(Employees.class, 4);
                            if (employees1.getId() != NULL)
                                System.out.println("Found: " + employees1.getId());
                            else
                                System.out.println("Unavailable .");

                            System.out.println();
                            System.out.println("The new list is: ");
                            Query query1 = entityManager.createQuery("select a from  Employees a order by a.fistName");
                            @SuppressWarnings("unchecked")
                            List<Employees> results2 = query1.getResultList();

                            System.out.println("Elements of tabel \"departments\" are: ");
                            for (Employees employees2 : results2) {
                                System.out.println(employees2.getId() + " " + employees2.getFistName() + " " + employees2.getSalary());
                            }

                            entityTransaction.commit();
                            entityManager.close();
                        } catch (Exception e) {
                            entityTransaction.rollback();
                            System.out.println(e.getMessage() + e);
                        }

                    }
                    break;

                }


            }
            break;
            case 4: {
                try {
                    entityTransaction.begin();

                    System.out.println("list of employees sorted by name : ");
                    Query query = entityManager.createQuery("select b from Employees b  order by b.fistName asc ");
                    @SuppressWarnings("unchecked")
                    List<Employees> newResults = query.getResultList();
                    for (Employees employees : newResults) {
                        System.out.println(employees.getFistName() + " " + employees.getSalary());
                    }

                    System.out.println("*****************************************");
                    System.out.println("list of employees sorted by salary : ");

                    Query query1 = entityManager.createQuery("select g from Employees g  order by g.salary ");
                    @SuppressWarnings("unchecked")
                    List<Employees> newResults1 = query1.getResultList();
                    for (Employees employees1 : newResults1) {
                        System.out.println(employees1.getFistName() + " " + employees1.getSalary());
                    }

                    entityTransaction.commit();
                    entityManager.close();
                } catch (Exception e) {
                    System.err.println(e.getMessage() + e);
                }
            }
            break;
            case 5: {
                System.exit(0);
            }
            break;
            default: {
                System.out.println("Close");
            }
            break;

        }
}while(true);



  }


}
