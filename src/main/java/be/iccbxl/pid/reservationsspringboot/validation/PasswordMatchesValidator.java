package be.iccbxl.pid.reservationsspringboot.validation;

import be.iccbxl.pid.reservationsspringboot.dto.UserRegistrationDto;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, UserRegistrationDto> {
    @Override
    public boolean isValid(UserRegistrationDto dto, ConstraintValidatorContext context) {
        if (dto == null) {
            return true;
        }
        String password = dto.getPassword();
        String confirm = dto.getConfirmPassword();
        if (password == null || confirm == null) {
            return false;
        }
        return password.equals(confirm);
    }
}
