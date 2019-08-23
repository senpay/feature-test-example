package environment;

import environment.UserApplication;
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

    @Test
    public void shouldReturnErrorOnPasswordContainingOnlyDigits() {
        UserApplication sut = new UserApplication();
        Map<String, Object> response = sut.addUser("username1", "name1", "1");
        Assert.assertEquals("Password does not conform rules", response.get("status"));
        List<String> expectedUserList = (List<String>) response.get("users");
        Assert.assertFalse(expectedUserList.contains("Name: name1 login: username1 password 1"));
    }

    @Test
    public void shouldReturnErrorOnPasswordContainingOnlyLetters() {
        UserApplication sut = new UserApplication();
        Map<String, Object> response = sut.addUser("username1", "name1", "a");
        Assert.assertEquals("Password does not conform rules", response.get("status"));
        List<String> expectedUserList = (List<String>) response.get("users");
        Assert.assertFalse(expectedUserList.contains("Name: name1 login: username1 password a"));
    }

    @Test
    public void shouldReturnErrorOnEmptyPassword() {
        UserApplication sut = new UserApplication();
        Map<String, Object> response = sut.addUser("username1", "name1", "");
        Assert.assertEquals("Password cannot be empty", response.get("status"));
        List<String> expectedUserList = (List<String>) response.get("users");
        Assert.assertFalse(expectedUserList.contains("Name: name1 login: username1 password "));
    }

    @Test
    public void shouldReturnErrorOnEmptyName() {
        UserApplication sut = new UserApplication();
        Map<String, Object> response = sut.addUser("username1", "", "password");
        Assert.assertEquals("Full name cannot be empty", response.get("status"));
        List<String> expectedUserList = (List<String>) response.get("users");
        Assert.assertFalse(expectedUserList.contains("Name:  login: username1 password password1"));
    }

    @Test
    public void shouldReturnErrorOnEmptyUserName() {
        UserApplication sut = new UserApplication();
        Map<String, Object> response = sut.addUser("", "name1", "password");
        Assert.assertEquals("Login cannot be empty", response.get("status"));
        List<String> expectedUserList = (List<String>) response.get("users");
        Assert.assertFalse(expectedUserList.contains("Name: name1 login:  password password1"));
    }

    @Test
    public void shouldReturnNAForIndexRequest() {
        UserApplication sut = new UserApplication();
        Map<String, Object> response = sut.getUsersList();
        Assert.assertEquals("N/A", response.get("status"));
    }

}