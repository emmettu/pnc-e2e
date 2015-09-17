package operators.base;

import org.openqa.selenium.WebElement;

/**
 * Created by eunderhi on 09/09/15.
 */
public class AreaTextOperator extends Operator {

    public AreaTextOperator(String name) {
        super(name);
    }

    public void textAreaInput(String inputString) {
        String inputXpath = String.format("//textarea[@name='%s']", name);
        WebElement element = getElementByXpath(inputXpath);
        element.sendKeys(inputString);
    }
}
