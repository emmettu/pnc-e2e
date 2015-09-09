import org.junit.Before;

/**
 * Created by eunderhi on 29/07/15.
 */
public class VersionTest extends UITest {

    @Before
    public void goToVersionPage() {
        tester.clickLink("Products");
        tester.clickLink("Project Newcastle Demo Product"); //will eventually need to be replaced
        tester.clickLink("1.0");
    }

}
