package util;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.support.ui.Select;
import tasks.SetUpTask;

/**
 * Created by eunderhi on 27/07/15.
 */
public class UITester {

    private static final String SCREENSHOT_DIR = "./screenshots";

    WebDriver driver;

    public UITester() {
        new SetUpTask(driver).setUp();
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

    public void clickFirstNonEmptySelect(String ngModel) {
        String selectXpath = String.format("//select[@ng-model='%s']", ngModel);
        WebElement element = driver.findElement(By.xpath(selectXpath));
        element.click();
        Select select = new Select(element);
        String text = select.getFirstSelectedOption().getText();

        while(text.trim().length() <= 0) {
            element.sendKeys(Keys.ARROW_DOWN);
            text = select.getFirstSelectedOption().getText();
        }

        element.sendKeys(Keys.ENTER);

    }

    public void clickCheckBox() {
        String checkBoxXpath = "//input[@type='checkbox']";
        WebElement element = driver.findElement(By.xpath(checkBoxXpath));
        element.click();
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
        String currentURL = driver.getCurrentUrl().replace('/', '!') + ".png";
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
