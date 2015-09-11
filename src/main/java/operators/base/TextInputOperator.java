package operators.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by eunderhi on 09/09/15.
 */
public class TextInputOperator extends Operator {

    public TextInputOperator(String name) {
        super(name);
    }

    public void insertInput(String inputString){
        String inputXpath = String.format("//input[@name='%s']", name);
        WebElement element = driver.findElement(By.xpath(inputXpath));
        element.sendKeys(inputString);
    }
}
