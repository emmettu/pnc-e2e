import org.junit.Test;

/**
 * Created by eunderhi on 29/07/15.
 */
public class SelectTest extends UITest {
    @Test
    public void selectItem() {
        tester.clickLink("Configurations");
        tester.clickLink("Build Configurations");
        tester.clickButton("Create Configuration");
        tester.clickSelect("createCtrl.data.projectId", 1);
        tester.takeScreenshot();
    }
}
