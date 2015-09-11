package operators.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by eunderhi on 09/09/15.
 */
public class ButtonOperator extends Operator {

    public ButtonOperator(String name) {
        super(name);
    }

    public void clickButton() {
        String buttonXpath = String.format("//button[@title='%s']", name);
        WebElement element = driver.findElement(By.xpath(buttonXpath));
        element.click();
    }
}
