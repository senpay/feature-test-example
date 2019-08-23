package environment;

import business.service.UserService;
import peristance.IUserRepository;
import peristance.InMemoryUserRepository;

import java.util.HashMap;
import java.util.Map;

public class UserApplication {


    private static IUserRepository repository = new InMemoryUserRepository();
    private static UserService service = new UserService(); {
        service.setUserRepository(repository);
    }


    public Map<String, Object> getUsersList() {
        return getUsersList("N/A");
    }

    public Map<String, Object> addUser(final String username, final String name, final String password) {
        final String status = service.addUser(username, name, password);
        final Map<String, Object> model = getUsersList(status);
        return model;
    }

    private Map<String, Object> getUsersList(String status) {
        final Map<String, Object> model = new HashMap<>();
        model.put("status", status);
        model.put("users", service.getUserInfoList());
        return model;
    }
}
