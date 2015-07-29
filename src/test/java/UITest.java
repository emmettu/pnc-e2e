import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import ui.UITester;

/**
 * Created by eunderhi on 28/07/15.
 * Base class that implements the basic set up
 * and teardown elements of all UI tests, and provides
 * asserts common to all tests.
 */

public class UITest {
    UITester tester;

    @Before
    public void setUp() {
        tester = new UITester();
    }
    @After
    public void tearDown() {
        tester.quit();
    }
    public void assertLinkExists(String linkName) {
        boolean visibility = tester.findLink(linkName).isDisplayed();
        Assert.assertEquals(visibility, true);
    }
}
