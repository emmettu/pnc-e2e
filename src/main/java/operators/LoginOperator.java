package operators;

import operators.base.Operator;
import operators.base.SubmitOperator;
import operators.base.TextInputOperator;

/**
 * Created by eunderhi on 09/09/15.
 */
public class LoginOperator extends Operator {

    public void login(String loginURL, String username, String password) {
        driver.get(loginURL);
        new TextInputOperator("username").insertInput(username);
        new TextInputOperator("password").insertInput(password);
        new SubmitOperator().submit();
    }
}
