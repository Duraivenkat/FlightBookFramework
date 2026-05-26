package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PurchasePage extends BasePage {

    WebDriver driver;

    public PurchasePage(WebDriver driver) {

        super(driver);

        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    @FindBy(tagName = "h2")
    WebElement purchaseHeader;

    @FindBy(xpath = "//p[contains(text(),'Price')]")
    WebElement flightPrice;

    public boolean isPurchasePageDisplayed() {

        waitForElement(purchaseHeader);

        return purchaseHeader.isDisplayed();
    }

    public String getFlightPrice() {

        return flightPrice.getText();
    }
}