package be.iccbxl.pid.reservationsspringboot.controller;

import be.iccbxl.pid.reservationsspringboot.model.Reservation;
import be.iccbxl.pid.reservationsspringboot.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
public class ReservationController {

    @Autowired
    private ReservationRepository reservationRepository;

    @GetMapping("/reservations")
    public String afficherReservations(Model model) {
        model.addAttribute("reservations", reservationRepository.findAll());
        return "reservations";
    }

    @PostMapping("/reservations")
    public String ajouterReservation(@RequestParam String nomClient,
                                     @RequestParam String email,
                                     @RequestParam int nombrePersonnes,
                                     @RequestParam String dateReservation) {
        Reservation r = new Reservation(nomClient, email, nombrePersonnes, LocalDate.parse(dateReservation));
        reservationRepository.save(r);
        return "redirect:/reservations";
    }

    @GetMapping("/reservations/supprimer/{id}")
    public String supprimerReservation(@PathVariable Long id) {
        reservationRepository.deleteById(id);
        return "redirect:/reservations";
    }

    @GetMapping("/reservations/modifier/{id}")
    public String afficherFormulaireModification(@PathVariable Long id, Model model) {
        Reservation reservation = reservationRepository.findById(id).orElse(null);
        model.addAttribute("reservation", reservation);
        return "modifier-reservation";
    }

    @PostMapping("/reservations/modifier/{id}")
    public String modifierReservation(@PathVariable Long id,
                                      @RequestParam String nomClient,
                                      @RequestParam String email,
                                      @RequestParam int nombrePersonnes,
                                      @RequestParam String dateReservation) {
        Reservation r = reservationRepository.findById(id).orElse(null);
        if (r != null) {
            r.setNomClient(nomClient);
            r.setEmail(email);
            r.setNombrePersonnes(nombrePersonnes);
            r.setDateReservation(LocalDate.parse(dateReservation));
            reservationRepository.save(r);
        }
        return "redirect:/reservations";
    }
}
