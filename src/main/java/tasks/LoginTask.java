package tasks;

import org.openqa.selenium.WebDriver;

/**
 * Created by eunderhi on 09/09/15.
 */
public class LoginTask extends Task {

    public LoginTask(WebDriver driver) {
        super(driver);
    }

    public void login(String loginURL, String username, String password) {
        driver.get(loginURL);
        new TextInputTask(driver).insertInput("username", username);
        new TextInputTask(driver).insertInput("password", password);
        new SubmitTask(driver).submit();
    }
}
