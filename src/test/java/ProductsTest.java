import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by mvaghela on 27/07/15.
 */
public class ProductsTest extends UITest {
    private static final String PRODUCT_NAME = "test name";
    private static final String PRODUCT_DESCRIPTION = "test description";
    private static final String PRODUCT_ABBREVIATION = "test abbreviation";
    private static final String PRODUCT_CODE = "test code";
    private static final String SYSTEM_NAME = "test system name";

    @Before
    public void createProduct() {
        tester.clickLink("Products");
        tester.clickButton("Create Product");
        tester.insertInput("name", PRODUCT_NAME);
        tester.textAreaInput("description", PRODUCT_DESCRIPTION);
        tester.insertInput("abbreviation", PRODUCT_ABBREVIATION);
        tester.insertInput("productCode", PRODUCT_CODE);
        tester.insertInput("pgmSystemName", SYSTEM_NAME);
        tester.submit();
        tester.clickLink("Products");
    }

    @Test
    public void productCreated() {
        assertLinkExists(PRODUCT_NAME);
    }
    @Test
    public void productInfoCorrect() {
        tester.clickLink(PRODUCT_NAME);

        String productName = tester.getParagraphText("input-name");
        String productDescription = tester.getParagraphText("input-description");
        String productAbbreviation = tester.getParagraphText("input-abbreviation");
        String productCode = tester.getParagraphText("input-productCode");
        String systemName = tester.getParagraphText("input-pgmSystemName");

        Assert.assertEquals(productName, PRODUCT_NAME);
        Assert.assertEquals(productDescription, PRODUCT_DESCRIPTION);
        Assert.assertEquals(productAbbreviation, PRODUCT_ABBREVIATION);
        Assert.assertEquals(productCode, PRODUCT_CODE);
        Assert.assertEquals(systemName, SYSTEM_NAME);
    }
}
