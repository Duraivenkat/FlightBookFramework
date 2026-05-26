package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FlightListPage;
import pages.HomePage;
import pages.PurchasePage;

public class FlightSelectionTest extends BaseTest {

    @Test
    public void selectFlightTest() {

        HomePage homePage = new HomePage(driver);

        homePage.searchFlight("Boston", "London");

        FlightListPage flightListPage =
                new FlightListPage(driver);

        Assert.assertTrue(
                flightListPage.isFlightPageDisplayed());

        flightListPage.chooseFirstFlight();

        PurchasePage purchasePage =
                new PurchasePage(driver);

        Assert.assertTrue(
                purchasePage.isPurchasePageDisplayed());

        System.out.println(
                purchasePage.getFlightPrice());
    }
}