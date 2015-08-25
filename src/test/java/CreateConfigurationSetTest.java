import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import java.io.IOException;

/**
 * Created by eunderhi on 28/07/15.
 */
public class CreateConfigurationSetTest extends UITest {

    private static final String CONFIGURATION_SET_NAME = "test name";
    private static final String CONFIGURATION_SET_LINK = "#/configuration/1";

    @Before
    public void goToLinks() {
        tester.clickLink("Configurations");
        tester.clickLink("Build Configuration Sets");
    }

    @Test
    public void CreateConfigurationSet() throws IOException{
        tester.clickButton("Create Build Configuration Set");
        tester.insertInput("name", CONFIGURATION_SET_NAME);
        tester.submit();
        assertLinkExists(CONFIGURATION_SET_NAME);
        tester.takeScreenshot();
    }

    @Test
    public void addBuildConfiguration() {
        tester.clickLink(CONFIGURATION_SET_NAME);
        tester.clickButton("Add an existing Build Configuration");
        tester.clickFirstNonEmptySelect("addConfigurationSetCtrl.data.selectedProjectId");
        tester.clickCheckBox();
        tester.submit();
        tester.getDriver().findElement(By.xpath("//a[@href='#/configuration/1']"));
        String linkXpath = String.format("//a[@href='%s']", CONFIGURATION_SET_LINK);
        tester.getDriver().findElement(By.xpath(linkXpath));
    }
}
