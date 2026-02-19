package be.iccbxl.pid.reservationsspringboot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import be.iccbxl.pid.reservationsspringboot.model.Representation;
import be.iccbxl.pid.reservationsspringboot.repository.RepresentationRepository;

@Service
public class RepresentationService {
    @Autowired
    private RepresentationRepository repository;

    public List<Representation> getAll() {
        List<Representation> representations = new ArrayList<>();
        repository.findAll().forEach(representations::add);
        return representations;
    }

    public Representation get(String id) {
        Long indice = (long) Integer.parseInt(id);
        Optional<Representation> representation = repository.findById(indice);
        return representation.orElse(null);
    }

    public void add(Representation representation) {
        repository.save(representation);
    }

    public void update(String id, Representation representation) {
        repository.save(representation);
    }

    public void delete(String id) {
        Long indice = (long) Integer.parseInt(id);
        repository.deleteById(indice);
    }
}
