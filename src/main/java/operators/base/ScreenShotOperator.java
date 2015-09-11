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
    String FAIL_DIR = SCREENSHOT_DIR + "/fail";
    String SUCCEED_DIR = SCREENSHOT_DIR + "/succeed";

    public ScreenShotOperator(String name) {
        super(name);
    }

    public void takeFailScreenShot() {
        takeScreenshot(FAIL_DIR);
    }

    public void takeSucceedScreenShot() {
        takeScreenshot(SUCCEED_DIR);
    }

    public void takeScreenshot(String directory) {
        File image = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        copyImageToScreenShotsDir(image, directory);
    }

    private void copyImageToScreenShotsDir(File image, String directory) {
        name += ".png";
        try {
            FileUtils.copyFile(image, new File(directory, name));
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
}
