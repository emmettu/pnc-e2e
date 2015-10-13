package operators.base;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by eunderhi on 13/10/15.
 */
public class ConfirmOperator extends Operator {
    public void confirm() {
        Actions builder = new Actions(driver);
        builder.sendKeys(Keys.TAB, Keys.TAB, Keys.ENTER).perform();
    }
}
