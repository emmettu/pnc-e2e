package operators;

import operators.base.Operator;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import util.Credentials;

import java.util.concurrent.TimeUnit;

/**
 * Created by eunderhi on 09/09/15.
 */
public class SetUpOperator extends Operator {

    private Credentials creds = new Credentials();
    private static final int LOAD_WAIT_TIME = 20;
    private String phantomjsPath = creds.getPhantomjsPath();

    public void setUp() {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("takesScreenshot", true);
        caps.setCapability(
                PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
                phantomjsPath
        );
        String[] phantomArgs = new  String[] {
                "--webdriver-loglevel=NONE",
                "--ssl-protocol=any"
        };
        caps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, phantomArgs);
        //driver = new PhantomJSDriver(caps);
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(LOAD_WAIT_TIME, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(1024, 768));
        loginOrGoToBaseURL();
    }

    private void loginOrGoToBaseURL() {
        if(creds.hasLoginURL()) {
            String loginURL = creds.getLoginURL();
            String username = creds.getUsername();
            String password = creds.getPassword();
            new LoginOperator().login(loginURL, username, password);
        }
        else {
            String baseURL = creds.getBaseURL();
            driver.get(baseURL);
        }
    }
}
