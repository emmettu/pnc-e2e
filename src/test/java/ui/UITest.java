package ui;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import junit.framework.AssertionFailedError;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import util.UITester;

/**
 * Created by eunderhi on 28/07/15.
 * Base class that implements the basic set up
 * and teardown elements of all UI tests, and provides
 * asserts common to all tests.
 */

public class UITest {

    public UITester tester;

    @Rule
    public ScreenShotTestWatcher testWatcher = new ScreenShotTestWatcher(getClass().getName());

    @Before
    public void setUp() {
        tester = new UITester();
        testWatcher.setTester(tester);
    }

    @After
    public void tearDown() {
    }

    public void assertLinkExists(String linkName) {
        boolean visibility = tester.getDriver().findElement(By.linkText(linkName)).isEnabled();
        Assert.assertEquals(visibility, true);
    }

    public void assertLinkDoesNotExists(String linkName) {
        try {
            tester.getDriver().findElement(By.linkText(linkName)).isEnabled();
        }
        catch(NoSuchElementException e) {
            return;
        }

        throw new AssertionFailedError(linkName + " was visible when it should not have been");
    }


    public void assertBuildRecordExists(String recordName) {
        boolean visibility = tester.getDriver().findElement(By.partialLinkText(recordName)).isDisplayed();
        Assert.assertEquals(visibility, true);
    }

}

