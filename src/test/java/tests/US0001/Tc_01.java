package tests.US0001;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.pagesUS0001.HotelMyCampPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class Tc_01 extends TestBaseRapor {
    @Test
    public void tc01Testi(){
        extentTest=extentReports.createTest("US001TC01",
                "URL dogrulugu test edildi");

        // kullanici url e gider
        Driver.getDriver().get("https://www.hotelmycamp.com");
extentTest.info("URL e gidildi.");
        // url in dogrulugu test edilir
        String actualurl=Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualurl.contains("hotelmycamp"));
        extentTest.pass("URL in dogru oldugu test edildi.");
        Driver.closeDriver();

    }
}


