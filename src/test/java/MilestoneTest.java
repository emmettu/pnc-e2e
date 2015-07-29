import org.junit.*;
import org.junit.Test;

/**
 * Created by eunderhi on 29/07/15.
 */
public class MilestoneTest extends UITest{
    private static final String VERSION_NUMBER = "1.12";
    private static final String START_DATE = "1994/10/05";
    private static final String RELEASE_DATE = "1997/07/04";

    @Before
    public void goToVersionPage() {
        tester.clickLink("Products");
        tester.clickLink("Project Newcastle Demo Product"); //will eventually need to be replaced
        tester.clickLink("1.0");
    }
    @Test
    public void createMilestone() {
        tester.clickButton("Create Milestone");
        tester.insertInput("version", VERSION_NUMBER);
        tester.insertInput("startingDate", START_DATE);
        tester.insertInput("plannedReleaseDate", RELEASE_DATE);
        tester.clickInputButton("Create");
    }
}
