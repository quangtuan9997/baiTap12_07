package baitap12t7.model.service.role;

import baitap12t7.model.entity.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServiceIMPL implements IRoleService{
    @Override
    public Page<Role> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Role save(Role role) {
        return null;
    }

    @Override
    public boolean deleteById(String id) {
        return false;
    }

    @Override
    public Optional<Role> findById(String id) {
        return null;
    }
}
