package greatlirik.training.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class BirthDateValidator implements ConstraintValidator<BirthDate, LocalDate> {

    @Override
    public boolean isValid(final LocalDate checkLocalDate, final ConstraintValidatorContext constraintValidatorContext) {
        return LocalDate.now().getYear() - checkLocalDate.getYear() >= 18;
    }
}
