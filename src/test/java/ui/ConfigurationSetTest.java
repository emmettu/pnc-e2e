package ui;

import operators.base.LinkOperator;
import operators.base.ParagraphOperator;
import operators.configurations.BuildConfigurationSetPageOperator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.Elements;
import util.RandomName;

import java.io.IOException;

/**
 * Created by eunderhi on 28/07/15.
 */
public class ConfigurationSetTest extends UITest {

    protected static String configurationSetName;

    @Test
    public void createConfigurationSet() {
        configurationSetName = RandomName.getRandomName();
        new BuildConfigurationSetPageOperator(configurationSetName).createBuildConfigurationSet();
        assertLinkExists(configurationSetName);
    }

    @Test
    public void addBuildConfiguration() {
        configurationSetName = RandomName.getRandomName();
        BuildConfigurationSetPageOperator operator = new BuildConfigurationSetPageOperator(configurationSetName);
        operator.createBuildConfigurationSet();
        operator.addBuildConfiguration();

        String pageText = new ParagraphOperator(Elements.BUILD_CONFIGURATION_SET_NAME_P).getParagraphText();
        Assert.assertEquals(pageText, configurationSetName);
    }

}
