package operators.configurations;

import operators.base.*;
import util.Elements;
import util.Strings;

/**
 * Created by eunderhi on 10/09/15.
 */
public class BuildConfigurationPageOperator extends Operator {

    public BuildConfigurationPageOperator(String name) {
        super(name);
    }

    public void createBuildConfiguration() {
        new LinkOperator(Elements.CONFIGURATION_LINK).clickLink();
        new LinkOperator(Elements.BUILD_CONFIGURATION_LINK).clickLink();
        new ButtonOperator(Elements.CREATE_CONFIGURATION_BUTTON).clickButton();
        new TextInputOperator(Elements.BUILD_CONFIGURATION_INPUT).insertInput(name);
        new SelectOperator(Elements.BUILD_CONFIGURATION_PROJECT_SELECT).clickSelect(2);
        new AreaTextOperator(Elements.BUILD_CONFIGURATION_DESCRIPTION).textAreaInput(Strings.BUILD_CONFIGURATION_DESCRIPTION);
        new TextInputOperator(Elements.BUILD_CONFIGURATION_SCM_URL).insertInput(Strings.BUILD_CONFIGURATION_SCM_URL);
        new TextInputOperator(Elements.BUILD_CONFIGURATION_SCM_REVISION).insertInput(Strings.BUILD_CONFIGURATION_SCM_REVISION);
        new AreaTextOperator(Elements.BUILD_CONFIGURATION_BUILD_SCRIPT).textAreaInput(Strings.BUILD_CONFIGURATION_BUILD_SCRIPT);
        new SelectOperator(Elements.BUILD_CONFIGURATION_PRODUCT).clickSelect(1);
        new SelectOperator(Elements.BUILD_CONFIGURATION_ENVIRONMENT).clickSelect(1);
        new SubmitOperator().submit();
    }

}
