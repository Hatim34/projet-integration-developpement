package be.iccbxl.pid.reservationsspringboot.controller;

import be.iccbxl.pid.reservationsspringboot.dto.UserProfileDto;
import be.iccbxl.pid.reservationsspringboot.model.Language;
import be.iccbxl.pid.reservationsspringboot.model.User;
import be.iccbxl.pid.reservationsspringboot.repository.UserRepository;
import be.iccbxl.pid.reservationsspringboot.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import java.util.Arrays;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProfileController {
    private final UserRepository userRepository;
    private final UserService userService;

    public ProfileController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @GetMapping("/profile")
    public String showProfile(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String login = auth.getName();
        User user = userRepository.findByLogin(login);
        if (user == null) {
            throw new RuntimeException("Utilisateur introuvable");
        }
        UserProfileDto dto = new UserProfileDto();
        dto.setId(user.getId());
        dto.setFirstname(user.getFirstname());
        dto.setLastname(user.getLastname());
        dto.setEmail(user.getEmail());
        dto.setLangue(user.getLangue());
        dto.setLogin(user.getLogin());
        dto.setRole(user.getRole().getValue());
        Language userLanguage = Arrays.stream(Language.values())
            .filter(lang -> lang.toString().equalsIgnoreCase(user.getLangue()))
            .findFirst()
            .orElse(null);
        model.addAttribute("user_language", userLanguage != null ? userLanguage.getDescription() : "Inconnue");
        model.addAttribute("user", dto);
        model.addAttribute("module", "profile");
        return "authentication/profile";
    }

    @PostMapping(value = "/profile", params = {"edit"})
    public String updateProfile(@Valid @ModelAttribute("user") UserProfileDto dto,
                                 BindingResult result,
                                 Model model,
                                 RedirectAttributes redirAttrs) {
        if (result.hasErrors()) {
            model.addAttribute("errorMessage", "Erreurs de validation !");
            model.addAttribute("module", "profile");
            return "authentication/profile";
        }
        userService.updateUserFromDto(dto);
        redirAttrs.addFlashAttribute("successMessage", "Profil mis à jour avec succès !");
        return "redirect:/profile";
    }

    @DeleteMapping("/profile/delete")
    public String deleteAccount(HttpServletRequest request,
                                HttpServletResponse response,
                                RedirectAttributes redirAttrs) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (request.isUserInRole("ADMIN")) {
            redirAttrs.addFlashAttribute("errorMessage", "Pas de suppression de son propre compte admin !");
            return "redirect:/profile";
        }
        if (auth != null) {
            userService.deleteByLogin(auth.getName());
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        SecurityContextHolder.clearContext();
        redirAttrs.addFlashAttribute("successMessage", "Votre compte a été supprimé avec succès.");
        return "redirect:/";
    }
}
