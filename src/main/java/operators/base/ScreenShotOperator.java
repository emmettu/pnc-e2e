package operators.base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

/**
 * Created by eunderhi on 09/09/15.
 */
public class ScreenShotOperator extends Operator {

    String SCREENSHOT_DIR = "./screenshots";

    public void takeScreenshot() {
        File image = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        copyImageToScreenShotsDir(image);
    }

    private void copyImageToScreenShotsDir(File image) {
        String currentURL = driver.getCurrentUrl().replace('/', '!') + ".png";
        try {
            FileUtils.copyFile(image, new File(SCREENSHOT_DIR, currentURL));
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
}
