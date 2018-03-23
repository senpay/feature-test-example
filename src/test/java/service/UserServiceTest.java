package service;

import business.service.UserService;
import org.junit.Before;
import org.junit.Test;
import peristance.InMemoryUserRepository;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by senpay on 15.2.18.
 */
public class UserServiceTest {

    private static final String CORRECT_USERNAME = "User Name";
    private static final String CORRECT_LOGIN = "userLogin";
    private static final String CORRECT_PASSWORD = "pswd1";

    private UserService sut;

    @Before
    public void setUp() {
        sut = new UserService();
        sut.setUserRepository(new InMemoryUserRepository());
    }

    @Test
    public void shouldBeAbleToAddNewUser() {
        String error = sut.addUser("validname", CORRECT_USERNAME, CORRECT_PASSWORD);
        assertTrue(error.contains("was created"));
    }

    @Test
    public void shouldReturnErrorForIncorrectLogin() {
        String error = sut.addUser("", CORRECT_USERNAME, CORRECT_PASSWORD);
        assertFalse(error.contains("was created"));
    }


    @Test
    public void shouldReturnErrorForIncorrectUserName() {
        String error = sut.addUser(CORRECT_LOGIN, "", CORRECT_PASSWORD);
        assertFalse(error.contains("was created"));
    }

    @Test
    public void shouldReturnErrorForIncorrectPassword() {
        String error = sut.addUser(CORRECT_LOGIN, CORRECT_USERNAME, "");
        assertFalse(error.contains("was created"));
    }

}
