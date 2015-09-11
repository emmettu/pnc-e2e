package ui;

import operators.products.ProductPageOperator;
import operators.products.VersionPageOperator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import util.Elements;
import util.RandomName;
import util.Strings;

/**
 * Created by mvaghela on 27/07/15.
 */
public class ProductsTest extends UITest {

    String productName;
    ProductPageOperator operator;

    @Before
    public void createProduct() {
        productName = RandomName.getRandomName();
        operator = new ProductPageOperator(productName);
        operator.newProduct();
    }

    @Test
    public void productInfoCorrect() {

        String actualName = tester.getParagraphText(Elements.NAME_PARAGRAPH);
        String productDescription = tester.getParagraphText(Elements.DESCRIPTION_PARAGRAPH);
        String productAbbreviation = tester.getParagraphText(Elements.ABBREVIATION_PARAGRAPH);
        String productCode = tester.getParagraphText(Elements.CODE_PARAGRAPH);
        String systemName = tester.getParagraphText(Elements.SYSTEM_NAME_PARAGRAPH);

        Assert.assertEquals(productName, actualName);
        Assert.assertEquals(productDescription, Strings.PRODUCT_DESCRIPTION);
        Assert.assertEquals(productAbbreviation, productName);
        Assert.assertEquals(productCode, productName);
        Assert.assertEquals(systemName, productName);
    }

    @Test
    public void createProductVersion() {
        new VersionPageOperator(productName).newVersion();
        assertLinkExists(Strings.PRODUCT_VERSION);
    }

}
