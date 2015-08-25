import org.junit.Test;

/**
 * Created by eunderhi on 29/07/15.
 */
public class ReleaseTest extends MilestoneVersionTest {
    private static final String VERSION_NUMBER = "1.15";
    private static final String RELEASE_DATE = "2015/07/04";
    private static final String DOWNLOAD_URL = "http://test";

    @Test
    public void createRelease() {
        tester.clickButton("Create Release");
        tester.insertInput("version", VERSION_NUMBER);
        tester.insertInput("releaseDate", RELEASE_DATE);
        tester.clickFirstNonEmptySelect("releaseCreateUpdateCtrl.productMilestoneId");
        tester.clickFirstNonEmptySelect("releaseCreateUpdateCtrl.data.supportLevel");
        tester.insertInput("downloadurl", DOWNLOAD_URL);
        tester.submit();
        tester.findSpan("1.0.1.15");
        tester.takeScreenshot();
    }
}
