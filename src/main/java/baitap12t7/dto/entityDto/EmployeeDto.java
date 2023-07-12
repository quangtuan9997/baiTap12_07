package baitap12t7.dto.entityDto;

import baitap12t7.model.entity.Department;
import baitap12t7.model.entity.Role;

import java.util.HashSet;
import java.util.Set;

public class EmployeeDto {
    private Long id;
    private String name;
    private String email;
    private Department department;
    private Set<Role> roles=new HashSet<>();

    public EmployeeDto(Long id, String name, String email, Department department, Set<Role> roles) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.department = department;
        this.roles = roles;
    }

    public EmployeeDto() {

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
