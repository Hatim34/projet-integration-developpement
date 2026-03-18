package be.iccbxl.pid.reservationsspringboot.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;
import be.iccbxl.pid.reservationsspringboot.model.Locality;
import be.iccbxl.pid.reservationsspringboot.service.LocalityService;

@Controller
public class LocalityController {
    @Autowired
    LocalityService service;

    @GetMapping("/localities")
    public String index2(Model model) {
        List<Locality> localities = service.getAll();
        model.addAttribute("localities", localities);
        model.addAttribute("title", "Liste des localites");
        return "locality/index";
    }

    @GetMapping("/localities/{id}")
    public String show(Model model, @PathVariable("id") long id) {
        Locality locality = service.get(id);
        if (locality == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        model.addAttribute("locality", locality);
        model.addAttribute("title", "Fiche d'une localite");
        return "locality/show";
    }
}
