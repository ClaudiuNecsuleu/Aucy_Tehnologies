package Entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="employees")
public class Employees {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String fistName;
    private String lastName;
    private boolean IsManager;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean active;
    private String address;
    private int CP;
    private double telephone;
    private String email;
    private LocalDate birthday;
    private boolean noChildren;
    private double salary;
    private String studies;
    private String socialSecurityNumber;
    private boolean hasDrivingLicense;

    @ManyToOne
    @JoinColumn(name="departmentId")
    private Departments departments;
    @ManyToOne
    @JoinColumn(name="JobCategoryId")
    private JobCagetory jobCategory;


    public  Employees(String fistName, String lastName, boolean isManager, LocalDate startDate
            , LocalDate endDate, boolean active, String address, int CP, double telephone, String email, LocalDate birthday, boolean noChildren
            , double salary, String studies, String socialSecurityNumber, boolean hasDrivingLicense)
    {
        this.fistName=fistName;
        this.lastName=lastName;
        this.IsManager=isManager;
        this.startDate=startDate;
        this.endDate=endDate;
        this.active=active;
        this.address=address;
        this.CP=CP;
        this.telephone=telephone;
        this.email=email;
        this.birthday=birthday;
        this.noChildren=noChildren;
        this.salary=salary;
        this.studies=studies;
        this.socialSecurityNumber=socialSecurityNumber;
        this.hasDrivingLicense=hasDrivingLicense;

    }

    public Employees() {

    }

    public Departments getDepartment() {
        return departments;
    }

    public void setDepartment(Departments departments) {
        this.departments = departments;
    }

    public JobCagetory getJobCagetory() {
        return jobCategory;
    }

    public void setJobCagetory(JobCagetory jobCagetory) {
        this.jobCategory = jobCagetory;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFistName() {
        return fistName;
    }

    public void setFistName(String fistName) {
        this.fistName = fistName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isManager() {
        return IsManager;
    }

    public void setManager(boolean manager) {
        IsManager = manager;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCP() {
        return CP;
    }

    public void setCP(int CP) {
        this.CP = CP;
    }

    public  double getTelephone() {
        return telephone;
    }

    public void setTelephone( double telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public boolean isNoChildren() {
        return noChildren;
    }

    public void setNoChildren(boolean noChildren) {
        this.noChildren = noChildren;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getStudies() {
        return studies;
    }

    public void setStudies(String studies) {
        this.studies = studies;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public boolean isHasDrivingLicense() {
        return hasDrivingLicense;
    }

    public void setHasDrivingLicense(boolean hasDrivingLicense) {
        this.hasDrivingLicense = hasDrivingLicense;
    }
}
