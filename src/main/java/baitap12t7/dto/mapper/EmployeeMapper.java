package baitap12t7.dto.mapper;

import baitap12t7.dto.entityDto.EmployeeDto;
import baitap12t7.model.entity.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeMapper implements IEmployeeMapper {
    @Override
    public Employee toEntity(EmployeeDto dto) {
        Employee employee = new Employee();
        employee.setId(dto.getId());
        employee.setName(dto.getName());
        employee.setEmail(dto.getEmail());
        employee.setDepartment(dto.getDepartment());
        employee.setRole(dto.getRoles());
        return employee;
    }

    @Override
    public EmployeeDto toDto(Employee entity) {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(entity.getId());
        employeeDto.setName(entity.getName());
        employeeDto.setEmail(entity.getEmail());
        employeeDto.setDepartment(entity.getDepartment());
        employeeDto.setRoles(entity.getRole());
        return employeeDto;
    }

    @Override
    public List<Employee> toEntity(List<EmployeeDto> dtoList) {
        List<Employee> employeeList = new ArrayList<>();
        for (EmployeeDto e : dtoList) {
            employeeList.add(toEntity(e));
        }
        return employeeList;
    }

    @Override
    public List<EmployeeDto> toDto(List<Employee> EntityList) {
        List<EmployeeDto> employeeDtoList = new ArrayList<>();
        for (Employee e : EntityList) {
            employeeDtoList.add(toDto(e));
        }
        return employeeDtoList;
    }
}
