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
import utilities.TestBaseRapor;

public class Tc_04 extends TestBaseRapor {
    @Test
    public void Tc04Testi(){
        extentTest=extentReports.createTest("US001TC04",
                "Anasayfadaki resimlerin erisilebilirligi test edildi.");

        //1-kullanici url e gider
        //2-Sayfayi asagi dogru kaydirir
        //"3-Kullanici her recent blok bolumunda, bloklarin
        //calisip calismadigini kontrol eder"
        //4-Kullanici resimlerin tiklanip tiklanmadigini kontol eder
        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
        HotelMyCampPage hotelMyCampPage = new HotelMyCampPage();
        extentTest.info("URL e gidildi.");
        //  recent blog daki  ilk fotograf ve texts in  gorunurlugu ve tiklanabilirligi test edilir

        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).perform();

        extentTest.info("sayfada en asagiya gidildi.");

        Assert.assertTrue(hotelMyCampPage.RecentBlocIlkfoto.isDisplayed());
        hotelMyCampPage.RecentBlocIlkfoto.click();

        extentTest.pass("recent blog daki  ilk fotograf ve texts in  gorunurlugu ve tiklanabilirligi test edildi.");

        //sayfa kapatilir
        Driver.closeDriver();

    }
}
