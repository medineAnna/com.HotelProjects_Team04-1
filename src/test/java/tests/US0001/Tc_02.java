package tests.US0001;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.pagesUS0001.HotelMyCampPage;
import utilities.ConfigReader;
import utilities.Driver;

public class Tc_02 {

    @Test
    public void tc01() {

        // url e gidilir
        // anasayfaya gidilir
        // gorunurlugu test edilir


        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));

        // home kisminin gorunurlugunu test et
        // home kismina tikla
        HotelMyCampPage hotelMyCampPage = new HotelMyCampPage();
        Assert.assertTrue(hotelMyCampPage.navHomeButton.isDisplayed());
        hotelMyCampPage.navHomeButton.click();

        // rooms kisminin gorunurlugunu test et
        // rooms kismina tikla
        Assert.assertTrue(hotelMyCampPage.navRoomsButton.isDisplayed());
        hotelMyCampPage.navRoomsButton.click();


        // restaurant kisminin gorunurlugunu test et
        // restaurant kismina tikla
        Assert.assertTrue(hotelMyCampPage.navRestaurantButton.isDisplayed());
        hotelMyCampPage.navRestaurantButton.click();


        // abaut kisminin gorunurlugunu test et
        // abaut kismina tikla
        Assert.assertTrue(hotelMyCampPage.navAboutButton.isDisplayed());
        hotelMyCampPage.navAboutButton.click();

        // blog kisminin gorunurlugunu test et
        // blog kismina tikla
        Assert.assertTrue(hotelMyCampPage.navBlogButton.isDisplayed());
        hotelMyCampPage.navBlogButton.click();

        // contact kisminin gorunurlugunu test et
        // contact kismina tikla
        Assert.assertTrue(hotelMyCampPage.navContactButton.isDisplayed());
        hotelMyCampPage.navContactButton.click();

        // log in kisminin gorunurlugunu test et
        // log in kismina tikla
        Assert.assertTrue(hotelMyCampPage.navLoginButton.isDisplayed());
        hotelMyCampPage.navLoginButton.click();
        
        
        // sayfa kapatildi
        Driver.closeDriver();








    }
}
