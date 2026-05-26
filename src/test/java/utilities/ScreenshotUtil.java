package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {

    public static String captureScreenshot(
            WebDriver driver,
            String testName,
            String status) {

        String timestamp =
                new SimpleDateFormat("yyyyMMdd_HHmmss")
                        .format(new Date());

        String path =
                "screenshots/" + status + "/" +
                        testName + "_" + timestamp + ".png";

        TakesScreenshot ts =
                (TakesScreenshot) driver;

        File source =
                ts.getScreenshotAs(OutputType.FILE);

        File destination =
                new File(path);

        try {

            FileUtils.copyFile(source, destination);

        } catch (IOException e) {

            e.printStackTrace();
        }

        return destination.getAbsolutePath();
    }
}