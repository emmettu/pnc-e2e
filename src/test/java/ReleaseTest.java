import org.junit.Test;

/**
 * Created by eunderhi on 29/07/15.
 */
public class ReleaseTest extends VersionTest {
    private static final String VERSION_NUMBER = "1.12";
    private static final String RELEASE_DATE = "1997/07/04";
    private static final String SUPPORT_LEVEL = "1";
    private static final String DOWNLOAD_URL = "http://test";

    @Test
    public void createRelease() {
        tester.clickButton("Create Release");
        tester.insertInput("version", VERSION_NUMBER);
        tester.insertInput("releaseDate", RELEASE_DATE);
        tester.clickSelect("releaseCreateUpdateCtrl.productMilestoneId", "2");
        tester.clickSelect("releaseCreateUpdateCtrl.data.supportLevel", SUPPORT_LEVEL);
        tester.insertInput("downloadurl", DOWNLOAD_URL);
        tester.submit();
        tester.takeScreenshot();
    }
}
