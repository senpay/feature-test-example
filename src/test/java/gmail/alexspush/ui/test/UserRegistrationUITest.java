package gmail.alexspush.ui.test;

import environment.MyServer;
import gmail.alexspush.ui.steps.GenericStepsImpl;
import gmail.alexspush.ui.steps.UserRegistrationSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import spark.Spark;

/**
 * Created by Alexander Pushkarev.
 * 6.2.18
 */
@RunWith(SerenityRunner.class)
public class UserRegistrationUITest {

    @Steps
    GenericStepsImpl genericSteps;
    @Steps
    UserRegistrationSteps userRegistrationSteps;

    @Before
    public void setUp() {
        MyServer server = new MyServer();
        server.start();
        genericSteps.openApplication();
    }

    @After
    public void tearDown() {
        Spark.stop();
        genericSteps.closeApplication();
    }

    @Test
    public void shouldBeAbleToAddNewUser() {
        genericSteps.given();
        final String userName = "Valid Name";
        final String login = "validLogin";
        final String password = "validPassword1";

        genericSteps.when();
        userRegistrationSteps.fillNewUserForm(login, userName, password);

        genericSteps.then();
        userRegistrationSteps.successStatusPresent(login);
    }

    @Test
    public void shouldSeeErrorForPasswordContainingOnlyLetters() {
        genericSteps.given();

        final String userName = "Valid Name";
        final String login = "validLogin";
        final String password = "InvalidPassword";

        genericSteps.when();
        userRegistrationSteps.fillNewUserForm(login, userName, password);

        genericSteps.then();
        userRegistrationSteps.errorStatusPresent();
    }

}
