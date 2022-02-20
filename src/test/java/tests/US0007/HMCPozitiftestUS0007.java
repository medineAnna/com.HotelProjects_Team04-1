package tests.US0007;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pages.OrtakHMCPageBurayiSakinKurcalama.HMCMainPage;
import pages.pagesUS0007.HotelMyCampPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import java.io.IOException;
import java.util.List;

public class HMCPozitiftestUS0007 {
Actions actions = new Actions(Driver.getDriver());
HMCMainPage hmcMainPage=new HMCMainPage();
SoftAssert softAssert;
HotelMyCampPage hotelMyCampPage=new HotelMyCampPage();

@BeforeMethod
public void anaSayfaGiris() {
hmcMainPage.anaSayfayaGit();
    }

@Test
public void AhotelMyCampUrlTesti() {
  ReusableMethods.waitFor(2);
String actualHMCUrl = Driver.getDriver().getCurrentUrl();
String expectedHMCUrl = "https://www.hotelmycamp.com/";
softAssert = new SoftAssert();
//1-)Yonetici URL'ye Gider Url in Dogru ve Acilir Oldugunu Gorur
softAssert.assertEquals(actualHMCUrl, expectedHMCUrl, "HMC Url FAILED!!!");
softAssert.assertAll();
    ReusableMethods.waitFor(3);

    }

@Test
public void BilkLoginButonuGorunurveAktifmiTesti() {
        ReusableMethods.waitFor(2);
// 2-)Yonetici Login Butonunun Gorunur Aktif  Oldugunu Kontrol Eder
// ve Tiklayip  onceden belirlenen sifreyle giris yapar.
Assert.assertTrue(hotelMyCampPage.hmcIlkLogin.isDisplayed(), "Ilk Anasayfa Login Butonu GORUNUR  DEGIL");
Assert.assertTrue(hotelMyCampPage.hmcIlkLogin.isEnabled(), "Ilk Anasayfa Login Butonu AKTIF  DEGIL");
ReusableMethods.waitFor(3);

Driver.getDriver().quit();
    }



    @Test
public void CsayfayaSifreyleGirisYapildiginaDairTest() {
        ReusableMethods.waitFor(2);
//3-) Yonetici Onceden Belirlenen Sifreyle Giris Yaptigini Teyit Eder
//Ve Yonetici Hotel Management (DD) Aktif Oldugunu Teyit Eder
//hotelMyCampPage. hmcIlkLogin.click();
WebElement ilkLoginButonunaTikla=Driver.getDriver().findElement(By.xpath("//li[contains( @id, 'Log')]"));
ilkLoginButonunaTikla.click();
Assert.assertTrue(hmcMainPage.sifreGirmeSayfasiCategories.isDisplayed(), "ilk Login Butonuna Tiklanamadi FAILED");
hmcMainPage.userNameBox.sendKeys(ConfigReader.getProperty("HMCValidUsername"));
hmcMainPage. passwordBox.sendKeys(ConfigReader.getProperty("HMCValidPassword"));
hmcMainPage. idveSifreyeGirLoginButonu.click();
Assert.assertTrue(hmcMainPage.yoneticiOlarakGirisYapilincaCikanListOfUsersElementi.isDisplayed(), "Yonetici Olarak Sayfaya Giris Yapilamadi FAILED");

ReusableMethods.waitFor(3);
//Driver.closeDriver();

    }

    @Test
public void DhotelManagementAndHotelRoomsGozukuyorveAktifmiTesti() {
        ReusableMethods.waitFor(2);
        hotelMyCampPage. hmcIlkLogin.click();
        hmcMainPage.userNameBox.sendKeys(ConfigReader.getProperty("HMCValidUsername"));
        hmcMainPage. passwordBox.sendKeys(ConfigReader.getProperty("HMCValidPassword"));
        hmcMainPage. idveSifreyeGirLoginButonu.click();
// 4-)Yonetici olarakHotelManagement Gorunur Aktifmi
//hmcMainPage.  yoneticiOlarakGirisYap();
Assert.assertTrue(hmcMainPage.hotelManagementElementi.isDisplayed(), "Hotel Management Butonu Gozukmuyor FAILED");
Assert.assertTrue(hmcMainPage.hotelManagementElementi.isEnabled(), "Hotel Management Butonu Aktif DEGIL FAILED");
hmcMainPage. hotelManagementElementi.click();
ReusableMethods.waitForVisibility(hmcMainPage.hotelRoomsElementi,20);
// HotelRoms Gorunur Aktifmi
Assert.assertTrue(hmcMainPage.hotelRoomsElementi.isDisplayed(), "Hotel Rooms Gozukmuyor FAILED");
Assert.assertTrue(hmcMainPage.hotelRoomsElementi.isEnabled(), "Hotel Rooms Aktif DEGIL FAILED");
    ReusableMethods.waitFor(3);
        Driver.closeDriver();

    }

    @Test
public void EhotelRoomsSayfayaTiklanincaSayfaninAktifOldugunaDairTest() {
        ReusableMethods.waitFor(2);
// 5-)Yonetici Hotel Roomsa Tiklar
hotelMyCampPage. yoneticiOlarakGirisYap2();
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

        Driver.closeDriver();
    }

