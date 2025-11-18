package be.iccbxl.pid.reservationsspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String login(@RequestParam(required = false) Boolean loginRequired,
                        @RequestParam(required = false) Boolean loginError,
                        @RequestParam(required = false) Boolean logoutSuccess,
                        Model model) {
        if (Boolean.TRUE.equals(loginRequired)) {
            model.addAttribute("errorMessage", "Vous devez vous connecter pour avoir accès.");
        }
        if (Boolean.TRUE.equals(loginError)) {
            model.addAttribute("errorMessage", "Échec de la connexion !");
        }
        if (Boolean.TRUE.equals(logoutSuccess)) {
            model.addAttribute("successMessage", "Vous êtes déconnecté avec succès.");
        }
        return "authentication/login";
    }
}
