package tests.US0001;


import org.apache.commons.math3.filter.KalmanFilter;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.pagesUS0001.HotelMyCampPage;
import utilities.ConfigReader;
import utilities.Driver;

public class Tc_04 {
    @Test
    public void tc_04_Testi(){

        //1-kullanici url e gider
        //2-Sayfayi asagi dogru kaydirir
        //"3-Kullanici her recent blok bolumunda, bloklarin
        //calisip calismadigini kontrol eder"
        //4-Kullanici resimlerin tiklanip tiklanmadigini kontol eder
        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
        HotelMyCampPage hotelMyCampPage = new HotelMyCampPage();

        //  recent blog daki  ilk fotograf ve texts in  gorunurlugu ve tiklanabilirligi test edilir

        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).perform();



        Assert.assertTrue(hotelMyCampPage.RecentBlocIlkfoto.isDisplayed());
        hotelMyCampPage.RecentBlocIlkfoto.click();


        //sayfa kapatilir
        Driver.closeDriver();

    }
}
