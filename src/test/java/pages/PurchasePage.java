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

    @FindBy(id = "inputName")
    WebElement nameField;

    @FindBy(id = "address")
    WebElement addressField;

    @FindBy(id = "city")
    WebElement cityField;

    @FindBy(id = "state")
    WebElement stateField;

    @FindBy(id = "zipCode")
    WebElement zipCodeField;

    @FindBy(id = "creditCardNumber")
    WebElement creditCardField;

    @FindBy(css = "input[type='submit']")
    WebElement purchaseFlightButton;

    public boolean isPurchasePageDisplayed() {

        waitForElement(purchaseHeader);

        return purchaseHeader.isDisplayed();
    }

    public String getFlightPrice() {

        return flightPrice.getText();
    }
    public void fillPurchaseForm() {

        nameField.sendKeys("Durai");

        addressField.sendKeys("Chennai");

        cityField.sendKeys("Chennai");

        stateField.sendKeys("Tamil Nadu");

        zipCodeField.sendKeys("600001");

        creditCardField.sendKeys("123456789");

        purchaseFlightButton.click();
    }
}