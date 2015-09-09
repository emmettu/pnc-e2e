package operators.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by eunderhi on 09/09/15.
 */
public class LinkOperator extends Operator {

    public void clickLink(String linkText) {
        WebElement element = findLink(linkText);
        element.click();
    }

    public WebElement findLink(String name) {
        return driver.findElement(By.linkText(name));
    }
}
