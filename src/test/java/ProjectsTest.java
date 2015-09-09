import org.junit.*;
import org.junit.Test;
import util.Strings;

import java.util.Random;

/**
 * Created by eunderhi on 29/07/15.
 */
public class ProjectsTest extends UITest{
    private static  String projectName;
    private static final String PROJECT_DESCRIPTION = "test description";
    private static final String PROJECT_URL = "http://test";
    private static final String ISSUE_TRACKER_URL = "http://test";

    @Before
    public void createProject() {
        int randomProjectId = new Random().nextInt(1000000);
        projectName = String.valueOf(randomProjectId);
        tester.clickLink("Projects");
        tester.clickButton(Strings.CREATE_PROJECT);
        tester.textInput(Strings.NAME, projectName);
        tester.textAreaInput(Strings.DESCRIPTION, PROJECT_DESCRIPTION);
        tester.textInput("projectUrl", PROJECT_URL);
        tester.textInput("issueTrackerUrl", ISSUE_TRACKER_URL);
        tester.submit();
        tester.clickLink(Strings.PROJECTS);
    }
    @Test
    public void productCreated() {
        tester.clickLink("Projects");
        assertLinkExists(projectName);
    }
    @Test
    public void productInfoCorrect() {

        String productName = tester.getParagraphText("input-name");
        String productDescription = tester.getParagraphText("static-description");
        String productAbbreviation = tester.getParagraphText("input-url");
        String productCode = tester.getParagraphText("input-issue-tracker");

        Assert.assertEquals(productName, projectName);
        Assert.assertEquals(productDescription, PROJECT_DESCRIPTION);
        Assert.assertEquals(productAbbreviation, PROJECT_URL);
        Assert.assertEquals(productCode, ISSUE_TRACKER_URL);
    }
}
