package ui;

import org.openqa.selenium.*;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Created by eunderhi on 27/07/15.
 */
public class UITester {

    WebDriver driver;

    public UITester() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setJavascriptEnabled(true);
        caps.setCapability("takesScreenshot", true);
        caps.setCapability(
                PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
                "/usr/bin/phantomjs"
        );
        driver = new PhantomJSDriver(caps);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://localhost:8080/pnc-web/#!/configuration");
    }
    public void clickLink(String linkText) {
        WebElement element = driver.findElement(By.linkText(linkText));
        element.click();
    }
    public void clickButton(String buttonName) {
        String buttonXpath = String.format("//button[@title='%s']", buttonName);
        WebElement element = driver.findElement(By.xpath(buttonXpath));
        element.click();
    }
    public void takeScreenshot() {
        File image = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        System.out.println(image.getAbsolutePath());
    }
}
