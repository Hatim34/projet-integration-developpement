package be.iccbxl.pid.reservationsspringboot.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmailService.class);
    private final JavaMailSender mailSender;
    @Value("${app.mail.from:no-reply@reservations.com}")
    private String from;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendPasswordResetMail(String to, String token) {
        String resetUrl = "http://localhost:8080/reset-password?token=" + token;
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setFrom(from);
        message.setSubject("Réinitialisation du mot de passe");
        message.setText("Clique sur le lien suivant pour réinitialiser ton mot de passe : " + resetUrl);
        try {
            mailSender.send(message);
        } catch (Exception ex) {
            LOGGER.warn("Impossible d'envoyer l'email de réinitialisation: {}", ex.getMessage());
        }
        LOGGER.info("Lien de réinitialisation généré pour {}: {}", to, resetUrl);
    }
}
