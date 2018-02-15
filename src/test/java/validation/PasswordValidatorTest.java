package validation;

import java.util.Optional;

import business.validation.PasswordValidator;
import business.validation.ValidationError;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by senpay on 15.2.18.
 */
public class PasswordValidatorTest {

    private static final String ONLY_DIGITS_PASSWORD = "111";

    //Password without digits was verified on UI
    //verifying password that contains only digits
    @Test
    public void shouldReturnErrorInCaseOfPasswordWithOnlyDigit() {
        PasswordValidator validator = new PasswordValidator();
        Optional<ValidationError> error = validator.validate(ONLY_DIGITS_PASSWORD);
        assertNotEquals(ValidationError.getEmptyValidationError(), error.get());
    }

}
