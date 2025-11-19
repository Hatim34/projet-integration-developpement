package be.iccbxl.pid.reservationsspringboot.repository;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import be.iccbxl.pid.reservationsspringboot.model.PasswordResetToken;

public interface PasswordResetTokenRepository extends CrudRepository<PasswordResetToken, Long> {
    Optional<PasswordResetToken> findByToken(String token);
    void deleteByToken(String token);
}
