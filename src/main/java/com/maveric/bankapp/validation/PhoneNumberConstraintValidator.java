package com.maveric.bankapp.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberConstraintValidator implements ConstraintValidator<ValidPhoneNumber, Long> {
    @Override
    public void initialize(final ValidPhoneNumber constraintAnnotation) {
        // nop
    }
    @Override
    public boolean isValid(final Long value, final ConstraintValidatorContext context) {
        Pattern pattern = Pattern.compile("(^$|[0-9]{10})");
        Matcher matcher = pattern.matcher(value.toString());
        return matcher.matches();
    }
}
