package gmail.alexspush.steps;

import gmail.alexspush.page.SelenideMainPage;
import net.thucydides.core.annotations.Step;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assume.assumeTrue;

/**
 * The idea of this composite is to create some abstraction
 * if "state-creating" steps. They more or less using other steps
 * but should fail with different exception if necessary
 * Created by Alexander Pushkarev on 9.2.18.
 */
public class UserRegistrationSteps {

    SelenideMainPage indexPage = SelenideMainPage.INSTANCE;

    @Step
    public void fillNewUserForm(String login, String userName, String password) {
        indexPage.setLogin(login);
        indexPage.setPassword(password);
        indexPage.setUserName(userName);
        indexPage.clickSubmit();
    }

    @Step
    public void successStatusPresent(String userLogin) {
        assertEquals("Status: user " + userLogin + " was created",
                indexPage.getStatus());
    }

    public void errorStatusPresent() {
        assertFalse(indexPage.getStatus().contains("was created"));
    }
}
