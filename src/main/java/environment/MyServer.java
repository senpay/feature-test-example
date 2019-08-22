package environment;

import java.util.HashMap;
import java.util.Map;

import business.service.UserService;
import org.eclipse.jetty.util.MultiMap;
import org.eclipse.jetty.util.UrlEncoded;
import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.staticFiles;

/**
 * Created by Alexander Pushkarev.
 *
 * 15.2.18
 */
public class MyServer {


    public void start() {
        UserController controller = new UserController();

        staticFiles.location("/public");
        get("/index", (req, res) -> {
            Map<String, Object> model = controller.getUsersList();
            return new FreeMarkerEngine().render(new ModelAndView(model, "index.ftl"));
        });
        post("/index", (req, res) -> {
            MultiMap<String> params = new MultiMap<>();
            UrlEncoded.decodeTo(req.body(), params, "UTF-8");

            Map<String, Object> model = controller.addUser(
                            params.getString("username"),
                            params.getString("name"),
                            params.getString("password")
            );
            return new FreeMarkerEngine().render(new ModelAndView(model, "index.ftl"));
        });
    }

}
