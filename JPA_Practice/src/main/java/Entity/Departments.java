package Entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="department")
public class Departments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_dep")
    private int id;
    private String name;

    @OneToMany(mappedBy = "departments")
    private List<Employees> employeesDepartment;

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

    public List<Employees> getEmployees() {
        return employeesDepartment;
    }

    public void setEmployees(List<Employees> employees) {
        this.employeesDepartment = employees;
    }
}
