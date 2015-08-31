import org.junit.Before;

import java.io.IOException;

/**
 * Created by eunderhi on 28/07/15.
 */
public class ConfigurationSetTest extends UITest {

    protected static final String CONFIGURATION_SET_NAME = "test name";
    protected static final String CONFIGURATION_SET_LINK = "#/configuration/1";

    @Before
    public void CreateConfigurationSet() throws IOException {
        tester.clickLink("Configurations");
        tester.clickLink("Build Configuration Sets");
        tester.clickButton("Create Build Configuration Set");
        tester.insertInput("name", CONFIGURATION_SET_NAME);
        tester.submit();
        assertLinkExists(CONFIGURATION_SET_NAME);
        tester.takeScreenshot();
    }

}
