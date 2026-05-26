package listeners;

import base.BaseTest;
import com.aventstack.extentreports.*;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utilities.ExtentManager;
import utilities.ScreenshotUtil;

public class TestListener
        implements ITestListener {

    ExtentReports extent =
            ExtentManager.getInstance();

    ExtentTest test;

    @Override
    public void onTestSuccess(
            ITestResult result) {

        test = extent.createTest(
                result.getName());

        WebDriver driver =
                ((BaseTest) result.getInstance()).driver;

        String path =
                ScreenshotUtil.captureScreenshot(
                        driver,
                        result.getName(),
                        "pass");

        test.pass("Test Passed");

        try {

            test.addScreenCaptureFromPath(path);

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    @Override
    public void onTestFailure(
            ITestResult result) {

        test = extent.createTest(
                result.getName());

        WebDriver driver =
                ((BaseTest) result.getInstance()).driver;

        String path =
                ScreenshotUtil.captureScreenshot(
                        driver,
                        result.getName(),
                        "fail");

        test.fail(result.getThrowable());

        try {

            test.addScreenCaptureFromPath(path);

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    @Override
    public void onFinish(
            ITestContext context) {

        extent.flush();
    }
}