package operators;

import operators.base.LinkOperator;
import operators.base.Operator;
import operators.base.SubmitOperator;
import operators.base.TextInputOperator;
import util.Elements;

/**
 * Created by eunderhi on 09/09/15.
 */
public class LoginOperator extends Operator {

    public void login(String loginUrl, String username, String password) {
        driver.get(loginUrl);
        new LinkOperator(Elements.LOGIN).clickLink();
        new TextInputOperator("username").insertInput(username);
        new TextInputOperator("password").insertInput(password);
        new SubmitOperator().submit();
    }
}
