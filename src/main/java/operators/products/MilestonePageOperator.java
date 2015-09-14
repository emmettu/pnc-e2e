package operators.products;

import operators.base.*;
import util.Elements;
import util.Strings;

/**
 * Created by eunderhi on 14/09/15.
 */
public class MilestonePageOperator extends Operator {

    public MilestonePageOperator(String name) {
        super(name);
    }

    public void createMilestone() {
        new LinkOperator(Elements.PRODUCT_LINK).clickLink();
        new LinkOperator(name).clickLink();
        new LinkOperator(Strings.PRODUCT_VERSION).clickLink();
        new ButtonOperator(Elements.CREATE_MILESTONE_BUTTON).clickButton();
        new TextInputOperator(Elements.MILESTONE_VERSION_INPUT).insertInput(Strings.MILESTONE_VERSION_INPUT);
        new TextInputOperator(Elements.MILESTONE_START_DATE).insertInput(Strings.MILESTONE_START_DATE);
        new TextInputOperator(Elements.MILESTONE_RELEASE_DATE).insertInput(Strings.MILESTONE_RELEASE_DATE);
        new SubmitOperator().submit();
    }

}
