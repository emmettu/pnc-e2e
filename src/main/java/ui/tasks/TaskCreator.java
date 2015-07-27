package ui.tasks;

import ui.UITester;

/**
 * Created by eunderhi on 27/07/15.
 */
public class TaskCreator {
    UITester tester;

    public TaskCreator(UITester tester) {
        this.tester = tester;
    }
    public Task buttonClick(String elementName) {
        Task task = new ButtonClickTask();
        task.setElementName(elementName);
        task.setUITester(tester);
        return task;
    }
}
