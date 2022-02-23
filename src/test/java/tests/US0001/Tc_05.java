package tests.US0001;


import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.pagesUS0001.HotelMyCampPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class Tc_05 extends TestBaseRapor {
    @Test
            public void tc05Testi() {
        extentTest=extentReports.createTest("US001TC05",
                "Instagram hesabina erisim test edildi");


        //1-kullanici url e gider
        HotelMyCampPage hotelMyCamHpPage = new HotelMyCampPage();
        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
        extentTest.info("URL e gidildi.");
        //2-Sayfayi asagi dogru kaydirir

        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).perform();
        extentTest.info("sayfada en asagiya gidildi.");
        //3-Kullanici  instagram fotolarina tiklar
        Assert.assertTrue(hotelMyCamHpPage.InstagramFoto.isDisplayed());
        hotelMyCamHpPage.InstagramFoto.click();
        extentTest.pass("Instagram hesabina erisim test edildi");
        Driver.closeDriver();












    }
}
