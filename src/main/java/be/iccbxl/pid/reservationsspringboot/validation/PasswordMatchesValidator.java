package be.iccbxl.pid.reservationsspringboot.validation;

import be.iccbxl.pid.reservationsspringboot.dto.UserProfileDto;
import be.iccbxl.pid.reservationsspringboot.dto.UserRegistrationDto;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {
    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        String password = null;
        String confirm = null;
        if (value instanceof UserRegistrationDto dto) {
            password = dto.getPassword();
            confirm = dto.getConfirmPassword();
        } else if (value instanceof UserProfileDto dto) {
            password = dto.getPassword();
            confirm = dto.getConfirmPassword();
        } else {
            return true;
        }
        if (password == null || confirm == null) {
            return false;
        }
        return password.equals(confirm);
    }
}
