package tests.US0007;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
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

public class HMCPozitifRunTestUS0007 extends TestBaseRapor {
    Actions actions = new Actions(Driver.getDriver());
    HMCMainPage hmcMainPage=new HMCMainPage();
    SoftAssert softAssert;
    HotelMyCampPage hotelMyCampPage=new HotelMyCampPage();


    @Test(priority = 1)
    public void hotelMyCampUrlTesti() {

        extentTest=extentReports.createTest("HotelMyCamp Url Testi","HMC Url Test Edildi");
        hmcMainPage.anaSayfayaGit();
        extentTest.info("HMC Sayfasina Gidildi");
        String actualHMCUrl = Driver.getDriver().getCurrentUrl();
        String expectedHMCUrl = "https://www.hotelmycamp.com/";
        softAssert = new SoftAssert();
//1-)Yonetici URL'ye Gider Url in Dogru ve Acilir Oldugunu Gorur
        softAssert.assertEquals(actualHMCUrl, expectedHMCUrl, "HMC Url FAILED!!!");
        softAssert.assertAll();
        extentTest.pass("URL Adresi Dogrulandi Testi  Basariyla TAMAMLANDI :)");

    }
    @Test(priority = 2)
    public void ilkLoginButonuGorunurveAktifmiTesti() {
        extentTest=extentReports.createTest("Ilk Login Butonu Gorunur ve Aktif mi Testi","ilkLogin Butonu Gorunur ve Aktifmi Test Edildi");
        hmcMainPage.anaSayfayaGit();
// 2-)Yonetici Login Butonunun Gorunur Aktif  Oldugunu Kontrol Eder
// ve Tiklayip  onceden belirlenen sifreyle giris yapar.
        WebElement ilkLoginButonu07=Driver.getDriver().findElement(By.xpath("//li[contains( @id, 'Log')]"));
        Assert.assertTrue(ilkLoginButonu07.isDisplayed(), "Ilk Anasayfa Login Butonu GORUNUR  DEGIL");
        Assert.assertTrue(ilkLoginButonu07.isEnabled(), "Ilk Anasayfa Login Butonu AKTIF  DEGIL");
        extentTest.pass("Ilk Login Butonu Gorunur ve Aktif mi Testi Basariyla TAMAMLANDI :)");


    }



