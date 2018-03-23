package gmail.alexspush.ui.driver;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import gmail.alexspush.ui.steps.IApplicationDriver;

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;

/**
 * Created by Alexander Pushkarev on 9.2.18.
 */
public class SelenideApplicationDriver implements IApplicationDriver {

    //This url would be better to put into properties file
    private static final String APPLICATION_URL = "http://localhost:4567/index";

    @Override
    public void openApplication() {
        //This configuration may as well be outside of the method, but does not matter now
        Configuration.browser = WebDriverRunner.HTMLUNIT;

        open(APPLICATION_URL);
    }

    @Override
    public void closeApplication() {
        close();
    }
}
