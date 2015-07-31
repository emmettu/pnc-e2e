import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;


/**
 * Created by mvaghela on 29/07/15.
 */
public class BuildConfigurationsTest extends UITest {
    private static final String CONFIGURATION_NAME = "test name";
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
    @Test
    public void createBuildConfiguration() throws IOException{
        tester.clickLink("Configurations");
        tester.clickLink("Build Configurations");
        tester.clickButton("Create Configuration");
        tester.insertInput("name", CONFIGURATION_NAME);
        tester.clickSelect("createCtrl.data.projectId", "1");
        tester.textAreaInput("description", CONFIGURATION_DESCRIPTION);
        tester.insertInput("scmRepoURL", SCM_URL);
        tester.insertInput("scmRevision", SCM_REVISION);
        tester.textAreaInput("buildScript", BUILD_SCRIPT);
        tester.clickSelect("createCtrl.products.selected", "0");
        tester.clickSelect("createCtrl.data.environmentId", 1);
        tester.clickInputButton("Create");
        tester.clickLink("Configurations");
        tester.clickLink("Build Configurations");
    }

    @Test
    public void buildConfigurationCreated(){
        assertLinkExists(CONFIGURATION_NAME);
    }

    @Test
    public void buildConfigurationInfoCorrect(){
        tester.clickLink(CONFIGURATION_NAME);

        String configurationName = tester.getParagraphText("input-name");
        String configurationProject = tester.getParagraphText("static-project");
       // String configuraitonDescription = tester.getParagraphText(""); Can't do this, not a paragraph
        String SCMUrl = tester.getParagraphText("input-scm-repo-url");
        String SCMRevision = tester.getParagraphText("input-scm-revision");
      //  String buildScript = tester.getParagraphText(""); can't do this, not a paragraph
      //  String dependences = tester.something("");   this is a div
      //  String productVersions = tester.something(""); this is a div

        Assert.assertEquals(configurationName, CONFIGURATION_NAME);
      //  Assert.assertEquals(configurationProject, something); not sure how to verify this
      //  Assert.assertEquals(configurationDescription, CONFIGURATION_DESCRIPTION);
        Assert.assertEquals(SCMUrl, SCM_URL);
        Assert.assertEquals(SCMRevision, SCM_REVISION);
     //   Assert.assertEquals(buildScript, BUILD_SCRIPT);
     //   Assert.assertEquals(dependencies, DEPENDENCIES);
     //   Assert.assertEquals(productVerions, PRODUCT_VERSIONS);
    }
}
