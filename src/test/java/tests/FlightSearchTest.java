package tests;

import base.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;

public class FlightSearchTest extends BaseTest {

    @DataProvider(name = "flightData")
    public Object[][] getData() {

        return new Object[][] {

                {"Boston", "London"},
                {"Paris", "Rome"},
                {"Philadelphia", "Berlin"}
        };
    }

    @Test(dataProvider = "flightData")
    public void searchFlightTest(String from, String to) {

        HomePage homePage = new HomePage(driver);

        homePage.searchFlight(from, to);
    }
}