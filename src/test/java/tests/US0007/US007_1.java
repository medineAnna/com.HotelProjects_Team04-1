package tests.US0007;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.OrtakHMCPageBurayiSakinKurcalama.HMCMainPage;
import pages.pagesUS0007.HotelMyCampPage;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US007_1 extends TestBaseRapor {
    Actions actions = new Actions(Driver.getDriver());
    HMCMainPage hmcMainPage=new HMCMainPage();
    SoftAssert softAssert;
    HotelMyCampPage hotelMyCampPage=new HotelMyCampPage();

    @Test
    public void hotelMyCampUrlTesti() {

        extentTest=extentReports.createTest("HotelMyCamp Url Testi","HMC Url Test Edildi");
        hmcMainPage.anaSayfayaGit();
        extentTest.info("HMC Sayfasina Gidildi");
        String actualHMCUrl = Driver.getDriver().getCurrentUrl();
        String expectedHMCUrl = "https://www.hotelmycamp.com/";
        softAssert = new SoftAssert();
//1-)Yonetici URL'ye Gider Url in Dogru ve Acilir Oldugunu Gorur
        softAssert.assertEquals(actualHMCUrl, expectedHMCUrl, "HMC Url FAILED!!!");
        extentTest.info("HMC Sayfasi URL Testi Yapildi");
        softAssert.assertAll();

        ReusableMethods.waitFor(5);
        extentTest.pass("URL Adresi Dogrulandi Testi  Basariyla TAMAMLANDI :)");
        //hotelMyCampPage.closeTheWindow();//adas

    }

}

