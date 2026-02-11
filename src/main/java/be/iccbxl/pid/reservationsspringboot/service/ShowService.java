package be.iccbxl.pid.reservationsspringboot.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import be.iccbxl.pid.reservationsspringboot.model.Show;
import be.iccbxl.pid.reservationsspringboot.repository.ShowRepository;

@Service
public class ShowService {
    @Autowired
    private ShowRepository repository;

    public List<Show> getAllShows() {
        return (List<Show>) repository.findAll();
    }

    public Show getShow(long id) {
        Optional<Show> show = repository.findById(id);
        return show.orElse(null);
    }

    public void addShow(Show show) {
        repository.save(show);
    }

    public void updateShow(long id, Show show) {
        repository.save(show);
    }

    public void deleteShow(long id) {
        repository.deleteById(id);
    }
}
