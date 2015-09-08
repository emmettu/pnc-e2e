import org.junit.Before;

import java.io.IOException;
import java.util.Random;

/**
 * Created by eunderhi on 28/07/15.
 */
public class ConfigurationSetTest extends UITest {

    protected static  String configurationSetName;
    protected static final String CONFIGURATION_SET_LINK = "#/configuration/1";

    @Before
    public void CreateConfigurationSet() throws IOException {
        int randomConfigurationId = new Random().nextInt(1000000);
        configurationSetName = String.valueOf(randomConfigurationId);

        tester.clickLink("Configurations");
        tester.clickLink("Build Configuration Sets");
        tester.clickButton("Create Build Configuration Set");
        tester.insertInput("name", configurationSetName);
        tester.submit();
        assertLinkExists(configurationSetName);
        tester.takeScreenshot();
    }

}
