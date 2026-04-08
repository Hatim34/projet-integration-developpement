package be.iccbxl.pid.reservationsspringboot.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;
import be.iccbxl.pid.reservationsspringboot.model.ArtistType;
import be.iccbxl.pid.reservationsspringboot.service.ArtistTypeService;

@Controller
public class ArtistTypeController {
    @Autowired
    ArtistTypeService service;

    @GetMapping("/artist-types")
    public String index(Model model) {
        List<ArtistType> artistTypes = service.getAll();
        model.addAttribute("artistTypes", artistTypes);
        model.addAttribute("title", "Liste des liens artiste type");
        return "artist-type/index";
    }

    @GetMapping("/artist-types/{id}")
    public String show(Model model, @PathVariable("id") long id) {
        ArtistType artistType = service.get(id);
        if (artistType == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        model.addAttribute("artistType", artistType);
        model.addAttribute("title", "Fiche lien artiste type");
        return "artist-type/show";
    }
}
