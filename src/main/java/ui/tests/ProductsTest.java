package ui.tests;

import ui.UITester;
import ui.tasks.Executor;
import ui.tasks.Task;
import ui.tasks.TaskCreator;

/**
 * Created by mvaghela on 27/07/15.
 */
public class ProductsTest {

    public static void test() {
     createProduct();
    }

    public static void createProduct() {
        UITester tester = new UITester();
        TaskCreator tc = new TaskCreator(tester);
        Task[] tasks = {
                tc.linkClick("Products"),
                tc.buttonClick("Create Product"),
                tc.textInput("name", "Project New Castle Demo Product 2"),
//                tc.textInput("description", "Demo 2"), // won't work cause its a textarea
                tc.textInput("abbreviation", "PNC2"),
                tc.textInput("productCode", "PNC2"),
                tc.textInput("pgmSystemName", "newcastle2"),
//                tc.buttonClick("Create") // won't work cause its an input
        };
        new Executor(tasks).execute();
        tester.takeScreenshot();
    }
}