    @Test
public void FwebTablein5SayfadakiBilgilereErismeTEsti() throws IOException {
        ReusableMethods.waitFor(2);
//6-)Web Table 5.Tablo Sayfasi Bilgilerine Eristigini Screen Shot la Teyit Et
hotelMyCampPage. hotelRoomsWebTablinIsteginSayfasinaGit(5);
//ReusableMethods.getScreenshot("WebTable5.SayfaGoruntusu");
    ReusableMethods.waitFor(3);
        Driver.closeDriver();

    }

    @Test
public void GwebTable5inciSayfa10SatirDetailsvePropertieseGirisTesti() {
        ReusableMethods.waitFor(2);
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
        Driver.closeDriver();

    }
    @Test
public void HgeneralDataSayfasinaGirisTesti(){
        ReusableMethods.waitFor(2);
    hotelMyCampPage.direkGeneralDataSayfasinaGit();
    Assert.assertTrue(hotelMyCampPage.generalDataHotelroomDataText.isDisplayed());

}

    @Test
public void JphotosSayfasinaGirisTesti() {
        ReusableMethods.waitFor(2);
//8
hotelMyCampPage.direkPhotostSayfasinaGit();
Assert.assertTrue(hmcMainPage.upLoadFilesElementi.isEnabled());
    ReusableMethods.waitFor(3);
        Driver.closeDriver();
    }

    @Test
public void KpropertiesSayfasiErisimTesti() {
        ReusableMethods.waitFor(2);
//9
hotelMyCampPage.direkPropertiesSayfasinaGit();
Select select = new Select(hmcMainPage.propertiesdekiTipDropDownElementi);
// Propertiesde Girdigimizi Kontrol Icin Tip DD leri yazdiriniz
List<WebElement> tipDDElementi = select.getOptions();
for (WebElement each : tipDDElementi) {
System.out.print("Tip DD Listesi =>" + each.getText() + " ");

}
    ReusableMethods.waitFor(3);
        Driver.closeDriver();
    }
    @Test
//10
public void LodaBilgileriGuncellemeTesti(){
ReusableMethods.waitFor(2);
hotelMyCampPage.direkGeneralDataSayfasinaGit();
hotelMyCampPage. hotelRoomGuncellemeDatasiGonderme("0007","MustafaDRoom10",
"Muslihittin mah. No:48  Afrika ",
"Huzurlu ve Mutlu tatilin adresi",
"500.000","5","1");
Assert.assertTrue(hotelMyCampPage.generalDataRoomsUpdateText.isDisplayed(),"Room Guncellenemedi FAILED");
hotelMyCampPage.generalDataUpdateOKButonElementi.click();
Driver.getDriver().navigate().back();
hotelMyCampPage.listOfHotelRoomsNameBoxDataPush("MustafaDRoom10");
hotelMyCampPage.listOfHotelRoomsyellowSearchButton.click();
ReusableMethods.waitFor(3);
String actualText=hotelMyCampPage.listOfHotelRoomsNameElementi.getText();
WebElement odaKayitNameYazisi=Driver.getDriver().findElement(By.xpath("//td[.='MustafaDRoom1']"));
Assert.assertTrue(odaKayitNameYazisi.isDisplayed(),"Oda Kaydi Basarisiz");
ReusableMethods.waitFor(3);
Driver.closeDriver();
}

    @Test
public void ModaBilgileriSilmeTesti() throws IOException {
        ReusableMethods.waitFor(2);
//11
hotelMyCampPage.direkGeneralDataSayfasinaGit();
hotelMyCampPage.hotelRoomDeleteDatasiGonderme("0007","MustafaDRoom10",
"Muslihittin mah. No:48  Afrika ",
"Huzurlu ve Mutlu tatilin adresi",
"510.000","5","1");
hotelMyCampPage.generalDataSaveButonuElementi.click();
hotelMyCampPage.generalDataUpdateOKButonElementi.click();
ReusableMethods.waitFor(2);
hotelMyCampPage.generalDataDeleteButonuElementi.click();
ReusableMethods.waitFor(2);
hotelMyCampPage.generalDataSaveClickOkButonu.click();// ////*********
      /*
hotelMyCampPage.endUserName.sendKeys(ConfigReader.getProperty("HMCValidUsername"));
hotelMyCampPage.endPassword.sendKeys(ConfigReader.getProperty("HMCValidPassword"));
hotelMyCampPage.endLogInButton.click();
hotelMyCampPage.listOfHotelRoomsNameBoxDataPush("MustafaDRoom10");
hotelMyCampPage.listOfHotelRoomsyellowSearchButton.click();
ReusableMethods.getScreenshot("Oda Bilgileri Silindi Teyit Photos");
*/
WebElement errorYazisi=Driver.getDriver().findElement(By.xpath("//div[@class='bootbox-body']"));
Assert.assertFalse(errorYazisi.isDisplayed());//Dogru

ReusableMethods.waitFor(3);//wsadasd
Driver.closeDriver();
    }
/*
@AfterClass
public void tearDown(){
Driver.closeDriver();
}
*/

}//************THE END*****************//
