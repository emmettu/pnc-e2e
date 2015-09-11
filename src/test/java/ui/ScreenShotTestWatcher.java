package ui;

import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import util.UITester;

/**
 * Created by eunderhi on 11/09/15.
 */

public class ScreenShotTestWatcher extends TestWatcher {

    UITester tester;
    String className;

    public ScreenShotTestWatcher(String className) {
        this.className = className;
    }

    @Override
    protected void failed(Throwable e, Description description) {
        tester.takeFailScreenShot(className);
        tester.quit();
    }

    @Override
    protected void succeeded(Description description) {
        tester.takeSucceedScreenShot(className);
        tester.quit();
    }

    public void setTester(UITester tester) {
        this.tester = tester;
    }

}
