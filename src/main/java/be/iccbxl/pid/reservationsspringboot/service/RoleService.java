package be.iccbxl.pid.reservationsspringboot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import be.iccbxl.pid.reservationsspringboot.model.Role;
import be.iccbxl.pid.reservationsspringboot.repository.RoleRepository;

@Service
public class RoleService {
    @Autowired
    private RoleRepository repository;

    public List<Role> getAll() {
        List<Role> roles = new ArrayList<>();
        repository.findAll().forEach(roles::add);
        return roles;
    }

    public Role get(long id) {
        Optional<Role> role = repository.findById(id);
        return role.orElse(null);
    }

    public void add(Role role) {
        repository.save(role);
    }

    public void update(long id, Role role) {
        repository.save(role);
    }

    public void delete(long id) {
        repository.deleteById(id);
    }
}
