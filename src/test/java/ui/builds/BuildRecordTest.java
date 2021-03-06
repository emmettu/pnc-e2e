package ui.builds;

import operators.configurations.BuildConfigPageOperator;
import org.junit.Test;
import ui.UITest;
import util.Elements;
import util.RandomName;

/**
 * Created by eunderhi on 16/09/15.
 */
public class BuildRecordTest extends UITest {

    @Test
    public void startBuildTest() {
        String configurationName = RandomName.getRandomName();
        BuildConfigPageOperator operator = new BuildConfigPageOperator(configurationName);
        operator.createBuildConfiguration();
        operator.buildBuildConfiguration();
        tester.clickLink(Elements.BUILDS_LINK);
        tester.clickLink(Elements.BUILD_RECORD_LINK);
        assertLinkExists(configurationName);
    }

}
