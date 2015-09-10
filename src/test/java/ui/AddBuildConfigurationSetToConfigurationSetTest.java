package ui;

import org.junit.Test;

/**
 * Created by eunderhi on 31/08/15.
 */
public class AddBuildConfigurationSetToConfigurationSetTest extends ConfigurationSetTest {

    @Test
    public void addBuildConfiguration() {
        tester.clickLink(configurationSetName);
        tester.clickButton("Add an existing Build Configuration");
        tester.clickFirstNonEmptySelect("addConfigurationSetCtrl.data.selectedProjectId");
        tester.clickCheckBox();
        tester.submit();
//        tester.getDriver().findElement(By.xpath("//a[@href='#/configuration/1']"));
//        String linkXpath = String.format("//a[@href='%s']", CONFIGURATION_SET_LINK);
//        tester.getDriver().findElement(By.xpath(linkXpath));
    }
}
