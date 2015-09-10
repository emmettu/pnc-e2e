package ui;

import org.junit.Test;

import java.io.IOException;

/**
 * Created by eunderhi on 31/08/15.
 */
public class BuildRecordTest extends ConfigurationSetTest {

    @Test
    public void addBuildTest() throws IOException {
        tester.clickLink(configurationSetName);
        tester.clickButton("Start Build");
        tester.clickLink("Builds");
        tester.clickLink("Build Configuration Set Records");
        assertBuildRecordExists(configurationSetName);
    }

}
