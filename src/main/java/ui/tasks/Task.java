package ui.tasks;

import ui.UITester;

/**
 * Created by eunderhi on 27/07/15.
 */
public interface Task {
    void complete();
    void setUITester(UITester tester);
    void setElementName(String name);
}
