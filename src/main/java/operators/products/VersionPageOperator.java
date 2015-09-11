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
        new LinkOperator(Elements.PRODUCT_LINK).clickLink();
        new LinkOperator(productName).clickLink();
        new ButtonOperator(Elements.CREATE_VERSION_BUTTON).clickButton();
        new TextInputOperator(Elements.VERSION_INPUT).insertInput(Strings.PRODUCT_VERSION);
        new SubmitOperator().submit();
    }

}
