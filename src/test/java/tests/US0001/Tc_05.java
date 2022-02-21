package tests.US0001;


import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.pagesUS0001.HotelMyCampPage;
import utilities.ConfigReader;
import utilities.Driver;

public class Tc_05 {
    @Test
            public void tc05Testi() {


        //1-kullanici url e gider
        HotelMyCampPage hotelMyCamHpPage = new HotelMyCampPage();
        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));

        //2-Sayfayi asagi dogru kaydirir

        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).perform();

        //3-Kullanici  instegram fotolarina tiklar
        Assert.assertTrue(hotelMyCamHpPage.InstagramFoto.isDisplayed());
        hotelMyCamHpPage.InstagramFoto.click();

        Driver.closeDriver();












    }
}
