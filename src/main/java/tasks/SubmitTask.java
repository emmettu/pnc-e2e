package tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by eunderhi on 09/09/15.
 */
public class SubmitTask extends Task {

    public SubmitTask(WebDriver driver) {
        super(driver);
    }

    public void submit(){
        String inputButtonXpath = "//input[@type='submit']";
        WebElement element = driver.findElement(By.xpath(inputButtonXpath));
        element.click();
    }
}
