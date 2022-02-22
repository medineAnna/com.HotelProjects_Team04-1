package tests.US0004;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.OrtakHMCPageBurayiSakinKurcalama.HMCMainPage;
import pages.pagesUS0004.HMCHotelListPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;


public class TC007 extends TestBaseRapor {

    @Test
    public void US4TC7() {
        extentTest=extentReports.createTest("US004TC07",
                "form gecerli bilgilerle doldurulup Save edildiginde Hotel list'e eklendigi test edildi");

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
        //7- "create hotel" formunu gecerli bilgiler ile doldurur.
        hmcHotelListPage.AddHotelFormDropdownaKadarGecerliDoldurma();
        Select select= new Select(hmcHotelListPage.AddHotelDropdownElementi);
        select.selectByIndex(1);
        ReusableMethods.waitFor(2);
        extentTest.info("\"Create Hotel form\"'u gecerli bilgilerle douduruldu");
        //8- Save butonuna tiklar.
        hmcHotelListPage.AddHotelSaveButton.click();
        extentTest.info("\"Save\" butonuna basildi");
        //9- "Hotel was inserted successfully" yazisini gorur.
        ReusableMethods.waitForVisibility(hmcHotelListPage.AddHotelBasariliKayityazisiElementi,15);
        Assert.assertTrue(hmcHotelListPage.AddHotelBasariliKayityazisiElementi.isDisplayed());
        extentTest.pass("\"Hotel was inserted successfully\" yazisini GORULDU");
        //Developer Hatasi 44. satir WebElement hic bir sekilde bulunamiyor
        ReusableMethods.waitForClickablility(hmcHotelListPage.AddHotelBasariliKayitOkButton,15);
        //10- OK butonuna tiklar.
        Assert.assertTrue(hmcHotelListPage.AddHotelBasariliKayitOkButton.isEnabled());
        extentTest.pass("\"OK\" butonun tiklanabilir oldugu GORULDU");
        hmcHotelListPage.AddHotelBasariliKayitOkButton.click();
        extentTest.info("\"OK\" butonuna basildi");

        //11- Yeniden "Hotel List" kismina tiklar.
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_UP).perform();
        ReusableMethods.waitFor(2);
        hmcHotelListPage.HotelListElementi.click();
        extentTest.info("\"Hotel List\" acildi");
        //12- Name sutunu altindaki Search textbox'a bir onceki adimda yazdigi hotel adini yazar.
hmcHotelListPage.HotelListSearchNameTextBox.sendKeys(ConfigReader.getProperty("hotelName"));
        //13- sag kosedeki search buttonuna tiklar.
        hmcHotelListPage.HotelListSearchButton.click();
        extentTest.info("search edildi");
        //14- Listede olusturdugu oteli gorur.
        Assert.assertFalse(hmcHotelListPage.FirstHotelAtSearchList.getText().isEmpty());
        extentTest.pass("Eklenen otel hotel listte GORULDU");
        Driver.closeDriver();
    }
}