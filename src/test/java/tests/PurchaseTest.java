package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ConfirmationPage;
import pages.FlightListPage;
import pages.HomePage;
import pages.PurchasePage;

public class PurchaseTest extends BaseTest {

    @Test
    public void purchaseFlightTest() {

        HomePage homePage =
                new HomePage(driver);

        homePage.searchFlight("Boston", "London");

        FlightListPage flightListPage =
                new FlightListPage(driver);

        flightListPage.chooseFirstFlight();

        PurchasePage purchasePage =
                new PurchasePage(driver);

        purchasePage.fillPurchaseForm();

        ConfirmationPage confirmationPage =
                new ConfirmationPage(driver);

        Assert.assertTrue(
                confirmationPage.isThankYouMessageDisplayed());

        Assert.assertTrue(
                confirmationPage.isBookingIdDisplayed());
    }
}