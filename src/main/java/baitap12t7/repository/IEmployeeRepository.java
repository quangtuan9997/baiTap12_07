package baitap12t7.repository;

import baitap12t7.model.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface IEmployeeRepository extends JpaRepository<Employee,Long> {
    Page<Employee> findAll(Pageable pageable);
    Optional<Employee> findById(Long id);
    Page<Employee> findByNameContainsIgnoreCase(String name,Pageable pageable);
    boolean existsByEmail(String email);
}
