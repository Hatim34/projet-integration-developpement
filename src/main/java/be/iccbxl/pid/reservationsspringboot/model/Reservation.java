package be.iccbxl.pid.reservationsspringboot.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomClient;
    private String email;
    private int nombrePersonnes;
    private LocalDate dateReservation;

    public Reservation() {}

    public Reservation(String nomClient, String email, int nombrePersonnes, LocalDate dateReservation) {
        this.nomClient = nomClient;
        this.email = email;
        this.nombrePersonnes = nombrePersonnes;
        this.dateReservation = dateReservation;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNomClient() { return nomClient; }
    public void setNomClient(String nomClient) { this.nomClient = nomClient; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public int getNombrePersonnes() { return nombrePersonnes; }
    public void setNombrePersonnes(int nombrePersonnes) { this.nombrePersonnes = nombrePersonnes; }
    public LocalDate getDateReservation() { return dateReservation; }
    public void setDateReservation(LocalDate dateReservation) { this.dateReservation = dateReservation; }
}
