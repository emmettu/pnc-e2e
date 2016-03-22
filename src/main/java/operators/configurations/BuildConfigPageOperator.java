package operators.configurations;

import operators.base.*;
import org.openqa.selenium.By;
import util.Credentials;
import util.Elements;
import util.Strings;

/**
 * Created by eunderhi on 10/09/15.
 */
public class BuildConfigPageOperator extends Operator {

    private String description = Strings.BUILD_CONFIGURATION_DESCRIPTION;
    private String scmURL = Strings.BUILD_CONFIGURATION_SCM_URL;
    private String scmRevision = Strings.BUILD_CONFIGURATION_SCM_REVISION;
    private String buildScript = Strings.BUILD_CONFIGURATION_BUILD_SCRIPT;
    private String environment = Strings.BUILD_CONFIGURATION_ENVIRONMENT;

    public BuildConfigPageOperator(String name) {
        super(name);
    }

    public void createBuildConfiguration() {
        new LinkOperator(Elements.BUILD_CONFIGURATION_LINK).clickLink();
        new LinkOperator(Elements.BUILD_CONFIGURATION_LINK).findLink(1).click(); //second link must be clicked since they have the same name.
        new ButtonOperator(Elements.CREATE_CONFIGURATION_BUTTON).clickButton();
        new TextInputOperator(Elements.BUILD_CONFIGURATION_INPUT).insertInput(name);
        new AreaTextOperator(Elements.BUILD_CONFIGURATION_DESCRIPTION).textAreaInput(description);
        new TextInputOperator(Elements.BUILD_CONFIGURATION_SCM_URL).insertInput(scmURL);
        new TextInputOperator(Elements.BUILD_CONFIGURATION_SCM_REVISION).insertInput(scmRevision);
        new AreaTextOperator(Elements.BUILD_CONFIGURATION_BUILD_SCRIPT).textAreaInput(buildScript);
        new TextInputOperator(Elements.BUILD_CONFIGURATION_ENVIRONMENT).insertInput(environment);
        driver.findElements(By.xpath("//li[contains(@class, 'dropdown-item')]")).get(0).click();
        new SubmitOperator().submit();
    }

    public void buildBuildConfiguration() {
        new LinkOperator(Elements.CONFIGURATION_LINK).clickLink();
        new LinkOperator(Elements.BUILD_CONFIGURATION_LINK).clickLink();
        new LinkOperator(name).clickLink();
        new BuildOperator().startBuild();
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setScmURL(String scmURL) {
        this.scmURL = scmURL;
    }

    public void setScmRevision(String scmRevision) {
        this.scmRevision = scmRevision;
    }

    public void setBuildScript(String buildScript) {
        this.buildScript = buildScript;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

}
