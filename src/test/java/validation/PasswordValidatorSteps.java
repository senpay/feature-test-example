package validation;

import java.util.Optional;

import business.validation.PasswordValidator;
import business.validation.ValidationError;
import net.thucydides.core.annotations.Step;
import org.junit.Test;

import static org.junit.Assert.assertNotEquals;

/**
 * Created by Alexander Pushkarev.
 * apushkarev@workfusion.com
 * 23.3.18
 */
public class PasswordValidatorSteps {

    private static final String ONLY_DIGITS_PASSWORD = "111";

    @Step
    public Optional<ValidationError> passwordContaningOnlyDigitsGiven() {
        PasswordValidator validator = new PasswordValidator();
        return validator.validate(ONLY_DIGITS_PASSWORD);
    }

    @Step
    public void validationErrorIsReturned(final Optional<ValidationError> error) {
        assertNotEquals(ValidationError.getEmptyValidationError(), error.get());
    }


}
