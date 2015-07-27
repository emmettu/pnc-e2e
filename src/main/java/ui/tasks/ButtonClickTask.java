package ui.tasks;

/**
 * Created by eunderhi on 27/07/15.
 */
public class ButtonClickTask extends TaskImpl{

    @Override
    public void complete() {
        tester.clickButton(elementName);
        tester.takeScreenshot();
    }
}
