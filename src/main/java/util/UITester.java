package util;

import operators.base.*;
import org.openqa.selenium.*;

import operators.*;

/**
 * Created by eunderhi on 27/07/15.
 */
public class UITester {

    public UITester() {
        new SetUpOperator().setUp();
    }

    public void clickLink(String linkText) {
        new LinkOperator().clickLink(linkText);
    }

    public void clickButton(String buttonName) {
        new ButtonOperator().clickButton(buttonName);
    }

    public void textInput(String name, String input) {
        new TextInputOperator().insertInput(name, input);
    }

    public void textAreaInput(String elementName, String inputString) {
        new AreaTextOperator().textAreaInput(elementName, inputString);
    }

    public void submit(){
        new SubmitOperator().submit();
    }

    public void clickSelect(String ngModel, int value) {
        new SelectOperator().clickSelect(ngModel, value);
    }

    public void clickFirstNonEmptySelect(String ngModel) {
        new SelectOperator().clickFirstNonEmptySelect(ngModel);
    }

    public void clickCheckBox() {
        new CheckBoxOperator().clickCheckBox();
    }

    public String getParagraphText(String name) {
        return new ParagraphOperator().getParagraphText(name);
    }

    public WebElement findParagraph(String name) {
        return new ParagraphOperator().findParagraph(name);
    }

    public WebElement findSpan(String name) {
        return new SpanOperator().findSpan(name);
    }

    public void takeFailScreenShot(String name) {
        new ScreenShotOperator().takeFailScreenShot(name);
    }

    public void takeSucceedScreenShot(String name) {
        new ScreenShotOperator().takeSucceedScreenShot(name);
    }

    public void quit() {
        new TearDownOperator().tearDown();
    }

    public WebDriver getDriver() {
        return Operator.getDriver();
    }

}
