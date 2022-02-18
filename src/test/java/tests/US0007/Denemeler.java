package tests.US0007;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

public class Denemeler {
    Actions actions = new Actions(Driver.getDriver());
    HMCMainPage hmcMainPage=new HMCMainPage();
    SoftAssert softAssert;
    HotelMyCampPage hotelMyCampPage=new HotelMyCampPage();

    @BeforeMethod
    public void anaSayfaGiris() {
        hmcMainPage.anaSayfayaGit();
    }
/*
    @Test
    public void AhotelMyCampUrlTesti() {
        ReusableMethods.waitFor(2);
        String actualHMCUrl = Driver.getDriver().getCurrentUrl();
        String expectedHMCUrl = "https://www.hotelmycamp.com/";
        softAssert = new SoftAssert();
//1-)Yonetici URL'ye Gider Url in Dogru ve Acilir Oldugunu Gorur
        softAssert.assertEquals(actualHMCUrl, expectedHMCUrl, "HMC Url FAILED!!!");
        softAssert.assertAll();
        ReusableMethods.waitFor(2);
    }
    @Test
    public void BilkLoginButonuGorunurveAktifmiTesti() {
        ReusableMethods.waitFor(2);
// 2-)Yonetici Login Butonunun Gorunur Aktif  Oldugunu Kontrol Eder
// ve Tiklayip  onceden belirlenen sifreyle giris yapar.
        WebElement ilkLoginButonu07=Driver.getDriver().findElement(By.xpath("//li[contains( @id, 'Log')]"));
        Assert.assertTrue(ilkLoginButonu07.isDisplayed(), "Ilk Anasayfa Login Butonu GORUNUR  DEGIL");
        Assert.assertTrue(ilkLoginButonu07.isEnabled(), "Ilk Anasayfa Login Butonu AKTIF  DEGIL");
        ReusableMethods.waitFor(2);

    }


 */
    @Test
    public void CsayfayaSifreyleGirisYapildiginaDairTest() {
        ReusableMethods.waitFor(2);
//3-) Yonetici Onceden Belirlenen Sifreyle Giris Yaptigini Teyit Eder
//Ve Yonetici Hotel Management (DD) Aktif Oldugunu Teyit Eder
//hotelMyCampPage. hmcIlkLogin.click();
        WebElement ilkLoginButonunaTikla=Driver.getDriver().findElement(By.xpath("//li[contains( @id, 'Log')]"));
        ReusableMethods.waitForVisibility(ilkLoginButonunaTikla,20);
        ilkLoginButonunaTikla.click();
        ReusableMethods.waitFor(3);
        //ReusableMethods.waitForVisibility(hotelMyCampPage.userNameBox07,30);
      //  hotelMyCampPage.userNameBox07.sendKeys(ConfigReader.getProperty("HMCValidUsername"));
     //   hmcMainPage. passwordBox.sendKeys(ConfigReader.getProperty("HMCValidPassword"));
        actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                        .sendKeys(Keys.TAB).sendKeys(ConfigReader.
                        getProperty("HMCValidUsername")).sendKeys(Keys.TAB).
                sendKeys(ConfigReader.getProperty("HMCValidPassword")).perform();
        Assert.assertTrue(hotelMyCampPage.createaNewAccountButonu.isEnabled(), "ilk Login Butonuna Tiklanamadi FAILED");
        hmcMainPage. idveSifreyeGirLoginButonu.click();
        Assert.assertTrue(hmcMainPage.yoneticiOlarakGirisYapilincaCikanListOfUsersElementi.isDisplayed(), "Yonetici Olarak Sayfaya Giris Yapilamadi FAILED");

        ReusableMethods.waitFor(3);
        Driver.closeDriver();

    }
    @Test
    public void DhotelManagementAndHotelRoomsGozukuyorveAktifmiTesti() {
        ReusableMethods.waitFor(2);
        WebElement ilkLoginButonunaTikla=Driver.getDriver().findElement(By.xpath("//li[contains( @id, 'Log')]"));
        ReusableMethods.waitForVisibility(ilkLoginButonunaTikla,20);
        ilkLoginButonunaTikla.click();
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






@AfterMethod
    public void tearDown007(){
        Driver.closeDriver();
}
}
