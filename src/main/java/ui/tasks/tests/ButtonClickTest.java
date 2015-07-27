package ui.tasks.tests;

import ui.UITester;
import ui.tasks.Task;
import ui.tasks.TaskCreator;

/**
 * Created by eunderhi on 27/07/15.
 */
public class ButtonClickTest {

    public static void test() {
        UITester tester = new UITester();
        TaskCreator tc = new TaskCreator(tester);
        Task[] tasks = {tc.buttonClick("Create Configuration")};
        for(int i = 0; i < tasks.length; i++) {
            tasks[i].complete();
        }
    }
}
