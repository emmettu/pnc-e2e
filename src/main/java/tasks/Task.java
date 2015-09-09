package tasks;

import org.openqa.selenium.WebDriver;

/**
 * Created by eunderhi on 09/09/15.
 */
public abstract class Task {
    protected static WebDriver driver;

    protected Task(WebDriver driver) {
        this.driver = driver;
    }
}
