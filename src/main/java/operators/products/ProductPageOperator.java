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
        new TextInputOperator().insertInput(Elements.PRODUCT_ABBREVIATION, Strings.PRODUCT_ABBREVIATION);
        new TextInputOperator().insertInput(Elements.PRODUCT_CODE, Strings.PRODUCT_CODE);
        new TextInputOperator().insertInput(Elements.PRODUCT_SYSTEM_CODE, Strings.PRODUCT_SYSTEM_NAME);
        new SubmitOperator().submit();
    }

}
