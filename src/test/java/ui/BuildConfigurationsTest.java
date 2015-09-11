package ui;

import operators.configurations.BuildConfigurationPageOperator;
import org.junit.Assert;
import org.junit.Test;
import util.Elements;
import util.RandomName;
import util.Strings;


/**
 * Created by mvaghela on 29/07/15.
 */
public class BuildConfigurationsTest extends UITest {

    private static String configurationName;

    @Test
    public void buildConfigurationInfoCorrect(){
        createNewConfiguration();

        String configurationName = tester.getParagraphText(Elements.BUILD_CONFIGURATION_NAME_P);
        String configurationDescription = tester.getParagraphText(Elements.BUILD_CONFIGURATION_DESCRIPTION_P);
        String SCMUrl = tester.getParagraphText(Elements.BUILD_CONFIGURATION_SCM_URL_P);
        String SCMRevision = tester.getParagraphText(Elements.BUILD_CONFIGURATION_SCM_REVISION_P);

        Assert.assertEquals(configurationName, configurationName);
        Assert.assertEquals(configurationDescription, Strings.BUILD_CONFIGURATION_DESCRIPTION);
        Assert.assertEquals(SCMUrl, Strings.BUILD_CONFIGURATION_SCM_URL);
        Assert.assertEquals(SCMRevision, Strings.BUILD_CONFIGURATION_SCM_REVISION);
    }


    @Test
    public void configurationExists() {
        createNewConfiguration();

        tester.clickLink(Elements.CONFIGURATION_LINK);
        tester.clickLink(Elements.BUILD_CONFIGURATION_LINK);
        assertLinkExists(configurationName);
    }

    private void createNewConfiguration() {
        configurationName = RandomName.getRandomName();
        new BuildConfigurationPageOperator(configurationName).createBuildConfiguration();
    }
}
