package ui;

import org.junit.Before;
import util.RandomName;

import java.io.IOException;

/**
 * Created by eunderhi on 28/07/15.
 */
public class ConfigurationSetTest extends UITest {

    protected static  String configurationSetName;
    protected static final String CONFIGURATION_SET_LINK = "#/configuration/1";

    @Before
    public void CreateConfigurationSet() throws IOException {
        configurationSetName = RandomName.getRandomName();

        tester.clickLink("Configurations");
        tester.clickLink("Build Configuration Sets");
        tester.clickButton("Create Build Configuration Set");
        tester.textInput("name", configurationSetName);
        tester.submit();
        assertLinkExists(configurationSetName);
        tester.takeScreenshot();
    }

}
