package operators.products;

import operators.base.*;
import util.Elements;
import util.Strings;

/**
 * Created by eunderhi on 15/09/15.
 */
public class ReleasePageOperator extends Operator {

    public ReleasePageOperator(String name) {
        super(name);
    }

   public void createRelease() throws InterruptedException {
       new LinkOperator(Elements.PRODUCT_LINK).clickLink();
       new LinkOperator(name).clickLink();
       new LinkOperator(Strings.PRODUCT_VERSION).clickLink();
       new ButtonOperator(Elements.CREATE_RELEASE_BUTTON).clickButton();
       new TextInputOperator(Elements.RELEASE_VERSION_INPUT).insertInput(Strings.RELEASE_VERSION_INPUT);
       new TextInputOperator(Elements.RELEASE_DATE).insertInput(Strings.RELEASE_DATE);
       new SelectOperator(Elements.RELEASE_MILESTONE).clickFirstNonEmptySelect();
       new SelectOperator(Elements.RELEASE_SUPPORT_LEVEL).clickFirstNonEmptySelect();
       new TextInputOperator(Elements.RELEASE_URL).insertInput(Strings.RELEASE_URL);
       new SubmitOperator().submit();
   }

}
