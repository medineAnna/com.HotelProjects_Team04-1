package tests.US0001;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.pagesUS0001.HotelMyCampPage;
import utilities.ConfigReader;
import utilities.Driver;

public class Tc_01 {
    @Test
    public void tc01Testi(){

     // kullanici url e gider
        Driver.getDriver().get("https://www.hotelmycamp.com");

        // url in dogrulugu test edilir
        String actualurl=Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualurl.contains("hotelmycamp"));
        Driver.closeDriver();

    }
}


