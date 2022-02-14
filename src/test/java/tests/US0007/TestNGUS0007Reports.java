package tests.US0007;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.OrtakHMCPageBurayiSakinKurcalama.HMCMainPage;
import pages.pagesUS0007.HotelMyCampPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;
import java.util.List;

public class TestNGUS0007Reports extends TestBaseRapor {
    Actions actions = new Actions(Driver.getDriver());
    HMCMainPage hmcMainPage=new HMCMainPage();
    SoftAssert softAssert;
    HotelMyCampPage hotelMyCampPage=new HotelMyCampPage();
    @BeforeMethod
    public void AanaSayfaGiris() {
        hmcMainPage.anaSayfayaGit();
    }

    @Test
    public void BhotelMyCampUrlTesti() {
        extentTest=extentReports.createTest("HotelMyCamp Url Testi","HMC Url Test Edildi");
        extentTest.info("HMC Sayfasina Gidildi");
        String actualHMCUrl = Driver.getDriver().getCurrentUrl();
        String expectedHMCUrl = "https://www.hotelmycamp.com/";
        softAssert = new SoftAssert();
//1-)Yonetici URL'ye Gider Url in Dogru ve Acilir Oldugunu Gorur
        softAssert.assertEquals(actualHMCUrl, expectedHMCUrl, "HMC Url FAILED!!!");
        extentTest.info("HMC Sayfasi URL Testi Yapildi");
        softAssert.assertAll();
        extentTest.pass("URL Adresi Dogrulandi Testi  Basariyla TAMAMLANDI :)");
    }

    @Test
    public void CilkLoginButonuGorunurveAktifmiTesti() {
        extentTest=extentReports.createTest("Ilk Login Butonu Gorunur ve Aktif mi Testi","ilkLogin Butonu Gorunur ve Aktifmi Test Edildi");

// 2-)Yonetici Login Butonunun Gorunur Aktif  Oldugunu Kontrol Eder
// ve Tiklayip  onceden belirlenen sifreyle giris yapar.
        Assert.assertTrue(hmcMainPage.ilkLoginElementi.isDisplayed(), "Ilk Anasayfa Login Butonu GORUNUR  DEGIL");
        Assert.assertTrue(hmcMainPage.ilkLoginElementi.isEnabled(), "Ilk Anasayfa Login Butonu AKTIF  DEGIL");
        ReusableMethods.waitFor(3);
        extentTest.pass("Ilk Login Butonu Gorunur ve Aktif mi Testi Basariyla TAMAMLANDI :)");
    }

    @Test
    public void DsayfayaSifreyleGirisYapildiginaDairTest() {
        extentTest=extentReports.createTest("Sayfaya Sifreyle Giris Yapildigina Dair Test","Sayfaya Sifreyle Giris Yapildigina Dair Test Edildi");
        extentTest.info("HMC Sayfasina Gidildi");
//3-) Yonetici Onceden Belirlenen Sifreyle Giris Yaptigini Teyit Eder
//Ve Yonetici Hotel Management (DD) Aktif Oldugunu Teyit Eder
        hmcMainPage. ilkLoginElementi.click();
        Assert.assertTrue(hmcMainPage.sifreGirmeSayfasiCategories.isDisplayed(), "ilk Login Butonuna Tiklanamadi FAILED");
        hmcMainPage.userNameBox.sendKeys(ConfigReader.getProperty("HMCValidUsername"));
        hmcMainPage. passwordBox.sendKeys(ConfigReader.getProperty("HMCValidPassword"));
        hmcMainPage. idveSifreyeGirLoginButonu.click();
        Assert.assertTrue(hmcMainPage.yoneticiOlarakGirisYapilincaCikanListOfUsersElementi.isDisplayed(), "Yonetici Olarak Sayfaya Giris Yapilamadi FAILED");
        ReusableMethods.waitFor(3);
        extentTest.pass("Sayfaya Sifreyle Giris Yapildigina Dair Test Basariyla TAMAMLANDI :)");
    }

    @Test
    public void EhotelManagementAndHotelRoomsGozukuyorveAktifmiTesti() {
        extentTest=extentReports.createTest("HotelManagement And HotelRooms Gozukuyor ve Aktif mi Testi","HotelManagement And HotelRooms Gozukuyor ve Aktifmi Test Edildi");
// 4-)Yonetici olarakHotelManagement Gorunur Aktifmi
        hmcMainPage.  yoneticiOlarakGirisYap();
        Assert.assertTrue(hmcMainPage.hotelManagementElementi.isDisplayed(), "Hotel Management Butonu Gozukmuyor FAILED");
        Assert.assertTrue(hmcMainPage.hotelManagementElementi.isEnabled(), "Hotel Management Butonu Aktif DEGIL FAILED");
        hmcMainPage. hotelManagementElementi.click();
        ReusableMethods.waitForVisibility(hmcMainPage.hotelRoomsElementi,20);
// HotelRoms Gorunur Aktifmi
        Assert.assertTrue(hmcMainPage.hotelRoomsElementi.isDisplayed(), "Hotel Rooms Gozukmuyor FAILED");
        Assert.assertTrue(hmcMainPage.hotelRoomsElementi.isEnabled(), "Hotel Rooms Aktif DEGIL FAILED");
        ReusableMethods.waitFor(3);
        extentTest.pass("HotelManagement And HotelRooms Gozukuyor ve Aktif mi Testi Basariyla TAMAMLANDI :)");
    }

