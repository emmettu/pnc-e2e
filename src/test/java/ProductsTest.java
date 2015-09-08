import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Random;

/**
 * Created by mvaghela on 27/07/15.
 */
public class ProductsTest extends UITest {
    private static String productName;
    private static final String PRODUCT_DESCRIPTION = "test description";
    private static final String PRODUCT_ABBREVIATION = "test abbreviation";
    private static final String PRODUCT_CODE = "test code";
    private static final String SYSTEM_NAME = "test system name";

    @Before
    public void createProduct() {
        int randomProductId = new Random().nextInt(1000000);
        productName = String.valueOf(randomProductId);
        tester.clickLink("Products");
        tester.clickButton("Create Product");
        tester.insertInput("name", productName);
        tester.textAreaInput("description", PRODUCT_DESCRIPTION);
        tester.insertInput("abbreviation", PRODUCT_ABBREVIATION);
        tester.insertInput("productCode", PRODUCT_CODE);
        tester.insertInput("pgmSystemName", SYSTEM_NAME);
        tester.submit();
    }

    @Test
    public void productInfoCorrect() {

        tester.takeScreenshot();
        String productName = tester.getParagraphText("input-name");
        String productDescription = tester.getParagraphText("input-description");
        String productAbbreviation = tester.getParagraphText("input-abbreviation");
        String productCode = tester.getParagraphText("input-productCode");
        String systemName = tester.getParagraphText("input-pgmSystemName");

        Assert.assertEquals(productName, ProductsTest.productName);
        Assert.assertEquals(productDescription, PRODUCT_DESCRIPTION);
        Assert.assertEquals(productAbbreviation, PRODUCT_ABBREVIATION);
        Assert.assertEquals(productCode, PRODUCT_CODE);
        Assert.assertEquals(systemName, SYSTEM_NAME);
    }
}
