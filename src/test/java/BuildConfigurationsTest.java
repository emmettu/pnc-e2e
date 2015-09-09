import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Random;


/**
 * Created by mvaghela on 29/07/15.
 */
public class BuildConfigurationsTest extends UITest {
    private static String configurationName;
    private static final String CONFIGURATION_DESCRIPTION = "test description";
    private static final String SCM_URL = "test abbreviation";
    private static final String SCM_REVISION = "test code";
    private static final String BUILD_SCRIPT = "test system name";
    private static final String DEPENDENCIES = "";
    private static final String PRODUCT_VERSIONS = "";

    @Before
    public void navigateToPage() {
        tester.clickLink("Configurations");
        tester.clickLink("Build Configurations");
    }
    @Before
    public void createBuildConfiguration() throws IOException{
        int randomConfigurationId = new Random().nextInt(1000000);
        configurationName = String.valueOf(randomConfigurationId);

        tester.clickLink("Configurations");
        tester.clickLink("Build Configurations");
        tester.clickButton("Create Configuration");
        tester.textInput("name", configurationName);
        tester.clickSelect("createCtrl.data.projectId", 2);
        tester.textInput("description", CONFIGURATION_DESCRIPTION);
        tester.textInput("scmRepoURL", SCM_URL);
        tester.textInput("scmRevision", SCM_REVISION);
        tester.textInput("buildScript", BUILD_SCRIPT);
        tester.clickSelect("createCtrl.products.selected", 1);
        tester.clickSelect("createCtrl.data.environmentId", 1);
        tester.submit();
        tester.clickLink("Configurations");
        tester.clickLink("Build Configurations");
    }

    @Test
    public void buildConfigurationCreated(){
        assertLinkExists(configurationName);
    }

    @Test
    public void buildConfigurationInfoCorrect(){
        tester.clickLink(configurationName);

        String configurationName = tester.getParagraphText("input-name");
        String configurationProject = tester.getParagraphText("static-project");
        String configuraitonDescription = tester.getParagraphText("input-description");
        String SCMUrl = tester.getParagraphText("input-scm-repo-url");
        String SCMRevision = tester.getParagraphText("input-scm-revision");
      //  String buildScript = tester.getParagraphText(""); can't do this, not a paragraph
      //  String dependences = tester.something("");   this is a div
      //  String productVersions = tester.something(""); this is a div

        Assert.assertEquals(configurationName, configurationName);
        Assert.assertEquals(configuraitonDescription, CONFIGURATION_DESCRIPTION);
        Assert.assertEquals(SCMUrl, SCM_URL);
        Assert.assertEquals(SCMRevision, SCM_REVISION);
     //   Assert.assertEquals(buildScript, BUILD_SCRIPT);
     //   Assert.assertEquals(dependencies, DEPENDENCIES);
     //   Assert.assertEquals(productVerions, PRODUCT_VERSIONS);
    }
}
