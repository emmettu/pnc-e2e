package ui.tests;

import ui.UITester;
import ui.tasks.Executor;
import ui.tasks.Task;
import ui.tasks.TaskCreator;

/**
 * Created by eunderhi on 27/07/15.
 */
public class ButtonClickTest {

    public static void test() {
        UITester tester = new UITester();
        TaskCreator tc = new TaskCreator(tester);
        Task[] tasks = {
                tc.linkClick("Configurations"),
                tc.linkClick("Build Configuration Sets"),
                tc.buttonClick("Create Build Configuration Set"),
                tc.textInput("name", "teeeeeeeest")
        };

        new Executor(tasks).execute();
        tester.takeScreenshot();
    }
}
