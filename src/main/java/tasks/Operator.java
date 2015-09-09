package tasks;

import org.openqa.selenium.WebDriver;

/**
 * Created by eunderhi on 09/09/15.
 */
public abstract class Operator {
    protected static WebDriver driver;

    public static void setWebDriver(WebDriver newDriver) {
        driver  = newDriver;
    }
}
