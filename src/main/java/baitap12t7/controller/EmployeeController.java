package baitap12t7.controller;

import baitap12t7.dto.entityDto.EmployeeDto;
import baitap12t7.dto.mapper.IEmployeeMapper;
import baitap12t7.model.entity.Employee;
import baitap12t7.model.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/api")
public class EmployeeController {
    private IEmployeeService employeeService;
    private IEmployeeMapper employeeMapper;

    public EmployeeController(IEmployeeMapper employeeMapper) {
        this.employeeMapper = employeeMapper;
    }

    @Autowired
    public EmployeeController(IEmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employee")
    public ResponseEntity<?> findAll(@RequestParam(name = "name", required = false) String name, Pageable pageable) {
        Page<Employee> employees;
        if (name != null && !name.isEmpty()) {
            employees = employeeService.findByNameContainsIgnoreCase(name, pageable);
            Page<EmployeeDto> employeeDtos = employees.map(employeeMapper::toDto);
            return new ResponseEntity<>(employeeDtos, HttpStatus.OK);
        }
        employees = employeeService.findAll(pageable);
        Page<EmployeeDto> employeeDtos = employees.map(employeeMapper::toDto);
        return new ResponseEntity<>(employeeDtos, HttpStatus.OK);
    }

    @PostMapping("/employee")
    public ResponseEntity<?> create(@RequestBody EmployeeDto employeeDto) {
        if (employeeService.existsByEmail(employeeDto.getEmail())) {
            return new ResponseEntity<>("email existed, please try again!", HttpStatus.BAD_REQUEST);
        }
        employeeService.save(employeeMapper.toEntity(employeeDto));
        return new ResponseEntity<>(employeeDto, HttpStatus.CREATED);
    }

    @PutMapping("/employee")
    public ResponseEntity<?> update(@RequestBody EmployeeDto employeeDto) {
        Optional<Employee> employee = employeeService.findById(employeeDto.getId());
        if (employee.isPresent()) {
            if (!employee.get().getEmail().equals(employeeDto.getEmail())) {
                if (employeeService.existsByEmail(employeeDto.getEmail())) {
                    return new ResponseEntity<>("email existed, please try again!", HttpStatus.BAD_REQUEST);
                } else {
                    employee.get().setName(employeeDto.getName());
                    employee.get().setEmail(employeeDto.getEmail());
                    employee.get().setDepartment(employeeDto.getDepartment());
                    employee.get().setRole(employeeDto.getRoles());
                    employeeService.save(employee.get());
                    return new ResponseEntity<>(employeeDto, HttpStatus.OK);
                }
            } else {
                employee.get().setName(employeeDto.getName());
                employee.get().setEmail(employeeDto.getEmail());
                employee.get().setDepartment(employeeDto.getDepartment());
                employee.get().setRole(employeeDto.getRoles());
                employeeService.save(employee.get());
                return new ResponseEntity<>(employeeDto, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Long id) {
        Optional<Employee> employee = employeeService.findById(id);
        if (employee.isPresent()) {
            employeeService.deleteById(id);
            return new ResponseEntity<>("Success", HttpStatus.OK);

        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