    @Test(priority = 3)
    public void sayfayaSifreyleGirisYapildiginaDairTest() {
        extentTest=extentReports.createTest("Sayfaya Sifreyle Giris Yapildigina Dair Test","Sayfaya Sifreyle Giris Yapildigina Dair Test Edildi");
        hmcMainPage.anaSayfayaGit();
//3-) Yonetici Onceden Belirlenen Sifreyle Giris Yaptigini Teyit Eder
//Ve Yonetici Hotel Management (DD) Aktif Oldugunu Teyit Eder
//hotelMyCampPage. hmcIlkLogin.click();
WebElement ilkLoginButonunaTikla=Driver.getDriver().findElement(By.xpath("//li[contains( @id, 'Log')]"));
ReusableMethods.waitForVisibility(ilkLoginButonunaTikla,20);
ilkLoginButonunaTikla.click();
//ReusableMethods.waitFor(3);
//ReusableMethods.waitForVisibility(hotelMyCampPage.userNameBox07,30);
//ReusableMethods.waitFor(3);


hmcMainPage.userNameBox.sendKeys(ConfigReader.getProperty("HMCValidUsername"));
hmcMainPage. passwordBox.sendKeys(ConfigReader.getProperty("HMCValidPassword"));

        Assert.assertTrue(hotelMyCampPage.createaNewAccountButonu.isEnabled(), "ilk Login Butonuna Tiklanamadi FAILED");
        hmcMainPage. idveSifreyeGirLoginButonu.click();
        Assert.assertTrue(hmcMainPage.yoneticiOlarakGirisYapilincaCikanListOfUsersElementi.isDisplayed(), "Yonetici Olarak Sayfaya Giris Yapilamadi FAILED");
        actions.moveToElement(hotelMyCampPage.managerDropDownButton).perform();
        ReusableMethods.waitFor(3);
        hotelMyCampPage.logOutButton.click();
        extentTest.pass("Sayfaya Sifreyle Giris Yapildigina Dair Test Basariyla TAMAMLANDI :)");
    }
    @Test(priority = 4)
    public void hotelManagementAndHotelRoomsGozukuyorveAktifmiTesti() {
        extentTest=extentReports.createTest("HotelManagement And HotelRooms Gozukuyor ve Aktif mi Testi","HotelManagement And HotelRooms Gozukuyor ve Aktifmi Test Edildi");
        hmcMainPage.anaSayfayaGit();
        WebElement ilkLoginButonunaTikla=Driver.getDriver().findElement(By.xpath("//li[contains( @id, 'Log')]"));
        ReusableMethods.waitForVisibility(ilkLoginButonunaTikla,20);
        ilkLoginButonunaTikla.click();
        hmcMainPage.userNameBox.sendKeys(ConfigReader.getProperty("HMCValidUsername"));
        hmcMainPage. passwordBox.sendKeys(ConfigReader.getProperty("HMCValidPassword"));
        hmcMainPage. idveSifreyeGirLoginButonu.click();
// 4-)Yonetici olarakHotelManagement Gorunur Aktifmi
//hmcMainPage.  yoneticiOlarakGirisYap();
        ReusableMethods.waitForVisibility(hmcMainPage.hotelManagementElementi,20);
        Assert.assertTrue(hmcMainPage.hotelManagementElementi.isDisplayed(), "Hotel Management Butonu Gozukmuyor FAILED");
        Assert.assertTrue(hmcMainPage.hotelManagementElementi.isEnabled(), "Hotel Management Butonu Aktif DEGIL FAILED");
        hmcMainPage. hotelManagementElementi.click();
        ReusableMethods.waitForVisibility(hmcMainPage.hotelRoomsElementi,20);
// HotelRoms Gorunur Aktifmi
        Assert.assertTrue(hmcMainPage.hotelRoomsElementi.isDisplayed(), "Hotel Rooms Gozukmuyor FAILED");
        Assert.assertTrue(hmcMainPage.hotelRoomsElementi.isEnabled(), "Hotel Rooms Aktif DEGIL FAILED");
        ReusableMethods.waitFor(3);
        actions.moveToElement(hotelMyCampPage.managerDropDownButton).perform();
        ReusableMethods.waitFor(2);
        hotelMyCampPage.logOutButton.click();
        extentTest.pass("HotelManagement And HotelRooms Gozukuyor ve Aktif mi Testi Basariyla TAMAMLANDI :)");
    }

@Test(priority = 5)
public void hotelRoomsSayfayaTiklanincaSayfaninAktifOldugunaDairTest() {
    extentTest=extentReports.createTest("HotelRooms Sayfaya Tiklaninca Sayfanin Aktif Olduguna Dair Test","HotelRooms Sayfaya Tiklaninca Sayfanin Aktif Olduguna Dair Test Edildi");
// 5-)Yonetici Hotel Roomsa Tiklar
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
}


