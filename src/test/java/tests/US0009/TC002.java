package tests.US0009;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.OrtakHMCPageBurayiSakinKurcalama.HMCMainPage;
import pages.US0009.US009Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC002  extends TestBaseRapor {
//1-yonetici url e gider
//2-yonetici olarak giris yapar
//3-"Hotel Manahement" 'e click yapar "Rom Reservation"  linkini gorur
//4-"Rom reservaton" linkine tiklar
//5- "List of Reservation" tablosunu gorur
    HMCMainPage hmcMainPage;
    US009Page us009Page;
    @Test
    public void roomReservation() {
        extentTest=extentReports.createTest("US0009_TC02", "Room Reservation Test");

        hmcMainPage=new HMCMainPage();
        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));

        extentTest.info("HotelMyCamp sayfasina gidildi");
        hmcMainPage.ilkLoginElementi.click();
        extentTest.info("ilk login elementine tiklandi");
        hmcMainPage.userNameBox.sendKeys(ConfigReader.getProperty("HMCValidUsername"));
        hmcMainPage.passwordBox.sendKeys(ConfigReader.getProperty("HMCValidPassword"));
        hmcMainPage.idveSifreyeGirLoginButonu.click();
        extentTest.info("yonetici olarak giris yapildi");
        us009Page = new US009Page();
        hmcMainPage.hotelManagementElementi.click();
        extentTest.info("Hotel Management Elementi gorundu");

        Assert.assertTrue( us009Page.roomReservationButton.isEnabled());

        extentTest.info("Rom reservation elementi gorundu ");

        us009Page.roomReservationButton.click();
        extentTest.pass("Rom reservation sayfasina gidildi");

    }

}