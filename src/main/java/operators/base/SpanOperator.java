package operators.base;

import org.openqa.selenium.WebElement;

/**
 * Created by eunderhi on 09/09/15.
 */
public class SpanOperator extends Operator {

    public SpanOperator(String name) {
        super(name);
    }

    public WebElement findSpan() {
        String spanXpath = String.format("//span[text()='%s']", name);
        return getElementByXpath(spanXpath);
    }

}
