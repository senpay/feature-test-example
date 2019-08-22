import business.service.UserService;
import environment.MyServer;
import peristance.IUserRepository;
import peristance.InMemoryUserRepository;

import static spark.Spark.get;
import static spark.Spark.post;

/**
 * Created by Alexander Pushkarev.
 *
 * 15.2.18
 */
public class Main {

    public static void main(String[] args) {
        MyServer server = new MyServer();
        server.start();
    }

}
