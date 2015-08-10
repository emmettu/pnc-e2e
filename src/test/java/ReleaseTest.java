import org.junit.Test;

/**
 * Created by eunderhi on 29/07/15.
 */
public class ReleaseTest extends MilestoneVersionTest {
    private static final String VERSION_NUMBER = "1.15";
    private static final String RELEASE_DATE = "1997/07/04";
    private static final String MILESTONE = "2";
    private static final int SUPPORT_LEVEL = 2;
    private static final String DOWNLOAD_URL = "http://test";
    private static final String VERION_URL = "product/1/version/1";

    @Test
    public void createRelease() {
        tester.clickButton("Create Release");
        tester.insertInput("version", VERSION_NUMBER);
        tester.insertInput("releaseDate", RELEASE_DATE);
        tester.clickSelect("releaseCreateUpdateCtrl.productMilestoneId", MILESTONE);
        tester.clickSelect("releaseCreateUpdateCtrl.data.supportLevel", SUPPORT_LEVEL);
        tester.insertInput("downloadurl", DOWNLOAD_URL);
        tester.submit();
        tester.getURL(VERION_URL);
        tester.findSpan("1.0.1.15");
    }
}
