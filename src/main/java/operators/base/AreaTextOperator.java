package operators.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by eunderhi on 09/09/15.
 */
public class AreaTextOperator extends Operator {

    public void textAreaInput(String elementName, String inputString) {
        String inputXpath = String.format("//textarea[@name='%s']", elementName);
        WebElement element = driver.findElement(By.xpath(inputXpath));
        element.sendKeys(inputString);
    }
}
