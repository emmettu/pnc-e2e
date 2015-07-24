import org.openqa.selenium.*;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.util.List;

/**
 * Created by eunderhi on 24/07/15.
 */
public class test {
    public static void main(String[] args) {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setJavascriptEnabled(true);
        caps.setCapability("takesScreenshot", true);
        caps.setCapability(
                PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
                "/usr/bin/phantomjs"
        );
        WebDriver driver = new PhantomJSDriver(caps);
        driver.get("http://localhost:8080/pnc-web/#!/configuration");

//        WebElement element = driver.findElement(By.linkText("Products"));
//        element.click();
//
        WebElement element = driver.findElement(By.linkText("pnc-1.0.0.DR1"));
        element.click();

        File image = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        System.out.println(image.getAbsolutePath());
    }
}
