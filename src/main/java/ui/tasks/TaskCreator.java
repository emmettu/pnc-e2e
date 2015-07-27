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
    public Task linkClick(String elementName) {
        Task task = new LinkClickTask();
        task.setElementName(elementName);
        task.setUITester(tester);
        return task;
    }
    public Task textInput(String elementName, String text) {
        TextInputTask task = new TextInputTask();
        task.setElementName(elementName);
        task.setText(text);
        task.setUITester(tester);
        return task;
    }
}
