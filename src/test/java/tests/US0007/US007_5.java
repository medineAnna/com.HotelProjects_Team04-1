package tests.US0007;

import org.openqa.selenium.WebElement;
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

public class US007_5 extends TestBaseRapor {
    Actions actions = new Actions(Driver.getDriver());
    HMCMainPage hmcMainPage=new HMCMainPage();
    SoftAssert softAssert;
    HotelMyCampPage hotelMyCampPage=new HotelMyCampPage();

    @Test
    public void hotelRoomsSayfayaTiklanincaSayfaninAktifOldugunaDairTest() {
        extentTest=extentReports.createTest("HotelRooms Sayfaya Tiklaninca Sayfanin Aktif Olduguna Dair Test","HotelRooms Sayfaya Tiklaninca Sayfanin Aktif Olduguna Dair Test Edildi");
        hmcMainPage.anaSayfayaGit();
        hotelMyCampPage. yoneticiOlarakGirisYap2();
        hmcMainPage.  hotelManagementElementi.click();
        hmcMainPage.   hotelRoomsElementi.click();
//Tablo basliklarini Kontrol eder ve Yazdirir
        for (WebElement each :hmcMainPage.theaderTabloBasliklariElementi) {
            Assert.assertTrue(each.isDisplayed(), "Tablo Basliklari FAILED");
            System.out.print(each.getText() + " ,");
        }
        System.out.println();
//Tablodaki 10. Satir 5. sutun Data Bilgisini Yazdirir
        Assert.assertTrue(hotelMyCampPage.hotelRoomsIlkSayfaWebTables(10, 5).isEnabled(), "1. Sayfa Web 10 satir 5. Sutun Bilgisi Gorunmuyor FAILED");
        System.out.println("webTableIstediginSutunuYazdir =>>" +hotelMyCampPage.hotelRoomsIlkSayfaWebTables(10, 5).getText());
        ReusableMethods.waitFor(3);
        actions.moveToElement(hotelMyCampPage.managerDropDownButton).perform();
        ReusableMethods.waitFor(2);
        hotelMyCampPage.logOutButton.click();
        extentTest.pass("Hotel Rooms Sayfaya Tiklaninca Sayfanin Aktif Olduguna Dair Test Basariyla TAMAMLANDI :)");
        //hotelMyCampPage.closeTheWindow();
    }
}
