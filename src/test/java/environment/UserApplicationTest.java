package environment;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class UserApplicationTest {

    @Test
    public void shouldBeAbleToAddNewUser() {
        UserApplication sut = new UserApplication();
        Map<String, Object> response = sut.addUser("username1", "name1", "password1");
        Assert.assertEquals("user username1 was created", response.get("status"));
        List<String> expectedUserList = (List<String>) response.get("users");
        Assert.assertTrue(expectedUserList.contains("Name: name1 login: username1 password password1"));
    }

}