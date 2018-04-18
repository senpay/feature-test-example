package gmail.alexspush.steps;

import business.service.UserService;
import net.thucydides.core.annotations.Step;
import peristance.InMemoryUserRepository;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by Alexander Pushkarev.
 * apushkarev@workfusion.com
 * 23.3.18
 */
public class UserServiceSteps {

    private static final String CORRECT_LOGIN = "userLogin";
    private static final String CORRECT_PASSWORD = "pswd1";
    private static final String CORRECT_USERNAME = "User Name";
    private static final String INCORRECT_VALUE = "";

    private UserService sut;

    @Step
    public void init() {
        sut = new UserService();
        sut.setUserRepository(new InMemoryUserRepository());
    }

    @Step
    public String createUserWithNotValidName() {
        return sut.addUser(CORRECT_LOGIN, INCORRECT_VALUE, CORRECT_PASSWORD);
    }

    @Step
    public String createUserWithNotValidLogin() {
        return sut.addUser(INCORRECT_VALUE, CORRECT_USERNAME, CORRECT_PASSWORD);
    }

    @Step
    public String createUserWithNotValidPassword() {
        return sut.addUser(CORRECT_LOGIN, CORRECT_USERNAME, INCORRECT_VALUE);
    }

    @Step
    public void statusDoesNotContain(final String status, final String expectedStatus) {
        assertNotNull(status);
        assertFalse(status.contains(expectedStatus));
    }
}
