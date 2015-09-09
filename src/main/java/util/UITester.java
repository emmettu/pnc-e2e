package util;

import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import tasks.*;

/**
 * Created by eunderhi on 27/07/15.
 */
public class UITester {

    private static final String SCREENSHOT_DIR = "./screenshots";

    WebDriver driver;

    public UITester() {
        new SetUpOperator().setUp();
    }

    public void clickLink(String linkText) {
        new LinkOperator().clickLink(linkText);
    }

    public void clickButton(String buttonName) {
        new ButtonOperator().clickButton(buttonName);
    }

    public void textInput(String name, String input) {
        new TextInputOperator().insertInput(name, input);
    }

    public void textAreaInput(String elementName, String inputString) {
        new AreaTextOperator().textAreaInput(elementName, inputString);
    }

    public void submit(){
        new SubmitOperator().submit();
    }

    public void clickSelect(String ngModel, int value) {
        new SelectOperator().clickSelect(ngModel, value);
    }

    public void clickFirstNonEmptySelect(String ngModel) {
        new SelectOperator().clickFirstNonEmptySelect(ngModel);
    }

    public void clickCheckBox() {
        new CheckBoxOperator().clickCheckBox();
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
