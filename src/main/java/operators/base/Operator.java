package operators.base;

import org.openqa.selenium.WebDriver;

/**
 * Created by eunderhi on 09/09/15.
 */
public abstract class Operator {

    protected static WebDriver driver;
    protected String name;

    public Operator(String name) {
        this.name = name;
    }

    public Operator() {}

    public static WebDriver getDriver() {
        return driver;
    }

}
