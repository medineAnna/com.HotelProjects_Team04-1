package tests.US0004;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.OrtakHMCPageBurayiSakinKurcalama.HMCMainPage;
import pages.pagesUS0004.HMCHotelListPage;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC003 extends TestBaseRapor {
    @Test
    public void US4TC3() {
        extentTest=extentReports.createTest("US004TC03","\"Create Hotel\" formunun gecerli bilgilerle doldurulabilir oldugu test edilmistir.");
        HMCMainPage hmcMainPage = new HMCMainPage();
        HMCHotelListPage hmcHotelListPage = new HMCHotelListPage();
        //1- Yonetici url e gider.
        hmcMainPage.anaSayfayaGit();
        extentTest.info("Sayfaya girildi");
        //2- Login butonunu tiklar.
        //3- Yonetici kendisine verilen username ve password ile giris yapar.
        hmcMainPage.yoneticiOlarakGirisYap();
        extentTest.info("Yonetici olarak giris yapildi");
        //4- "Hotel management" kismina tiklar.
        hmcMainPage.hotelManagementElementi.click();
        extentTest.info("Hotel Management'a tiklandi");
        //5- Gorunur hale gelen "Hotel List" kismina tiklar.
        ReusableMethods.waitFor(3);
        hmcHotelListPage.HotelListElementi.click();
        extentTest.info("\"Hotel List\" sayfasina girildi");
        //6- "Add Hotel" butonuna tiklar.
        hmcHotelListPage.AddHotelButtonElementi.click();
        extentTest.info("\"Add Hotel\" butonuna basildi");

        //7- formun gecerli bilgilerle doldurulabilir oldugunu gorur.

       Assert.assertTrue(
               hmcHotelListPage.AddHotelCodeTextBoxElementi.isEnabled() &&
               hmcHotelListPage.AddHotelNameTextBoxElementi.isEnabled() &&
               hmcHotelListPage.AddHotelAddressTextBoxElementi.isEnabled() &&
               hmcHotelListPage.AddHotelEmailTextBoxElementi.isEnabled() &&
               hmcHotelListPage.AddHotelPhoneTextBoxElementi.isEnabled() &&
                       hmcHotelListPage.AddHotelDropdownElementi.isEnabled()
               );
extentTest.pass("\"Create Hotel\" formu gecerli bilgilerle DOLDURULABILIR");
        Driver.closeDriver();
    }
}