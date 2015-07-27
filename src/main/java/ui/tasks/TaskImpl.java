package ui.tasks;

import ui.UITester;

/**
 * Created by eunderhi on 27/07/15.
 */
public abstract class TaskImpl implements Task{
    UITester tester;
    String elementName;

    public abstract void complete();
    public void setUITester(UITester tester) {
        this.tester = tester;
    }
    public void setElementName(String name) {
        elementName = name;
    }
}
