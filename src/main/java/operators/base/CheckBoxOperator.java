package operators.base;

import org.openqa.selenium.WebElement;

/**
 * Created by eunderhi on 09/09/15.
 */
public class CheckBoxOperator extends  Operator {

    public void clickCheckBox() {
        String checkBoxXpath = "//input[@type='checkbox']";
        WebElement element = getElementByXpath(checkBoxXpath);
        element.click();
    }
}
