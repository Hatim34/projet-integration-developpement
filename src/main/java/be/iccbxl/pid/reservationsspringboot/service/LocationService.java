package be.iccbxl.pid.reservationsspringboot.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import be.iccbxl.pid.reservationsspringboot.model.Location;
import be.iccbxl.pid.reservationsspringboot.repository.LocationRepository;

@Service
public class LocationService {
    @Autowired
    private LocationRepository repository;

    public List<Location> getAllLocations() {
        return (List<Location>) repository.findAll();
    }

    public Location getLocation(long id) {
        Optional<Location> location = repository.findById(id);
        return location.orElse(null);
    }

    public void addLocation(Location location) {
        repository.save(location);
    }

    public void updateLocation(long id, Location location) {
        repository.save(location);
    }

    public void deleteLocation(long id) {
        repository.deleteById(id);
    }
}
