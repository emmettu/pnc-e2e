package operators.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by eunderhi on 09/09/15.
 */
public class ParagraphOperator extends Operator {

    public String getParagraphText(String name) {
        WebElement p = findParagraph(name);
        return p.getText();
    }

    public WebElement findParagraph(String name) {
        String pXpath = String.format("//p[@id='%s']", name);
        return driver.findElement(By.xpath(pXpath));
    }

}
