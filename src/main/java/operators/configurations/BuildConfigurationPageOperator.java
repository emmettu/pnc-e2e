package operators.configurations;

import operators.base.*;
import util.Elements;
import util.Strings;

/**
 * Created by eunderhi on 10/09/15.
 */
public class BuildConfigurationPageOperator extends Operator {

    String name;

    public BuildConfigurationPageOperator(String name) {
        this.name = name;
    }

    public void createBuildConfiguration() {
        new LinkOperator().clickLink(Elements.CONFIGURATION_LINK);
        new LinkOperator().clickLink(Elements.BUILD_CONFIGURATION_LINK);
        new ButtonOperator().clickButton(Elements.CREATE_CONFIGURATION_BUTTON);
        new TextInputOperator().insertInput(Elements.BUILD_CONFIGURATION_INPUT, name);
        new SelectOperator().clickSelect(Elements.BUILD_CONFIGURATION_PROJECT_SELECT, 2);
        new AreaTextOperator().textAreaInput(Elements.BUILD_CONFIGURATION_DESCRIPTION, Strings.BUILD_CONFIGURATION_DESCRIPTION);
        new TextInputOperator().insertInput(Elements.BUILD_CONFIGURATION_SCM_URL, Strings.BUILD_CONFIGURATION_SCM_URL);
        new TextInputOperator().insertInput(Elements.BUILD_CONFIGURATION_SCM_REVISION, Strings.BUILD_CONFIGURATION_SCM_REVISION);
        new AreaTextOperator().textAreaInput(Elements.BUILD_CONFIGURATION_BUILD_SCRIPT, Strings.BUILD_CONFIGURATION_BUILD_SCRIPT);
        new SelectOperator().clickSelect(Elements.BUILD_CONFIGURATION_PRODUCT, 1);
        new SelectOperator().clickSelect(Elements.BUILD_CONFIGURATION_ENVIRONMENT, 1);
        new SubmitOperator().submit();
    }

}
