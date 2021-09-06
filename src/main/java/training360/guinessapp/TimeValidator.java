package training360.guinessapp;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class TimeValidator implements ConstraintValidator<TimeConstraint, LocalDate> {

    @Override
    public void initialize(TimeConstraint timeConstraint) {
    }

    @Override
    public boolean isValid(LocalDate timeField, ConstraintValidatorContext cxt) {
        return timeField.isBefore(LocalDate.now());
    }

}
