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
        final Map<String, Object> model = new HashMap<>();
        model.put("status", "N/A");
        model.put("users", service.getUserInfoList());
        return model;
    }

    public Map<String, Object> addUser(final String username, final String name, final String password) {
        final Map<String, Object> model = new HashMap<>();
        final String status = service.addUser(username, name, password);
        model.put("status", status);
        model.put("users", service.getUserInfoList());
        return model;
    }
}
