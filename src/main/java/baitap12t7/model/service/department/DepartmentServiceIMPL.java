package baitap12t7.model.service.department;

import baitap12t7.model.entity.Department;
import baitap12t7.repository.IDepartmentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartmentServiceIMPL implements IDepartmentService {
    private IDepartmentRepository departmentRepository;

    public DepartmentServiceIMPL(IDepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Page<Department> findAll(Pageable pageable) {
        return departmentRepository.findAll(pageable);
    }

    @Override
    public Department save(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public boolean deleteById(Long id) {
        departmentRepository.deleteById(id);
        return true;
    }

    @Override
    public Optional<Department> findById(Long id) {
        return departmentRepository.findById(id);
    }


}
