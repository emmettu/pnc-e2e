package operators.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by eunderhi on 09/09/15.
 */
public class SpanOperator extends Operator {

    public WebElement findSpan(String name) {
        String spanXpath = String.format("//span[text()='%s']", name);
        return driver.findElement(By.xpath(spanXpath));
    }

}
