package operators.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by eunderhi on 06/10/15.
 */
public class BuildOperator extends Operator {
    public void startBuild() {
        WebElement startButton = driver.findElement(By.xpath("//button[contains(@ng-click, 'build()')]"));
        startButton.click();
    }
}
