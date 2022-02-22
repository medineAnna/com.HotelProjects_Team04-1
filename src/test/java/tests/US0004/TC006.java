package tests.US0004;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.OrtakHMCPageBurayiSakinKurcalama.HMCMainPage;
import pages.pagesUS0004.HMCHotelListPage;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;

public class TC006 extends TestBaseRapor {
    @Test
    public void US4TC6()  {
        extentTest=extentReports.createTest("US004TC06",
                "form gecersiz bilgilerle doldurulup Save edildiginde \"Hotel was " +
                        "inserted successfully\" yazisinin cikmadigi test edildi");



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
        //7- "create hotel" formunu gecersiz bilgiler ile doldurur.
        hmcHotelListPage.AddHotelFormDropdownaKadarGecersizDoldurma();
        Select select= new Select(hmcHotelListPage.AddHotelDropdownElementi);
        select.selectByIndex(1);
        extentTest.info("\"Create Hotel form\"'u gecersiz bilgilerle douduruldu");
        //8- Save butonuna tiklar.
        ReusableMethods.waitFor(2);
        hmcHotelListPage.AddHotelSaveButton.click();
        extentTest.info("\"Save\" butonuna basildi");
        //9- "Hotel was inserted successfully" yazisini gorunmez.
        ReusableMethods.waitForVisibility(hmcHotelListPage.AddHotelBasariliKayityazisiElementi,15);
        Assert.assertFalse(hmcHotelListPage.AddHotelBasariliKayityazisiElementi.isDisplayed());
        extentTest.pass("\"Hotel was inserted successfully\" yazisini GORULDU");
        Driver.closeDriver();
    }}
