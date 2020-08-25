package Entity;

import javax.persistence.*;

//prima clasa de test

@Entity
@Table(name="employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idemployee")
    private int id;
    @Column(name="name_employee")
    private String name;
    private double salary;
    private boolean hasDrivingLicente;

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public boolean isHasDrivingLicente() {
        return hasDrivingLicente;
    }

    public void setHasDrivingLicente(boolean hasDrivingLicente) {
        this.hasDrivingLicente = hasDrivingLicente;
    }

    @ManyToOne
    @JoinColumn(name="id_department")
    private Department department;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
