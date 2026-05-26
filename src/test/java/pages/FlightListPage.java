package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlightListPage extends BasePage {

    WebDriver driver;

    public FlightListPage(WebDriver driver) {

        super(driver);

        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "table tbody tr:nth-child(1) input")
    WebElement chooseFlightButton;

    @FindBy(tagName = "h3")
    WebElement flightsHeader;

    public boolean isFlightPageDisplayed() {

        waitForElement(flightsHeader);

        return flightsHeader.isDisplayed();
    }

    public void chooseFirstFlight() {

        chooseFlightButton.click();
    }
}