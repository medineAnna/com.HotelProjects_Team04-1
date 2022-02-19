package tests.US0002;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US0002.HotelMyCampPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;

   public class TC_0004 extends TestBaseRapor {


    @Test
    public void  loginButtonTesti() throws IOException, InterruptedException {
        //  1-Yonetici Url gider
        //     2-"Login in" linki gorunurlulugunu kontrol eder
        //     3-"Login in" linkine tiklar
        //     4-Username textbox'unun gorunur oldugunu kontrol eder
        //     5-Username textbox'una usernamesinin girilip girilmedigini kontrol eder
        //     4-Password textbox'unun gorunur oldugunu kontrol eder
        //     5-Password textbox'una sifresinin girilip girilmedigini kontrol eder
        //     6-Login in butonunun gorunurlulugunu kontrol eder
        //     7-Login butonuna tiklar

        HotelMyCampPage hotelMyCampPage=new HotelMyCampPage();

        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
        extentTest=extentReports.createTest("Login butonu testi","Login butonu kullanilabilirliligi");

        Assert.assertTrue(hotelMyCampPage.ilkLoginLinki.isDisplayed());
        extentTest.info("ilk Login butonu goruldu");

        hotelMyCampPage.ilkLoginLinki.click();
        extentTest.info("Ilk login linkine tiklandi");

        Assert.assertTrue(hotelMyCampPage.usernameBox.isDisplayed());
        extentTest.pass("username textbox goruldu ");


        hotelMyCampPage.usernameBox.sendKeys(ConfigReader.getProperty("HMCValidUsername"));
        extentTest.info("Username textbox una kullanici adi girildi");

        Assert.assertTrue(hotelMyCampPage.passwordBox.isDisplayed());
        extentTest.info("password textbox goruldu");

        hotelMyCampPage.passwordBox.sendKeys(ConfigReader.getProperty("HMCValidPassword"));
        extentTest.info("password textbox'una sifre girildi");

        Assert.assertTrue(hotelMyCampPage.loginButonu.isDisplayed());
        extentTest.info("login butonu goruldu");

        hotelMyCampPage.loginButonu.click();
        extentTest.info("login butonuna tiklandi");

        ReusableMethods.getScreenshot("login butonuna tiklandiktan sonra manager sayfasi goruldu");
        extentTest.info("ekran goruntusu alindi");

        Driver.closeDriver();
        extentTest.info("sayfa kapatildi");
    }

   }

