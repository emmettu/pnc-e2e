package operators.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by eunderhi on 09/09/15.
 */
public class SubmitOperator extends Operator {

    public void submit(){
        String inputButtonXpath = "//input[@type='submit']";
        WebElement element = driver.findElement(By.xpath(inputButtonXpath));
        element.click();
    }
}
