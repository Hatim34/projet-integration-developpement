package be.iccbxl.pid.reservationsspringboot.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;
import be.iccbxl.pid.reservationsspringboot.model.Role;
import be.iccbxl.pid.reservationsspringboot.service.RoleService;

@Controller
public class RoleController {
    @Autowired
    RoleService service;

    @GetMapping("/roles")
    public String index2(Model model) {
        List<Role> roles = service.getAll();
        model.addAttribute("roles", roles);
        model.addAttribute("title", "Liste des roles");
        return "role/index";
    }

    @GetMapping("/roles/{id}")
    public String show(Model model, @PathVariable("id") long id) {
        Role role = service.get(id);
        if (role == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        model.addAttribute("role", role);
        model.addAttribute("title", "Fiche d'un role");
        return "role/show";
    }
}
