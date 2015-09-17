package operators.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by eunderhi on 17/09/15.
 */
public class SearchOperator extends Operator {

    public SearchOperator() {}

    public void search(String query) {
        String xpath = "//input[@ng-model='searchText']";
        WebElement searchBar =  driver.findElement(By.xpath(xpath));

        searchBar.click();
        searchBar.sendKeys(query);
    }

}
