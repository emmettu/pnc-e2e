package tasks;

/**
 * Created by eunderhi on 09/09/15.
 */
public class LoginOperator extends Operator {

    public void login(String loginURL, String username, String password) {
        driver.get(loginURL);
        new TextInputOperator().insertInput("username", username);
        new TextInputOperator().insertInput("password", password);
        new SubmitOperator().submit();
    }
}
