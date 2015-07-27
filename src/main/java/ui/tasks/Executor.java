package ui.tasks;

/**
 * Created by eunderhi on 27/07/15.
 */
public class Executor {
    Task[] tasks;

    public Executor(Task[] tasks) {
        this.tasks = tasks;
    }
    public void execute() {
        for(int i = 0; i < tasks.length; i++) {
            tasks[i].complete();
        }
    }
}
