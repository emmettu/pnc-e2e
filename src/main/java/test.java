import org.openqa.selenium.*;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import ui.UITester;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Created by eunderhi on 24/07/15.
 */
public class test {
    public static void main(String[] args) {
        UITester tester = new UITester();
        tester.clickLink("pnc-1.0.0.DR1");
        tester.clickButton("Start Build");
        tester.takeScreenshot();
    }
}
