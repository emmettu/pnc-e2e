package operators.base;

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
        WebElement element = getElementByXpath(inputXpath);
        element.sendKeys(inputString);
    }

}
