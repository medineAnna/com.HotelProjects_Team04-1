package tests.US0004;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.OrtakHMCPageBurayiSakinKurcalama.HMCMainPage;
import pages.pagesUS0004.HMCHotelListPage;
import utilities.TestBaseRapor;

public class TC001 extends TestBaseRapor {
@Test
    public void US4TC1(){
    extentTest=extentReports.createTest("US004 TC01","\"Add Hotel\" butonunun gorunur ve erisilebilir oldugu test edilmistir.");

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
hmcHotelListPage.HotelListElementi.click();
    extentTest.info("\"Hotel List\" sayfasina girildi");
    //6- "Add Hotel" butonunu gorur.
    Assert.assertTrue(hmcHotelListPage.AddHotelButtonElementi.isDisplayed());
    extentTest.pass("\"Add Hotel\" butonu GORUNUR ");
    //7- "Add Hotel" butonuna erisebilir.
    Assert.assertTrue(hmcHotelListPage.AddHotelButtonElementi.isEnabled());
    extentTest.pass("\"Add Hotel\" butonu ERISILEBILIR ");
}

}
