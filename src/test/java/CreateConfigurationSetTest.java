import org.junit.Test;

/**
 * Created by eunderhi on 28/07/15.
 */
public class CreateConfigurationSetTest extends UITest{
    @Test
    public void CreateConfigurationSet() {
        tester.clickLink("Configurations");
        tester.clickLink("Build Configuration Sets");
        tester.clickButton("Create Build Configuration Set");
        tester.insertInput("name", "teeest");
        tester.takeScreenshot();
    }
}
