package operators.base;

import org.openqa.selenium.WebElement;

/**
 * Created by eunderhi on 09/09/15.
 */
public class ParagraphOperator extends Operator {

    public ParagraphOperator(String name) {
        super(name);
    }

    public String getParagraphText() {
        WebElement p = findParagraph();
        return p.getText();
    }

    public WebElement findParagraph() {
        String pXpath = String.format("//p[@id='%s']", name);
        return getElementByXpath(pXpath);
    }

}
