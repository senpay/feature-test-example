package gmail.alexspush.ui.test;

import gmail.alexspush.ui.steps.GenericStepsImpl;
import gmail.alexspush.ui.steps.UserRegistrationSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by Alexander Pushkarev.
 * 6.2.18
 */
@RunWith(SerenityRunner.class)
public class UserRegistrationTestUI {


    //In order for Serenity to do injection for me I will have to use
    //Concrete classes here
    //So Interfaces not really needed if we use Serenity
    //DI mechanism
    @Steps
    GenericStepsImpl genericSteps;
    @Steps
    UserRegistrationSteps userRegistrationSteps;

    @Before
    public void setUp() {
        //Here I am not specifying which url to open - staging/production/local.
        //In general case, test should know nothing about it
        //There're some prominent exceptions, but they are out of scope of this example
        genericSteps.openApplication();
    }

    @After
    public void tearDown() {
        //Here I am not specifying which url to open - staging/production/local.
        //In general case, test should know nothing about it
        //There're some prominent exceptions, but they are out of scope of this example
        genericSteps.closeApplication();
    }

    /**
     * At this stage it is going to be simple scenario.
     * Let's assume thing we have on a business layer (which not yet exist at the moment) is called steps.
     *
     */
    @Test
    public void shouldBeAbleToAddNewUser() {
        //Even with java-based test automation it never hurts to specify
        //What is given (i.e. things that put system into particular state)
        //What is an action under test
        //And where we do verify the outcome

        genericSteps.given();
        //Not much here - setUp() is almost enough
        //it would be nice to extract this name generation to some
        //getItemName() method, but that is boring thing to do, so I won't do it
        final String userName = "Valid Name";
        final String login = "validLogin";
        final String password = "validPassword1";

        genericSteps.when();
        userRegistrationSteps.fillNewUserForm(login, userName, password);

        genericSteps.then();
        //Here we're making assumption that there were no such item before.
        //It can be easily addressed if we generate new name for each test
        //I will not add this implementation here as this is pretty straight-forward thing to do
        userRegistrationSteps.successStatusPresent(login);
    }

    /**
     * At this stage it is going to be simple scenario.
     * Let's assume thing we have on a business layer (which not yet exist at the moment) is called steps.
     *
     */
    @Test
    public void shouldSeeErrorForIncorrectData() {
        //Even with java-based test automation it never hurts to specify
        //What is given (i.e. things that put system into particular state)
        //What is an action under test
        //And where we do verify the outcome

        genericSteps.given();
        //Not much here - setUp() is almost enough
        //it would be nice to extract this name generation to some
        //getItemName() method, but that is boring thing to do, so I won't do it
        final String userName = "Valid Name";
        final String login = "validLogin";
        final String password = "InvalidPassword";

        genericSteps.when();
        userRegistrationSteps.fillNewUserForm(login, userName, password);

        genericSteps.then();
        //Here we're making assumption that there were no such item before.
        //It can be easily addressed if we generate new name for each test
        //I will not add this implementation here as this is pretty straight-forward thing to do
        userRegistrationSteps.errorStatusPresent();
    }

}
