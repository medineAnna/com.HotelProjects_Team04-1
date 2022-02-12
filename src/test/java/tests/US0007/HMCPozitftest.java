package tests.US0007;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.OrtakHMCPageBurayiSakinKurcalama.HMCMainPage;
import pages.pagesUS0007.HotelMyCampPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;
import java.util.List;

public class HMCPozitftest extends  HotelMyCampPage{
    Actions actions = new Actions(Driver.getDriver());

    SoftAssert softAssert;

    @BeforeMethod
    public void anaSayfaGiris() {
       anaSayfayaGit();
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
        Assert.assertTrue(ilkLoginElementi.isDisplayed(), "Ilk Anasayfa Login Butonu GORUNUR  DEGIL");
        Assert.assertTrue(ilkLoginElementi.isEnabled(), "Ilk Anasayfa Login Butonu AKTIF  DEGIL");


    }

    @Test
    public void sayfayaSifreyleGirisYapildiginaDairTest() {
//3-) Yonetici Onceden Belirlenen Sifreyle Giris Yaptigini Teyit Eder
//Ve Yonetici Hotel Management (DD) Aktif Oldugunu Teyit Eder
      ilkLoginElementi.click();
      Assert.assertTrue(sifreGirmeSayfasiCategories.isDisplayed(), "ilk Login Butonuna Tiklanamadi FAILED");
      userNameBox.sendKeys(ConfigReader.getProperty("HMCValidUsername"));
      passwordBox.sendKeys(ConfigReader.getProperty("HMCValidPassword"));
      idveSifreyeGirLoginButonu.click();
      Assert.assertTrue(yoneticiOlarakGirisYapilincaCikanListOfUsersElementi.isDisplayed(), "Yonetici Olarak Sayfaya Giris Yapilamadi FAILED");
    }

    @Test
    public void hotelManagementAndHotelRoomsGozukuyorveAktifmiTesti() {
// 4-)Yonetici olarakHotelManagement Gorunur Aktifmi
        yoneticiOlarakGirisYap();
        Assert.assertTrue(hotelManagementElementi.isDisplayed(), "Hotel Management Butonu Gozukmuyor FAILED");
        Assert.assertTrue(hotelManagementElementi.isEnabled(), "Hotel Management Butonu Aktif DEGIL FAILED");
       hotelManagementElementi.click();
// HotelRoms Gorunur Aktifmi
        Assert.assertTrue(hotelRoomsElementi.isDisplayed(), "Hotel Rooms Gozukmuyor FAILED");
        Assert.assertTrue(hotelRoomsElementi.isEnabled(), "Hotel Rooms Aktif DEGIL FAILED");
    }

    @Test
    public void hotelRoomsSayfayaTiklanincaSayfaninAktifOldugunaDairTest() {
// 5-)Yonetici Hotel Roomsa Tiklar
        yoneticiOlarakGirisYap();
        hotelManagementElementi.click();
        hotelRoomsElementi.click();
        //Tablo basliklarini Kontrol eder ve Yazdirir
        for (WebElement each :theaderTabloBasliklariElementi) {
            Assert.assertTrue(each.isDisplayed(), "Tablo Basliklari FAILED");
            System.out.print(each.getText() + " ,");
        }
        //Tablodaki 10. Satir 5. sutun Data Bilgisini Yazdirir

        Assert.assertTrue(hotelRoomsIlkSayfaWebTables(10, 5).isEnabled(), "1. Sayfa Web 10 satir 5. Sutun Bilgisi Gorunmuyor FAILED");
        System.out.println("webTableIstediginSutunuYazdir =>>" +hotelRoomsIlkSayfaWebTables(10, 5).getText());


    }

    @Test
    public void webTablein5SayfadakiBilgilereErismeTEsti() throws IOException {
        //6-)Web Table 5.Tablo Sayfasi Bilgilerine Eristigini Screen Shot la Teyit Et
        hotelRoomsWebTablinIsteginSayfasinaGit(5);
//ReusableMethods.getScreenshot("WebTable5.SayfaGoruntusu");
    }

    @Test
    public void webTable5inciSayfa10SatirDetailsvePropertieseGirisTesti() {
//  7-) //WebTable 5. safya 10. Satir daki Details Butonunun Erisilebilir Oldugunu Kontrol Ederek Details Butonuna Tikla ve Tiklandigini Kontrol Et

        hotelRoomsWebTablinIsteginSayfasinaGit(5);
//WebTable 5. sayfa 10.satirdaki detailse tikla

        Assert.assertTrue(hotelRoomsIlkSayfaWebTables(10, 9).isEnabled(), "WebTables 5. sayfa 10. satirdaki Details Butonuna ERISILEMIYOR FAILED");
        ReusableMethods.waitFor(2);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(2);
        webTableSayfasindakiIsteginDetailsButonunaDirekTikla(10, 9);
//edit hotel Room yazisi Elementi gorunuyormu
        Assert.assertTrue(editHotelRoomYaziElementi.isEnabled(), "WebTable 5. sayfa 10 satir details Butonuna Tiklanamadi FAILED");
//Propertiese Tiklandi testi yap
      propertiesSekmesiElementi.click();
        Assert.assertTrue(addPropertyYaziElementi.isEnabled());

    }

    @Test
    public void test() {
        direkPropertiesSayfasinaGit();
        Select select = new Select(propertiesdekiTipDropDownElementi);
        // Propertiesde Girdigimizi Kontrol Icin Tip DD leri yazdiriniz
        List<WebElement> tipDDElementi = select.getOptions();
        for (WebElement each : tipDDElementi) {
            System.out.print("Tip DD Listesi =>" + each.getText() + " ");
        }
    }

    @Test
    public void photosSayfasinaGirisTesti() {
        direkPhotostSayfasinaGit();
        Assert.assertTrue(upLoadFilesElementi.isEnabled());
    }

}

// 5 oda eklenir Value Degerleri   guncellenir  ve ilk 2 sini
// silinir Her Adimin Dogrulugu Kontrol Edilir