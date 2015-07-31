package ui;

import org.openqa.selenium.*;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;

/**
 * Created by eunderhi on 27/07/15.
 */
public class UITester {

    private static final int LOAD_WAIT_TIME = 5;
    private static final String STARTING_URL = "http://localhost:8080/pnc-web/#!/record";
    private static final String PHANTOMJS_PATH = "/usr/bin/phantomjs";
    private static final String SCREENSHOT_DIR = "./screenshots";

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
        WebElement element = findLink(linkText);
        element.click();
    }
    public WebElement findLink(String name) {
        return driver.findElement(By.linkText(name));
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
    public void textAreaInput(String elementName, String inputString){
        String inputXpath = String.format("//textarea[@name='%s']", elementName);
        WebElement element = driver.findElement(By.xpath(inputXpath));
        element.sendKeys(inputString);
    }
    public void submit(){
        String inputButtonXpath = "//input[@type='submit']";
        WebElement element = driver.findElement(By.xpath(inputButtonXpath));
        element.click();
    }
    public void clickSelect(String ngModel, String value) {
        String selectXpath = String.format("//select[@ng-model='%s']", ngModel);
        WebElement element = driver.findElement(By.xpath(selectXpath));
        element.click();

        String subElementXpath = String.format("//option[@value='%s']", value);
        WebElement subElement = element.findElement(By.xpath(subElementXpath));
        subElement.click();
    }
    public void clickSelect(String ngModel, int value) {
        String selectXpath = String.format("//select[@ng-model='%s']", ngModel);
        WebElement element = driver.findElement(By.xpath(selectXpath));
        element.click();
        for(int i = 0; i < value; i++) {
            element.sendKeys(Keys.ARROW_DOWN);
        }
        element.sendKeys(Keys.ENTER);

    }
    public String getParagraphText(String name) {
        WebElement p = findParagraph(name);
        return p.getText();
    }
    public WebElement findParagraph(String name) {
        String pXpath = String.format("//p[@id='%s']", name);
        return driver.findElement(By.xpath(pXpath));
    }
    public WebElement findSpan(String name) {
        String spanXpath = String.format("//span[text()='%s']", name);
        return driver.findElement(By.xpath(spanXpath));
    }
    public void takeScreenshot() {
        File image = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        copyImageToScreenShotsDir(image);
    }
    private void copyImageToScreenShotsDir(File image) {
        String currentURL = driver.getCurrentUrl().replace('/', '.');
        try {
            FileUtils.copyFile(image, new File(SCREENSHOT_DIR, currentURL));
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
    public void back() {
        driver.navigate().back();
    }
    public void quit() {
        driver.quit();
    }
    public WebDriver getDriver() {
        return driver;
    }
}
