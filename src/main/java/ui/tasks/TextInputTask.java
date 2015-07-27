package ui.tasks;

/**
 * Created by eunderhi on 27/07/15.
 */
public class TextInputTask extends TaskImpl{
    String text;
    @Override
    public void complete() {
        tester.insertInput(elementName, text);
    }
    public void setText(String text) {
        this.text = text;
    }
}
