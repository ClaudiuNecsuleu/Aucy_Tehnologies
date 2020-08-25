package Entity;

import javax.persistence.*;
import java.util.List;
import Entity.Employees;

@Entity
@Table(name="jobcagetory")
public class JobCagetory{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_job")
    private int id;
    private String name;

    @OneToMany(mappedBy = "jobCategory")
    private List<Employees> employeesJobCategory;

    public List<Employees> getEmployees() {
        return employeesJobCategory;
    }

    public void setEmployees(List<Employees> employeesJobCategory) {
        this.employeesJobCategory = employeesJobCategory;
    }

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
}
