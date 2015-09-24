package ui;

import operators.configurations.BuildConfigurationPageOperator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Keys;
import util.Elements;
import util.RandomName;
import util.Strings;


/**
 * Created by mvaghela on 29/07/15.
 */
public class BuildConfigurationsTest extends UITest {

    private static String configurationName;

    @Before
    public void createConfiguration() {
        configurationName = RandomName.getRandomName();
        new BuildConfigurationPageOperator(configurationName).createBuildConfiguration();
    }

    @Test
    public void buildConfigurationInfoCorrect(){
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
        tester.clickLink(Elements.CONFIGURATION_LINK);
        tester.clickLink(Elements.BUILD_CONFIGURATION_LINK);
        assertLinkExists(configurationName);
    }

    @Test
    public void cloneConfiguration() {
        tester.clickLink(Elements.CONFIGURATION_LINK);
        tester.clickLink(Elements.BUILD_CONFIGURATION_LINK);
        tester.clickLink(configurationName);

        tester.clickButton(Elements.BUILD_CONFIGURATION_CLONE_BUTTON);

        tester.clickLink(Elements.CONFIGURATION_LINK);
        tester.clickLink(Elements.BUILD_CONFIGURATION_LINK);
        assertCloneExists(configurationName);
    }

    @Test
    public void deleteConfiguration() {
        tester.clickLink(Elements.CONFIGURATION_LINK);
        tester.clickLink(Elements.BUILD_CONFIGURATION_LINK);
        tester.clickLink(configurationName);

        tester.clickButton(Elements.BUILD_CONFIGURATION_DELETE_BUTTON);
        tester.getDriver().switchTo().alert().accept();

        tester.clickLink(Elements.CONFIGURATION_LINK);
        tester.clickLink(Elements.BUILD_CONFIGURATION_LINK);
        assertLinkDoesNotExists(configurationName);
    }

}
