package tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by eunderhi on 09/09/15.
 */
public class SelectOperator extends Operator {

    public void clickSelect(String ngModel, int value) {
        String selectXpath = String.format("//select[@ng-model='%s']", ngModel);
        WebElement element = driver.findElement(By.xpath(selectXpath));
        element.click();
        for (int i = 0; i < value; i++) {
            element.sendKeys(Keys.ARROW_DOWN);
        }
        element.sendKeys(Keys.ENTER);
    }

    public void clickFirstNonEmptySelect(String ngModel) {
        String selectXpath = String.format("//select[@ng-model='%s']", ngModel);
        WebElement element = driver.findElement(By.xpath(selectXpath));
        element.click();
        Select select = new Select(element);
        String text = select.getFirstSelectedOption().getText();

        while(text.trim().length() <= 0) {
            element.sendKeys(Keys.ARROW_DOWN);
            text = select.getFirstSelectedOption().getText();
        }
        element.sendKeys(Keys.ENTER);
    }

}
