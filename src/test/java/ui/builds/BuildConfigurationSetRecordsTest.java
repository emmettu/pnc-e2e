package ui.builds;

import operators.configurations.BuildConfigurationSetPageOperator;
import org.junit.Test;
import ui.UITest;
import util.Elements;
import util.RandomName;

/**
 * Created by eunderhi on 16/09/15.
 */
public class BuildConfigurationSetRecordsTest extends UITest {

    @Test
    public void startBuildTest() {
        String configurationName = RandomName.getRandomName();
        BuildConfigurationSetPageOperator operator = new BuildConfigurationSetPageOperator(configurationName);
        operator.createBuildConfigurationSet();
        operator.buildBuildConfigurationSet();
        tester.clickLink(Elements.BUILDS_LINK);
        tester.clickLink(Elements.BUILD_CONFIGURATION_SET_RECORDS_LINK);
        assertLinkExists(configurationName);
    }

}
