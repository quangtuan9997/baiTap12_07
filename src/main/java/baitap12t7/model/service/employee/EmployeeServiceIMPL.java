package baitap12t7.model.service.employee;

import baitap12t7.model.entity.Employee;
import baitap12t7.repository.IEmployeeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceIMPL implements IEmployeeService {
    private IEmployeeRepository employeeRepository;

    public EmployeeServiceIMPL(IEmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        pageable = PageRequest.of(pageable.getPageNumber(), 5, Sort.by("name"));
        return employeeRepository.findAll(pageable);
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public boolean deleteById(Long id) {
        if (findById(id) == null) {
            return false;
        }
        employeeRepository.deleteById(id);
        return true;
    }

    @Override
    public Optional<Employee> findById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Page<Employee> findByNameContainsIgnoreCase(String name, Pageable pageable) {
        return employeeRepository.findByNameContainsIgnoreCase(name, pageable);
    }

    @Override
    public boolean existsByEmail(String email) {
        return employeeRepository.existsByEmail(email);
    }
}
