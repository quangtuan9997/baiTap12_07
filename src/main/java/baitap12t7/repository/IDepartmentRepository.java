package baitap12t7.repository;

import baitap12t7.model.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface IDepartmentRepository extends JpaRepository<Department,Long> {
     Department findDepartmentsByName(String name);
}
