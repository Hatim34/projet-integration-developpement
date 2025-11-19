package be.iccbxl.pid.reservationsspringboot.service;

import be.iccbxl.pid.reservationsspringboot.repository.PasswordResetTokenRepository;
import java.time.LocalDateTime;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class TokenCleanup {
    private final PasswordResetTokenRepository tokenRepository;

    public TokenCleanup(PasswordResetTokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }

    @Scheduled(cron = "0 0 * * * *")
    @Transactional
    public void removeExpiredTokens() {
        tokenRepository.findAll().forEach(token -> {
            if (token.getExpiryDate().isBefore(LocalDateTime.now())) {
                tokenRepository.delete(token);
            }
        });
    }
}
