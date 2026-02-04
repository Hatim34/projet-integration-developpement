package be.iccbxl.pid.reservationsspringboot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import be.iccbxl.pid.reservationsspringboot.model.Locality;
import be.iccbxl.pid.reservationsspringboot.repository.LocalityRepository;

@Service
public class LocalityService {
    @Autowired
    private LocalityRepository repository;

    public List<Locality> getAll() {
        List<Locality> localities = new ArrayList<>();
        repository.findAll().forEach(localities::add);
        return localities;
    }

    public Locality get(long id) {
        Optional<Locality> locality = repository.findById(id);
        return locality.orElse(null);
    }

    public void add(Locality locality) {
        repository.save(locality);
    }

    public void update(long id, Locality locality) {
        repository.save(locality);
    }

    public void delete(long id) {
        repository.deleteById(id);
    }
}
