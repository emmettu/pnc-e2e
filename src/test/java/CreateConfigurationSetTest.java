import org.junit.Test;

import java.io.IOException;

/**
 * Created by eunderhi on 28/07/15.
 */
public class CreateConfigurationSetTest extends UITest{

    @Test
    public void CreateConfigurationSet() throws IOException{

        String configurationSetName = "teeest";
        tester.clickLink("Configurations");
        tester.clickLink("Build Configuration Sets");
        tester.clickButton("Create Build Configuration Set");
        tester.insertInput("name", configurationSetName);
        tester.clickInputButton("Create");
        assertConfigurationSetExists(configurationSetName);
        tester.takeScreenshot();
    }
}
