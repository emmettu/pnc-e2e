package operators.base;

/**
 * Created by eunderhi on 06/10/15.
 */
public class RefreshOperator extends Operator{
    public void refresh() {
        driver.navigate().refresh();
    }
}