    @Test
    public void FhotelRoomsSayfayaTiklanincaSayfaninAktifOldugunaDairTest() {
        extentTest=extentReports.createTest("HotelRooms Sayfaya Tiklaninca Sayfanin Aktif Olduguna Dair Test","HotelRooms Sayfaya Tiklaninca Sayfanin Aktif Olduguna Dair Test Edildi");
// 5-)Yonetici Hotel Roomsa Tiklar
        hmcMainPage.  yoneticiOlarakGirisYap();
        hmcMainPage.  hotelManagementElementi.click();
        hmcMainPage.   hotelRoomsElementi.click();
//Tablo basliklarini Kontrol eder ve Yazdirir
        for (WebElement each :hmcMainPage.theaderTabloBasliklariElementi) {
            Assert.assertTrue(each.isDisplayed(), "Tablo Basliklari FAILED");
            System.out.print(each.getText() + " ,");
        }
//Tablodaki 10. Satir 5. sutun Data Bilgisini Yazdirir
        Assert.assertTrue(hotelMyCampPage.hotelRoomsIlkSayfaWebTables(10, 5).isEnabled(), "1. Sayfa Web 10 satir 5. Sutun Bilgisi Gorunmuyor FAILED");
        System.out.println("webTableIstediginSutunuYazdir =>>" +hotelMyCampPage.hotelRoomsIlkSayfaWebTables(10, 5).getText());
        ReusableMethods.waitFor(3);
        extentTest.pass("Hotel Rooms Sayfaya Tiklaninca Sayfanin Aktif Olduguna Dair Test Basariyla TAMAMLANDI :)");
    }

    @Test
    public void GwebTablein5SayfadakiBilgilereErismeTesti() throws IOException {
        extentTest=extentReports.createTest("Web Table'in 5. Sayfadaki Bilgilere Erisme Testi","Web Table'in 5. Sayfadaki Bilgilere Erismesi Test Edildi ");
//6-)Web Table 5.Tablo Sayfasi Bilgilerine Eristigini Screen Shot la Teyit Et
        hotelMyCampPage. hotelRoomsWebTablinIsteginSayfasinaGit(5);
//ReusableMethods.getScreenshot("WebTable5.SayfaGoruntusu");
        ReusableMethods.waitFor(3);
        extentTest.pass("Web Table'in 5. Sayfadaki Bilgilere Erisme Testi Basariyla TAMAMLANDI :)");
    }

    @Test
    public void HwebTable5inciSayfa10SatirDetailsvePropertieseGirisTesti() {
        extentTest=extentReports.createTest("WebTable 5. Sayfa 10. Satir Details ve Propertiese Giris Testi","WebTable 5. Sayfa 10. Satir Details ve Propertiese Giris Test Edildi");
//  7-) //WebTable 5. safya 10. Satir daki Details Butonunun
//  Erisilebilir Oldugunu Kontrol Ederek
//  Details Butonuna Tikla ve Tiklandigini Kontrol Et
        hotelMyCampPage.hotelRoomsWebTablinIsteginSayfasinaGit(5);
//WebTable 5. sayfa 10.satirdaki detailse tikla
        Assert.assertTrue(hotelMyCampPage.hotelRoomsIlkSayfaWebTables(10, 9).isEnabled(), "WebTables 5. sayfa 10. satirdaki Details Butonuna ERISILEMIYOR FAILED");
        ReusableMethods.waitFor(2);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(2);
        hotelMyCampPage. webTableSayfasindakiIsteginDetailsButonunaDirekTikla(10, 9);
//edit hotel Room yazisi Elementi gorunuyormu
        Assert.assertTrue(hmcMainPage.editHotelRoomYaziElementi.isEnabled(), "WebTable 5. sayfa 10 satir details Butonuna Tiklanamadi FAILED");
//Propertiese Tiklandi testi yap
        hmcMainPage.propertiesSekmesiElementi.click();
        Assert.assertTrue(hmcMainPage.addPropertyYaziElementi.isEnabled());
        ReusableMethods.waitFor(3);
        extentTest.pass("WebTable 5. Sayfa 10.Satir Details ve Propertiese Giris Testi Basariyla TAMAMLANDI :)");
    }

    @Test

