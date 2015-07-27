package ui.tasks;

/**
 * Created by eunderhi on 27/07/15.
 */
public class LinkClickTask extends TaskImpl{

    @Override
    public void complete() {
        tester.clickLink(elementName);
    }
}
