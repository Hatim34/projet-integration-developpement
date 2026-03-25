package be.iccbxl.pid.reservationsspringboot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import be.iccbxl.pid.reservationsspringboot.model.ArtistType;
import be.iccbxl.pid.reservationsspringboot.repository.ArtistTypeRepository;

@Service
public class ArtistTypeService {
    @Autowired
    private ArtistTypeRepository repository;

    public List<ArtistType> getAll() {
        List<ArtistType> artistTypes = new ArrayList<>();
        repository.findAll().forEach(artistTypes::add);
        return artistTypes;
    }

    public ArtistType get(long id) {
        Optional<ArtistType> artistType = repository.findById(id);
        return artistType.orElse(null);
    }

    public void add(ArtistType artistType) {
        repository.save(artistType);
    }

    public void update(long id, ArtistType artistType) {
        repository.save(artistType);
    }

    public void delete(long id) {
        repository.deleteById(id);
    }
}
