package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    public static ExtentReports extent;

    public static ExtentReports getInstance() {

        if(extent == null) {

            ExtentSparkReporter spark =
                    new ExtentSparkReporter(
                            "reports/ExtentReport.html");

            spark.config().setReportName(
                    "Flight Booking Automation Report");

            spark.config().setDocumentTitle(
                    "Automation Test Results");

            spark.config().setTheme(
                    com.aventstack.extentreports.reporter.configuration.Theme.DARK);

            extent = new ExtentReports();

            extent.attachReporter(spark);

            extent.setSystemInfo(
                    "Framework", "Selenium-TestNG");

            extent.setSystemInfo(
                    "Tester", "Team FlightBook");

            extent.setSystemInfo(
                    "Browser", "Chrome");
        }

        return extent;
    }
}