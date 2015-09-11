package operators.products;

import operators.base.*;
import util.Elements;
import util.Strings;

/**
 * Created by eunderhi on 10/09/15.
 */
public class ProductPageOperator extends Operator {

    String productName;

    public ProductPageOperator(String productName) {
        this.productName = productName;
    }

    public void newProduct() {
        new LinkOperator().clickLink(Elements.PRODUCT_LINK);
        new ButtonOperator().clickButton(Elements.CREATE_PRODUCT_BUTTON);
        new TextInputOperator().insertInput(Elements.PRODUCT_NAME, productName);
        new AreaTextOperator().textAreaInput(Elements.PRODUCT_DESCRIPTION, Strings.PRODUCT_DESCRIPTION);
        new TextInputOperator().insertInput(Elements.PRODUCT_ABBREVIATION, productName);
        new TextInputOperator().insertInput(Elements.PRODUCT_CODE, productName);
        new TextInputOperator().insertInput(Elements.PRODUCT_SYSTEM_CODE, productName);
        new SubmitOperator().submit();
    }

}
