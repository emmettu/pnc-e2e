import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import ui.UITester;

/**
 * Created by eunderhi on 28/07/15.
 */

public class UITest {
    UITester tester;

    @Before
    public void setUp(){
        tester = new UITester();
    }
    @After
    public void tearDown() {
        tester.quit();
    }
    public void assertConfigurationSetExists(String linkName) {
        boolean visibility = tester.findLink(linkName).isDisplayed();
        Assert.assertEquals(visibility, true);
    }
}
