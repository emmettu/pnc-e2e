import org.junit.Test;

import java.io.IOException;

/**
 * Created by eunderhi on 31/08/15.
 */
public class BuildRecordTest extends ConfigurationSetTest {

    @Test
    public void addBuildTest() throws IOException {
        tester.clickLink(CONFIGURATION_SET_NAME);
        tester.clickButton("Start Build");
        tester.clickLink("Builds");
        tester.clickLink("Builds Records");
        assertLinkExists(CONFIGURATION_SET_NAME);
    }
}
