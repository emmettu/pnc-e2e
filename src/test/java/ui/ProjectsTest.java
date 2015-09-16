package ui;

import operators.projects.ProjectPageOperator;
import org.junit.*;
import org.junit.Test;
import util.Elements;
import util.RandomName;
import util.Strings;

/**
 * Created by eunderhi on 29/07/15.
 */
public class ProjectsTest extends UITest{

    private static  String projectName;

    @Before
    public void createProject() {
        projectName = RandomName.getRandomName();
        new ProjectPageOperator(projectName).newProject();
    }

    @Test
    public void projectInfoCorrect() {
        String actualName = tester.getParagraphText(Elements.NAME_PARAGRAPH);
        String projectDescription = tester.getParagraphText(Elements.PROJECT_DESCRIPTION_PARAGRAPH);
        String projectUrl = tester.getParagraphText(Elements.PROJECT_URL_PARAGRAPH);
        String projectIssueUrl = tester.getParagraphText(Elements.PROJECT_ISSUE_URL_PARAGRAPH);

        Assert.assertEquals(projectName, actualName);
        Assert.assertEquals(Strings.PRODUCT_DESCRIPTION, projectDescription);
        Assert.assertEquals(Strings.PROJECT_URL, projectUrl);
        Assert.assertEquals(Strings.PROJECT_ISSUE_URL, projectIssueUrl);
    }

    @Test
    public void projectExists() {
        tester.clickLink(Elements.PROJECT_LINK);
        assertLinkExists(projectName);
    }

}
