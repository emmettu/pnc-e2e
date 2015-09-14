package operators.configurations;

import operators.base.*;
import util.Elements;

/**
 * Created by eunderhi on 14/09/15.
 */
public class BuildConfigurationSetPageOperator extends Operator {

    public BuildConfigurationSetPageOperator(String name) {
        super(name);
    }

    public void createBuildConfigurationSet() {
        new LinkOperator(Elements.CONFIGURATION_LINK).clickLink();
        new LinkOperator(Elements.BUILD_CONFIGURATION_SET_LINK).clickLink();
        new ButtonOperator(Elements.CREATE_CONFIGURATION_SET_BUTTON).clickButton();
        new TextInputOperator(Elements.BUILD_CONFIGURATION_SET_INPUT).insertInput(name);
        new SubmitOperator().submit();
    }

}
