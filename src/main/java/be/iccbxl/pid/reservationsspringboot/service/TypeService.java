package be.iccbxl.pid.reservationsspringboot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import be.iccbxl.pid.reservationsspringboot.model.Type;
import be.iccbxl.pid.reservationsspringboot.repository.TypeRepository;

@Service
public class TypeService {
    @Autowired
    private TypeRepository repository;

    public List<Type> getAll() {
        List<Type> types = new ArrayList<>();
        repository.findAll().forEach(types::add);
        return types;
    }

    public Type get(long id) {
        Optional<Type> type = repository.findById(id);
        return type.orElse(null);
    }

    public void add(Type type) {
        repository.save(type);
    }

    public void update(long id, Type type) {
        repository.save(type);
    }

    public void delete(long id) {
        repository.deleteById(id);
    }
}
