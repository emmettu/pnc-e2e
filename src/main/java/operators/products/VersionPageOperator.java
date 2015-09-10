package operators.products;

import operators.base.*;
import util.Elements;
import util.Strings;

/**
 * Created by eunderhi on 10/09/15.
 */
public class VersionPageOperator extends Operator {

    String productName;

    public VersionPageOperator(String productName) {
        this.productName = productName;
    }

    public void newVersion() {
        new LinkOperator().clickLink(Elements.PRODUCT_LINK);
        new LinkOperator().clickLink(productName);
        new ButtonOperator().clickButton(Elements.CREATE_VERSION_BUTTON);
        new TextInputOperator().insertInput(Elements.VERSION_INPUT, Strings.PRODUCT_VERSION);
        new SubmitOperator().submit();
    }

}
