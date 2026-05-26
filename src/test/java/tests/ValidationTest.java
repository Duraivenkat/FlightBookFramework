package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.FlightListPage;
import pages.HomePage;
import pages.PurchasePage;
import utilities.RetryAnalyzer;

public class ValidationTest extends BaseTest {

    @Test(retryAnalyzer =
            RetryAnalyzer.class)

    public void emptyNameValidationTest() {

        HomePage homePage =
                new HomePage(driver);

        homePage.searchFlight(
                "Boston",
                "London");

        FlightListPage flightListPage =
                new FlightListPage(driver);

        flightListPage.chooseFirstFlight();

        PurchasePage purchasePage =
                new PurchasePage(driver);

        purchasePage.fillPurchaseForm();
    }
}