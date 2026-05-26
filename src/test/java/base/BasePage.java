package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ConfigReader;

import java.time.Duration;

public class BasePage {

    WebDriver driver;

    WebDriverWait wait;

    public BasePage(WebDriver driver) {

        this.driver = driver;

        wait = new WebDriverWait(driver,
                Duration.ofSeconds(ConfigReader.getTimeout()));
    }

    public void waitForElement(WebElement element) {

        wait.until(ExpectedConditions.visibilityOf(element));
    }
}