    @Test(priority = 6)
    public void webTablein5SayfadakiBilgilereErismeTEsti() throws IOException {
        extentTest=extentReports.createTest("Web Table'in 5. Sayfadaki Bilgilere Erisme Testi","Web Table'in 5. Sayfadaki Bilgilere Erismesi Test Edildi ");
        hmcMainPage.anaSayfayaGit();
//6-)Web Table 5.Tablo Sayfasi Bilgilerine Eristigini Screen Shot la Teyit Et
        hotelMyCampPage. hotelRoomsWebTablinIsteginSayfasinaGit(5);
//ReusableMethods.getScreenshot("WebTable5.SayfaGoruntusu");
        ReusableMethods.waitFor(3);
        actions.moveToElement(hotelMyCampPage.managerDropDownButton).perform();
        ReusableMethods.waitFor(2);
        hotelMyCampPage.logOutButton.click();
        extentTest.pass("Web Table'in 5. Sayfadaki Bilgilere Erisme Testi Basariyla TAMAMLANDI :)");
    }

@Test(priority = 7)
public void webTable5inciSayfa10SatirDetailsvePropertieseGirisTesti() {
    extentTest=extentReports.createTest("WebTable 5. Sayfa 10. Satir Details ve Propertiese Giris Testi","WebTable 5. Sayfa 10. Satir Details ve Propertiese Giris Test Edildi");
    hmcMainPage.anaSayfayaGit();
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
    actions.moveToElement(hotelMyCampPage.managerDropDownButton).perform();
    ReusableMethods.waitFor(2);
    hotelMyCampPage.logOutButton.click();
    extentTest.pass("WebTable 5. Sayfa 10.Satir Details ve Propertiese Giris Testi Basariyla TAMAMLANDI :)");
}
    @Test(priority = 8)
    public void generalDataSayfasinaGirisTesti(){
        extentTest=extentReports.createTest("General Data Sayfasina Giris Testi","General Data Sayfasina Giris  Test Edildi");
        hmcMainPage.anaSayfayaGit();
        hotelMyCampPage.direkGeneralDataSayfasinaGit();
        Assert.assertTrue(hotelMyCampPage.generalDataHotelroomDataText.isDisplayed());
        actions.moveToElement(hotelMyCampPage.managerDropDownButton).perform();
        ReusableMethods.waitFor(2);
        hotelMyCampPage.logOutButton.click();
        Driver.closeDriver();
        extentTest.pass("General Data Sayfasina Giris Testi TAMAMLANDI :)");

    }
    /*
    @Test(priority = 9)
    public void photosSayfasinaGirisTesti() {
        extentTest=extentReports.createTest("Photos Sayfasina Giris Testi ","Photos Sayfasina Giris Test Edildi");
        hmcMainPage.anaSayfayaGit();
//8
        hotelMyCampPage.direkPhotostSayfasinaGit();
        Assert.assertTrue(hmcMainPage.upLoadFilesElementi.isEnabled());
        ReusableMethods.waitFor(3);
        actions.moveToElement(hotelMyCampPage.managerDropDownButton).perform();
        ReusableMethods.waitFor(2);
        hotelMyCampPage.logOutButton.click();
        extentTest.pass("Photos Sayfasina Giris Basariyla TAMAMLANDI :)");
    }

//*/
    /*
    @Test(priority = 10)
    public void propertiesSayfasiErisimTesti() {
        extentTest=extentReports.createTest("Properties Sayfasi Erisim Testi","Properties Sayfasi Erisim Test Edildi");
        hmcMainPage.anaSayfayaGit();
//9
        hotelMyCampPage.direkPropertiesSayfasinaGit();
        Select select = new Select(hmcMainPage.propertiesdekiTipDropDownElementi);
// Propertiesde Girdigimizi Kontrol Icin Tip DD leri yazdiriniz
        List<WebElement> tipDDElementi = select.getOptions();
        for (WebElement each : tipDDElementi) {
            System.out.print("Tip DD Listesi =>" + each.getText() + " ");

        }
        ReusableMethods.waitFor(3);
        actions.moveToElement(hotelMyCampPage.managerDropDownButton).perform();
        ReusableMethods.waitFor(2);
        hotelMyCampPage.logOutButton.click();
        extentTest.pass("Properties Sayfasi Erisim Testi BASARIYLA TEST EDILDI:) ");
    }
    */
    //************************************************
    @Test(priority = 11)
//10
    public void odaBilgileriGuncellemeTesti() throws IOException {
        extentTest=extentReports.createTest("Oda Bilgileri Guncelleme Testi","Oda Bilgileri Guncelleme Test Edildi");
        hmcMainPage.anaSayfayaGit();
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
    //   ReusableMethods.getScreenshot("Oda Bilgileri Kayit Edildi Teyit Photo (US07)");
        ReusableMethods.waitFor(3);
        actions.moveToElement(hotelMyCampPage.managerDropDownButton).perform();
        ReusableMethods.waitFor(2);
        hotelMyCampPage.logOutButton.click();
        extentTest.pass("Oda Bilgileri Kayit");
    }

    @Test(priority = 12)
    public void odaBilgileriSilmeTesti() throws IOException {
        extentTest=extentReports.createTest("Oda Bilgileri Silme Testi","Oda Bilgileri Silme Test Edildi");
        hmcMainPage.anaSayfayaGit();
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

        WebElement errorYazisi=Driver.getDriver().findElement(By.xpath("//div[@class='bootbox-body']"));
        Assert.assertFalse(errorYazisi.isDisplayed());//Dogru
        ReusableMethods.getScreenshot("Oda Bilgileri Silinemedi Yazisi (US07)");

        ReusableMethods.waitFor(3);//wsadasd
        actions.moveToElement(hotelMyCampPage.managerDropDownButton).perform();
        ReusableMethods.waitFor(2);
        hotelMyCampPage.logOutButton.click();
        extentTest.pass("Oda Bilgilerini Silme Test Edildi :)");
//Test Sonu
    }


@AfterClass
    public void tearDown007(){
        ReusableMethods.waitFor(5);
        Driver.closeDriver();
}



}