    public void IphotosSayfasinaGirisTesti() {
//8
        extentTest=extentReports.createTest("Photos Sayfasina Giris Testi","Photos Sayfasina Giris Test Edildi");
        hotelMyCampPage.direkPhotostSayfasinaGit();
        Assert.assertTrue(hmcMainPage.upLoadFilesElementi.isEnabled());
        ReusableMethods.waitFor(3);
        extentTest.pass("Photos Sayfasina Giris Testi Basariyla TAMAMLANDI :)");
    }


    @Test
    public void JpropertiesSayfasiErisimTesti() {
        extentTest=extentReports.createTest("Properties Sayfasi Erisim Testi","Properties Sayfasi Erisim Test Edildi ");
//9
        hotelMyCampPage.direkPropertiesSayfasinaGit();
        Select select = new Select(hmcMainPage.propertiesdekiTipDropDownElementi);
// Propertiesde Girdigimizi Kontrol Icin Tip DD leri yazdiriniz
        List<WebElement> tipDDElementi = select.getOptions();
        for (WebElement each : tipDDElementi) {
            System.out.print("Tip DD Listesi =>" + each.getText() + " ");
            ReusableMethods.waitFor(3);
        }
        extentTest.pass("Properties Sayfasi Erisim Testi Basariyla TAMAMLANDI :)");
    }
    @Test
//10
    public void KodaBilgileriGuncellemeTesti(){
        extentTest=extentReports.createTest("Oda Bilgileri Guncelleme Testi","Oda Bilgileri Guncelleme Test Edildi ");
        hotelMyCampPage.direkGeneralDataSayfasinaGit();
        hotelMyCampPage. hotelRoomGuncellemeDatasiGonderme("0007","MustafaDRoom1",
                "Muslihittin mah. No:48  Afrika ",
                "Huzurlu ve Mutlu tatilin adresi",
                "500.000","5","1");
        Assert.assertTrue(hotelMyCampPage.generalDataRoomsUpdateText.isDisplayed(),"Room Guncellenemedi FAILED");
        hotelMyCampPage.generalDataUpdateOKButonElementi.click();
        Driver.getDriver().navigate().back();
        hotelMyCampPage.listOfHotelRoomsNameBoxDataPush("MustafaDRoom1");
        hotelMyCampPage.listOfHotelRoomsyellowSearchButton.click();
        ReusableMethods.waitFor(3);
        String actualText=hotelMyCampPage.listOfHotelRoomsNameElementi.getText();
        WebElement odaKayitNameYazisi=Driver.getDriver().findElement(By.xpath("//td[.='MustafaDRoom1']"));
        Assert.assertTrue(odaKayitNameYazisi.isDisplayed(),"Oda Kaydi Basarisiz");
        ReusableMethods.waitFor(3);
        extentTest.pass("Oda Bilgileri Guncelleme Testi Basariyla TAMAMLANDI :)");
    }

    @Test
    public void LodaBilgileriSilmeTesti() throws IOException {
        extentTest=extentReports.createTest(" Oda Bilgileri Silme Testi"," OdaBilgileri Silme Test Edildi");
//11
        hotelMyCampPage.direkGeneralDataSayfasinaGit();
        hotelMyCampPage.hotelRoomDeleteDatasiGonderme("0007","MustafaDRoom1",
                "Muslihittin mah. No:48  Afrika ",
                "Huzurlu ve Mutlu tatilin adresi",
                "500.000","5","1");
        hotelMyCampPage.generalDataSaveButonuElementi.click();
        hotelMyCampPage.generalDataUpdateOKButonElementi.click();
        ReusableMethods.waitFor(2);
        hotelMyCampPage.generalDataDeleteButonuElementi.click();
        ReusableMethods.waitFor(2);
        hotelMyCampPage.generalDataSaveClickOkButonu.click();
        hotelMyCampPage.endUserName.sendKeys(ConfigReader.getProperty("HMCValidUsername"));
        hotelMyCampPage.endPassword.sendKeys(ConfigReader.getProperty("HMCValidPassword"));
        hotelMyCampPage.endLogInButton.click();
        hotelMyCampPage.listOfHotelRoomsNameBoxDataPush("MustafaDRoom1");
        hotelMyCampPage.listOfHotelRoomsyellowSearchButton.click();
//ReusableMethods.getScreenshot("Oda Bilgileri Silindi Teyit Photos");
        ReusableMethods.waitFor(3);
        extentTest.pass("Oda Bilgileri Silme Testi Basariyla TAMAMLANDI :)");
    }
    @AfterMethod
    public void tearDown(){
        hotelMyCampPage.closeTheWindow();
    }
}
//        extentTest=extentReports.createTest("","");
//  extentTest.pass("HotelManagement And HotelRooms Gozukuyor ve Aktif mi Testi Yapilmistir");
//  extentTest.pass("");