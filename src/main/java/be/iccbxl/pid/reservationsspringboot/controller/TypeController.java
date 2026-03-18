package be.iccbxl.pid.reservationsspringboot.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;
import be.iccbxl.pid.reservationsspringboot.model.Type;
import be.iccbxl.pid.reservationsspringboot.service.TypeService;

@Controller
public class TypeController {
    @Autowired
    TypeService service;

    @GetMapping("/types")
    public String index2(Model model) {
        List<Type> types = service.getAll();
        model.addAttribute("types", types);
        model.addAttribute("title", "Liste des types");
        return "type/index";
    }

    @GetMapping("/types/{id}")
    public String show(Model model, @PathVariable("id") long id) {
        Type type = service.get(id);
        if (type == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        model.addAttribute("type", type);
        model.addAttribute("title", "Fiche d'un type");
        return "type/show";
    }
}
