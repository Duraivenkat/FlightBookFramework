package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage extends BasePage {

    WebDriver driver;

    public ConfirmationPage(WebDriver driver) {

        super(driver);

        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    @FindBy(tagName = "h1")
    WebElement thankYouMessage;

    @FindBy(xpath = "//td[contains(text(),'Id')]")
    WebElement bookingId;

    public boolean isThankYouMessageDisplayed() {

        waitForElement(thankYouMessage);

        return thankYouMessage.isDisplayed();
    }

    public boolean isBookingIdDisplayed() {

        return bookingId.isDisplayed();
    }
}