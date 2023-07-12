package baitap12t7.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "department")
@Builder
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String desciption;
    @OneToMany(mappedBy = "department", targetEntity = Employee.class)
    @JsonIgnore
    private List<Employee> employees;

    public Department() {
    }

    public Department(Long id, String name, String desciption, List<Employee> employees) {
        this.id = id;
        this.name = name;
        this.desciption = desciption;
        this.employees = employees;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesciption() {
        return desciption;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
