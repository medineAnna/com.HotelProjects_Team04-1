package tests;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.pagesUS0007.HotelMyCampPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;
import java.util.List;

public class HMCPozitftest {
    Actions actions = new Actions(Driver.getDriver());
    HotelMyCampPage hotelMyCampPage;
    SoftAssert softAssert;

    @BeforeMethod
    public void anaSayfaGiris() {
        hotelMyCampPage = new HotelMyCampPage();
        hotelMyCampPage.anaSayfayaGit();
    }

    @Test
    public void hotelMyCampUrlTesti() {
        String actualHMCUrl = Driver.getDriver().getCurrentUrl();
        String expectedHMCUrl = "https://www.hotelmycamp.com/";
        softAssert = new SoftAssert();
//1-)Yonetici URL'ye Gider Url in Dogru ve Acilir Oldugunu Gorur
        softAssert.assertEquals(actualHMCUrl, expectedHMCUrl, "HMC Url FAILED!!!");
        softAssert.assertAll();
    }

    @Test
    public void ilkLoginButonuGorunurveAktifmiTesti() {
// 2-)Yonetici Login Butonunun Gorunur Aktif  Oldugunu Kontrol Eder
// ve Tiklayip  onceden belirlenen sifreyle giris yapar.
        Assert.assertTrue(hotelMyCampPage.ilkLoginElementi.isDisplayed(), "Ilk Anasayfa Login Butonu GORUNUR  DEGIL");
        Assert.assertTrue(hotelMyCampPage.ilkLoginElementi.isEnabled(), "Ilk Anasayfa Login Butonu AKTIF  DEGIL");


    }

    @Test
    public void sayfayaSifreyleGirisYapildiginaDairTest() {
//3-) Yonetici Onceden Belirlenen Sifreyle Giris Yaptigini Teyit Eder
//Ve Yonetici Hotel Management (DD) Aktif Oldugunu Teyit Eder
        hotelMyCampPage.ilkLoginElementi.click();
        Assert.assertTrue(hotelMyCampPage.sifreGirmeSayfasiCategories.isDisplayed(), "ilk Login Butonuna Tiklanamadi FAILED");
        hotelMyCampPage.userNameBox.sendKeys(ConfigReader.getProperty("HMCValidUsername"));
        hotelMyCampPage.passwordBox.sendKeys(ConfigReader.getProperty("HMCValidPassword"));
        hotelMyCampPage.idveSifreyeGirLoginButonu.click();
        Assert.assertTrue(hotelMyCampPage.yoneticiOlarakGirisYapilincaCikanListOfUsersElementi.isDisplayed(), "Yonetici Olarak Sayfaya Giris Yapilamadi FAILED");
    }

    @Test
    public void hotelManagementAndHotelRoomsGozukuyorveAktifmiTesti() {
// 4-)Yonetici olarakHotelManagement Gorunur Aktifmi
        hotelMyCampPage.yoneticiOlarakGirisYap();
        Assert.assertTrue(hotelMyCampPage.hotelManagementElementi.isDisplayed(), "Hotel Management Butonu Gozukmuyor FAILED");
        Assert.assertTrue(hotelMyCampPage.hotelManagementElementi.isEnabled(), "Hotel Management Butonu Aktif DEGIL FAILED");
        hotelMyCampPage.hotelManagementElementi.click();
// HotelRoms Gorunur Aktifmi
        Assert.assertTrue(hotelMyCampPage.hotelRoomsElementi.isDisplayed(), "Hotel Rooms Gozukmuyor FAILED");
        Assert.assertTrue(hotelMyCampPage.hotelRoomsElementi.isEnabled(), "Hotel Rooms Aktif DEGIL FAILED");
    }

    @Test
    public void hotelRoomsSayfayaTiklanincaSayfaninAktifOldugunaDairTest() {
// 5-)Yonetici Hotel Roomsa Tiklar
        hotelMyCampPage.yoneticiOlarakGirisYap();
        hotelMyCampPage.hotelManagementElementi.click();
        hotelMyCampPage.hotelRoomsElementi.click();
        //Tablo basliklarini Kontrol eder ve Yazdirir


        for (WebElement each : hotelMyCampPage.theaderTabloBasliklariElementi) {
            Assert.assertTrue(each.isDisplayed(), "Tablo Basliklari FAILED");
            System.out.print(each.getText() + " ,");
        }
        //Tablodaki 10. Satir 5. sutun Data Bilgisini Yazdirir

        Assert.assertTrue(hotelMyCampPage.hotelRoomsIlkSayfaWebTables(10, 5).isEnabled(), "1. Sayfa Web 10 satir 5. Sutun Bilgisi Gorunmuyor FAILED");
        System.out.println("webTableIstediginSutunuYazdir =>>" + hotelMyCampPage.hotelRoomsIlkSayfaWebTables(10, 5).getText());


    }

    @Test
    public void webTablein5SayfadakiBilgilereErismeTEsti() throws IOException {
        //6-)Web Table 5.Tablo Sayfasi Bilgilerine Eristigini Screen Shot la Teyit Et

        hotelMyCampPage.yoneticiOlarakGirisYap();
        hotelMyCampPage.hotelManagementElementi.click();
        hotelMyCampPage.hotelRoomsElementi.click();
        hotelMyCampPage.direkWebTablinIsteginSayfasinaGit(5);
//ReusableMethods.getScreenshot("WebTable5.SayfaGoruntusu");
    }

    @Test
    public void webTable5inciSayfa10SatirDetailsvePropertieseGirisTesti() {
//  7-) //WebTable 5. safya 10. Satir daki Details Butonunun Erisilebilir Oldugunu Kontrol Ederek Details Butonuna Tikla ve Tiklandigini Kontrol Et

        hotelMyCampPage.direkWebTablinIsteginSayfasinaGit(5);
//WebTable 5. sayfa 10.satirdaki detailse tikla

        Assert.assertTrue(hotelMyCampPage.hotelRoomsIlkSayfaWebTables(10, 9).isEnabled(), "WebTables 5. sayfa 10. satirdaki Details Butonuna ERISILEMIYOR FAILED");
        ReusableMethods.waitFor(2);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(2);
        hotelMyCampPage.webTableSayfasindakiIsteginDetailsButonunaDirekTikla(10, 9);
//edit hotel Room yazisi Elementi gorunuyormu
        Assert.assertTrue(hotelMyCampPage.editHotelRoomYaziElementi.isEnabled(), "WebTable 5. sayfa 10 satir details Butonuna Tiklanamadi FAILED");
//Propertiese Tiklandi testi yap
        hotelMyCampPage.propertiesSekmesiElementi.click();
        Assert.assertTrue(hotelMyCampPage.addPropertyYaziElementi.isEnabled());

    }

    @Test
    public void test() {
        hotelMyCampPage.direkPropertiesSayfasinaGit();
        Select select = new Select(hotelMyCampPage.propertiesdekiTipDropDownElementi);
        // Propertiesde Girdigimizi Kontrol Icin Tip DD leri yazdiriniz
        List<WebElement> tipDDElementi = select.getOptions();
        for (WebElement each : tipDDElementi) {
            System.out.print("Tip DD Listesi =>" + each.getText() + " ");
        }
    }

    @Test
    public void photosSayfasinaGirisTesti() {
        hotelMyCampPage.direkPhotostSayfasinaGit();
        Assert.assertTrue(hotelMyCampPage.upLoadFilesElementi.isEnabled());
    }

}

// 5 oda eklenir Value Degerleri   guncellenir  ve ilk 2 sini
// silinir Her Adimin Dogrulugu Kontrol Edilir