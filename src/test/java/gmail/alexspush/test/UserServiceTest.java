package gmail.alexspush.test;

import gmail.alexspush.steps.UserServiceSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by senpay on 15.2.18.
 */
@RunWith(SerenityRunner.class)
public class UserServiceTest {

    @Steps
    private UserServiceSteps userServiceSteps;

    @Before
    public void setUp() {
        userServiceSteps.init();
    }

    @Test
    public void shouldReturnErrorForIncorrectLogin() {
        String status = userServiceSteps.createUserWithNotValidLogin();
        userServiceSteps.statusDoesNotContain(status, "was created");
    }


    @Test
    public void shouldReturnErrorForIncorrectUserName() {
        String status = userServiceSteps.createUserWithNotValidName();
        userServiceSteps.statusDoesNotContain(status, "was created");
    }

    @Test
    public void shouldReturnErrorForIncorrectPassword() {
        String status = userServiceSteps.createUserWithNotValidPassword();
        userServiceSteps.statusDoesNotContain(status, "was created");
    }

}
