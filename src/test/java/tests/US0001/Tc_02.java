package tests.US0001;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.pagesUS0001.HotelMyCampPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class Tc_02 extends TestBaseRapor {

    @Test
    public void tc02() {

        // url e gidilir
        // anasayfaya gidilir
        // gorunurlugu test edilir
        extentTest=extentReports.createTest("US001TC02",
                "Anasayfa gorunurlugu test edildi");


        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
        extentTest.info("URL e gidildi.");
        // home kisminin gorunurlugunu test et
        // home kismina tikla
        HotelMyCampPage hotelMyCampPage = new HotelMyCampPage();
        Assert.assertTrue(hotelMyCampPage.navHomeButton.isDisplayed());
        hotelMyCampPage.navHomeButton.click();
        extentTest.info("Home butonuna tiklandi");
        // rooms kisminin gorunurlugunu test et
        // rooms kismina tikla
        Assert.assertTrue(hotelMyCampPage.navRoomsButton.isDisplayed());
        hotelMyCampPage.navRoomsButton.click();
        extentTest.info("Room kismi ve butonu kontrol edildi.");


        Assert.assertTrue(hotelMyCampPage.navRestaurantButton.isDisplayed());
        hotelMyCampPage.navRestaurantButton.click();
        extentTest.pass("restaurant kisminin gorunurlugunu test edildi.");

        // about kisminin gorunurlugunu test et
        // about kismina tikla
        Assert.assertTrue(hotelMyCampPage.navAboutButton.isDisplayed());
        hotelMyCampPage.navAboutButton.click();
        extentTest.pass("about kisminin gorunurlugunu test edildi");
        // blog kisminin gorunurlugunu test et
        // blog kismina tikla
        Assert.assertTrue(hotelMyCampPage.navBlogButton.isDisplayed());
        hotelMyCampPage.navBlogButton.click();
        extentTest.info("blog kismina gidildi.");
        extentTest.pass("blog kismi test edildi.");
        // contact kisminin gorunurlugunu test et
        // contact kismina tikla
        Assert.assertTrue(hotelMyCampPage.navContactButton.isDisplayed());
        hotelMyCampPage.navContactButton.click();
        extentTest.info("contact kismina gidildi.");
        extentTest.pass("contact kismi test edildi.");
        // log in kisminin gorunurlugunu test et
        // log in kismina tikla
        Assert.assertTrue(hotelMyCampPage.navLoginButton.isDisplayed());
        hotelMyCampPage.navLoginButton.click();

        extentTest.info("log in kismina gidildi.");
        extentTest.pass("log in kismi test edildi.");
        // sayfa kapatildi
        Driver.closeDriver();








    }
}
