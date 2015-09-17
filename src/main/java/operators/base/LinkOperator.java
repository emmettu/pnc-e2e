package operators.base;

import org.openqa.selenium.WebElement;

/**
 * Created by eunderhi on 09/09/15.
 */
public class LinkOperator extends Operator {

    public LinkOperator(String name) {
        super(name);
    }

    public void clickLink() {
        WebElement element = findLink();
        element.click();
    }

    public WebElement findLink() {
        return getElementByLinkText(name);
    }
}
