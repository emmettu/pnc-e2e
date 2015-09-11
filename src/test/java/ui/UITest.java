package ui;

import org.junit.*;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.By;
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
        boolean visibility = tester.getDriver().findElement(By.linkText(linkName)).isDisplayed();
        Assert.assertEquals(visibility, true);
    }


    public void assertBuildRecordExists(String recordName) {
        boolean visibility = tester.getDriver().findElement(By.partialLinkText(recordName)).isDisplayed();
        Assert.assertEquals(visibility, true);
    }

}

