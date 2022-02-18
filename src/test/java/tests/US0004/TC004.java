package tests.US0004;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.OrtakHMCPageBurayiSakinKurcalama.HMCMainPage;
import pages.pagesUS0004.HMCHotelListPage;
import utilities.TestBaseRapor;

public class TC004 extends TestBaseRapor {
    @Test
    public void US4TC4() {
        extentTest=extentReports.createTest("US004TC04","form icerisindeki drop down'in secilebilir oldugu test edildi");
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
        //6- "Add Hotel" butonuna tiklar.
        hmcHotelListPage.AddHotelButtonElementi.click();
        extentTest.info("\"Add Hotel\" butonuna basildi");
        //7- "create hotel" formu icerisindeki "ID Gruop" dropdown'ina tiklar.
        //8- Hotel Types opsiyonlarini gorur ve birine tiklar.
        Select select = new Select(hmcHotelListPage.AddHotelDropdownElementi);
        select.selectByIndex(2);
        extentTest.info("Hotel Type secildi");
        //9- Tiklamis oldugu type in secilmis oldugunu gorur.
        Assert.assertTrue(select.getFirstSelectedOption().isSelected());
        extentTest.pass("form icerisindeki drop down SECILDI");
    }
}