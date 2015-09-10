package ui;

import org.junit.Before;

/**
 * Created by eunderhi on 29/07/15.
 */
public class MilestoneVersionTest extends VersionTest {
    private static final String VERSION_NUMBER = "1.12";
    private static final String START_DATE = "1994/10/05";
    private static final String RELEASE_DATE = "1997/07/04";

    @Before
    public void createMilestone() {
        tester.clickButton("Create Milestone");
        tester.textInput("version", VERSION_NUMBER);
        tester.textInput("startingDate", START_DATE);
        tester.textInput("plannedReleaseDate", RELEASE_DATE);
        tester.submit();
    }
}
