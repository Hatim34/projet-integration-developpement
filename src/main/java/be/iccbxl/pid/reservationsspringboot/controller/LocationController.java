package be.iccbxl.pid.reservationsspringboot.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import be.iccbxl.pid.reservationsspringboot.model.Location;
import be.iccbxl.pid.reservationsspringboot.service.LocationService;

@Controller
public class LocationController {
    @Autowired
    LocationService service;

    @GetMapping("/locations")
    public String index(Model model) {
        List<Location> locations = service.getAllLocations();
        model.addAttribute("locations", locations);
        model.addAttribute("title", "Liste des lieux");
        return "location/index";
    }

    @GetMapping("/locations/{id}")
    public String show(Model model, @PathVariable("id") String id) {
        Location location = service.getLocation(Long.parseLong(id));
        model.addAttribute("location", location);
        model.addAttribute("title", "Fiche d'un lieu");
        return "location/show";
    }
}
