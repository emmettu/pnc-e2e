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

    private static final int LOAD_WAIT_TIME = 20;
    private static final String STARTING_URL = "http://localhost:8080/pnc-web/#!/record";
    private static final String PHANTOMJS_PATH = "/usr/bin/phantomjs";

    WebDriver driver;

    public UITester() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("takesScreenshot", true);
        caps.setCapability(
                PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
                PHANTOMJS_PATH
        );
        driver = new PhantomJSDriver(caps);
        driver.manage().timeouts().implicitlyWait(LOAD_WAIT_TIME, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(1024, 768));
        driver.get(STARTING_URL);
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
    public void insertInput(String elementName, String inputString){
        String inputXpath = String.format("//input[@name='%s']", elementName);
        WebElement element = driver.findElement(By.xpath(inputXpath));
        element.sendKeys(inputString);
    }
    public void insertTextareaInput(String elementName, String inputString){
        String inputXpath = String.format("//textarea[@name='%s']", elementName);
        WebElement element = driver.findElement(By.xpath(inputXpath));
        element.sendKeys(inputString);
    }
    public void clickInputButton(String inputButtonName){
        String inputButtonXpath = String.format("//input[@name='%s']", inputButtonName);
        WebElement element = driver.findElement(By.xpath(inputButtonXpath));
        element.click();
    }
    public void takeScreenshot() {
        File image = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        System.out.println(image.getAbsolutePath());
    }
    public void quit() {
        driver.quit();
    }
}
