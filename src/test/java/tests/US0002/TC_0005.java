package tests.US0002;


import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.US0002.HotelMyCampPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;

public class TC_0005 extends TestBaseRapor {

        @Test
        public void managerYazisiGorunurTesti() throws  InterruptedException, IOException {

            //1-Yonetici Url gider
            //    2-"Login in" linki gorunurlulugunu kontrol eder
            //    3-"Login in" linkine tiklar
            //    4-Username textbox'unun gorunur oldugunu kontrol eder
            //    5-Username textbox'una usernamesinin girilip girilmedigini kontrol eder
            //    6-Password textbox'unun gorunur oldugunu kontrol eder
            //    7-Password textbox'una sifresinin girilip girilmedigini kontrol eder
            //    8-Login butonuna tiklar
            //    9-Login in butonunun gorunurlulugunu kontrol eder
            //    10-"manager" yazisinin gorunurlulugunu kontrol eder

            HotelMyCampPage hotelMyCampPage=new HotelMyCampPage();
            SoftAssert softAssert=new SoftAssert();

            Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
            extentTest=extentReports.createTest("Manager sayfasina gitme","yonetici datalar ile login olunacak");

            softAssert.assertTrue(hotelMyCampPage.ilkLoginLinki.isDisplayed());
            extentTest.info("ilk Login butonu goruldu");

            hotelMyCampPage.ilkLoginLinki.click();
            extentTest.info("Ilk login linkine tiklandi");

            softAssert.assertTrue(hotelMyCampPage.usernameBox.isDisplayed());
            extentTest.pass("username textbox goruldu ");

            hotelMyCampPage.usernameBox.sendKeys(ConfigReader.getProperty("HMCValidUsername")+ Keys.ENTER);
            extentTest.info("Username textbox una kullanici adi girildi");

            softAssert.assertTrue(hotelMyCampPage.passwordBox.isDisplayed());
            extentTest.info("password textbox goruldu");

            hotelMyCampPage.passwordBox.sendKeys(ConfigReader.getProperty("HMCValidPassword")+Keys.ENTER);
            extentTest.info("password textbox'una sifre girildi");
            Thread.sleep(3000);

            softAssert.assertTrue(hotelMyCampPage.loginCercevesi.isDisplayed());
            extentTest.info("login butonu goruldu");

            hotelMyCampPage.loginCercevesi.click();
            extentTest.info("login butonuna tiklandi");

            softAssert.assertTrue(hotelMyCampPage.managerSayfaTest.isDisplayed());
            extentTest.info("manager system sayfasi gorunurlulugu test edildi");
            softAssert.assertAll();

            ReusableMethods.getScreenshot("Login butonuna tiklandi manager system sayfasina gidildi");
            extentTest.info("ekran goruntusu alindi");
            Driver.closeDriver();
            extentTest.info("sayfa kapatildi");




        }



    }


