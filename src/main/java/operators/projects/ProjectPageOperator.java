package operators.projects;

import operators.base.*;
import util.Elements;
import util.Strings;

/**
 * Created by eunderhi on 10/09/15.
 */
public class ProjectPageOperator extends Operator {

    String projectName;

    public ProjectPageOperator(String projectName) {
        this.projectName = projectName;
    }

    public void newProject() {
        new LinkOperator().clickLink(Elements.PROJECT_LINK);
        new ButtonOperator().clickButton(Elements.CREATE_PROJECT_BUTTON);
        new TextInputOperator().insertInput(Elements.PROJECT_NAME, projectName);
        new AreaTextOperator().textAreaInput(Elements.PROJECT_DESCRIPTION, Strings.PROJECT_DESCRIPTION);
        new TextInputOperator().insertInput(Elements.PROJECT_URL, Strings.PROJECT_URL);
        new TextInputOperator().insertInput(Elements.PROJECT_ISSUE_URL, Strings.PROJECT_ISSUE_URL);
        new SubmitOperator().submit();
    }
}
