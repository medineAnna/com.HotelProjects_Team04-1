package tests.US0007;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.OrtakHMCPageBurayiSakinKurcalama.HMCMainPage;
import pages.pagesUS0007.HotelMyCampPage;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US007_4 extends TestBaseRapor {

    Actions actions = new Actions(Driver.getDriver());
    HMCMainPage hmcMainPage=new HMCMainPage();
    SoftAssert softAssert;
    HotelMyCampPage hotelMyCampPage=new HotelMyCampPage();


    @Test
    public void hotelManagementAndHotelRoomsGozukuyorveAktifmiTesti() {
        extentTest=extentReports.createTest("HotelManagement And HotelRooms Gozukuyor ve Aktif mi Testi","HotelManagement And HotelRooms Gozukuyor ve Aktifmi Test Edildi");
        hmcMainPage.anaSayfayaGit();
// 4-)Yonetici olarakHotelManagement Gorunur Aktifmi
        hmcMainPage.  yoneticiOlarakGirisYap();
        Assert.assertTrue(hmcMainPage.hotelManagementElementi.isDisplayed(), "Hotel Management Butonu Gozukmuyor FAILED");
        Assert.assertTrue(hmcMainPage.hotelManagementElementi.isEnabled(), "Hotel Management Butonu Aktif DEGIL FAILED");
        hmcMainPage. hotelManagementElementi.click();
        ReusableMethods.waitForVisibility(hmcMainPage.hotelRoomsElementi,20);
// HotelRoms Gorunur Aktifmi
        Assert.assertTrue(hmcMainPage.hotelRoomsElementi.isDisplayed(), "Hotel Rooms Gozukmuyor FAILED");
        Assert.assertTrue(hmcMainPage.hotelRoomsElementi.isEnabled(), "Hotel Rooms Aktif DEGIL FAILED");
        ReusableMethods.waitFor(5);
        extentTest.pass("HotelManagement And HotelRooms Gozukuyor ve Aktif mi Testi Basariyla TAMAMLANDI :)");
       // hotelMyCampPage.closeTheWindow();
    }

}
