package baitap12t7.model.service.employee;

import baitap12t7.model.entity.Employee;
import baitap12t7.model.service.IGenericService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public interface IEmployeeService extends IGenericService<Employee,Long> {

    Page<Employee> findByNameContainsIgnoreCase(String name, Pageable pageable);
    boolean existsByEmail(String email);
}
