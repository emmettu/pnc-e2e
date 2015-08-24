import org.junit.*;
import org.junit.Test;
import util.Strings;

/**
 * Created by eunderhi on 29/07/15.
 */
public class ProjectsTest extends UITest{
    private static final String PROJECT_NAME = "test name";
    private static final String PROJECT_DESCRIPTION = "test description";
    private static final String PROJECT_URL = "http://test";
    private static final String ISSUE_TRACKER_URL = "http://test";

    @Before
    public void createProject() {
        tester.clickLink("Projects");
        tester.clickButton(Strings.CREATE_PROJECT);
        tester.insertInput(Strings.NAME, PROJECT_NAME);
        tester.textAreaInput(Strings.DESCRIPTION, PROJECT_DESCRIPTION);
        tester.insertInput("projectUrl", PROJECT_URL);
        tester.insertInput("issueTrackerUrl", ISSUE_TRACKER_URL);
        tester.submit();
        tester.clickLink(Strings.PROJECTS);
    }
    @Test
    public void productCreated() {
        assertLinkExists(PROJECT_NAME);
    }
    @Test
    public void productInfoCorrect() {
        tester.clickLink(PROJECT_NAME);

        String productName = tester.getParagraphText("input-name");
        String productDescription = tester.getParagraphText("static-description");
        String productAbbreviation = tester.getParagraphText("input-url");
        String productCode = tester.getParagraphText("input-issue-tracker");

        Assert.assertEquals(productName, PROJECT_NAME);
        Assert.assertEquals(productDescription, PROJECT_DESCRIPTION);
        Assert.assertEquals(productAbbreviation, PROJECT_URL);
        Assert.assertEquals(productCode, ISSUE_TRACKER_URL);
    }
}
