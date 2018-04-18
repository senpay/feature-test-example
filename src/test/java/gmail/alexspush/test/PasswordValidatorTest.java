package gmail.alexspush.test;

import java.util.Optional;

import business.validation.ValidationError;
import gmail.alexspush.steps.PasswordValidatorSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by senpay on 15.2.18.
 */
@RunWith(SerenityRunner.class)
public class PasswordValidatorTest {

    @Steps
    private PasswordValidatorSteps passwordValidatorSteps;

    //Password without digits was verified on UI
    //verifying password that contains only digits
    @Test
    public void shouldReturnErrorInCaseOfPasswordWithOnlyDigit() {
        Optional<ValidationError> validationError = passwordValidatorSteps.passwordContaningOnlyDigitsGiven();
        passwordValidatorSteps.validationErrorIsReturned(validationError);
    }

}
