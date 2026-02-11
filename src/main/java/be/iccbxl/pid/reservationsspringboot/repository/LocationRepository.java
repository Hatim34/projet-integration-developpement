package be.iccbxl.pid.reservationsspringboot.repository;

import org.springframework.data.repository.CrudRepository;
import be.iccbxl.pid.reservationsspringboot.model.Location;

public interface LocationRepository extends CrudRepository<Location, Long> {
}
