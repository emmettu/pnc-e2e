import org.junit.Test;

/**
 * Created by mvaghela on 27/07/15.
 */
public class ProductsTest extends UITest {

    @Test
    public void createProduct() {
        String productName = "Project New Castle Demo Product 2";

        tester.clickLink("Products");
        tester.clickButton("Create Product");
        tester.insertInput("name", productName);
        tester.insertTextareaInput("description", "Demo 2");
        tester.insertInput("abbreviation", "PNC2");
        tester.insertInput("productCode", "PNC2");
        tester.insertInput("pgmSystemName", "newcastle2");
        tester.clickInputButton("Create");
        tester.clickLink("Products");

        assertConfigurationSetExists(productName);
    }
}
