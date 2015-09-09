package operators;

import operators.base.Operator;

/**
 * Created by eunderhi on 09/09/15.
 */
public class TearDownOperator extends Operator {

    public void tearDown() {
        driver.quit();
    }
}
