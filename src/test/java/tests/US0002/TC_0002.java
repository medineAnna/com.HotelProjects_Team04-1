package tests.US0002;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US0002.HotelMyCampPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;



    public class TC_0002 extends TestBaseRapor {

        @Test
        public  void  usernameTextboxTesti() throws IOException {
            // 1-Yonetici Url gider
            //2-"Login in" linki gorunurlulugunu kontrol eder
            //3-"Login in" linkine tiklar
            //4-Username textbox'unun gorunur oldugunu kontrol eder
            //5-Username textbox'una usernamesinin girilip girilmedigini kontrol eder

            HotelMyCampPage hotelMyCampPage=new HotelMyCampPage();

            extentTest=extentReports.createTest("TC_0002 UsernameTextBox testi","Username Box un kullanilirligi");

            Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
            extentTest.info("Istenen adrese gidildi");

            Assert.assertTrue(hotelMyCampPage.ilkLoginLinki.isDisplayed());
            extentTest.info("login linkinin gorunurlulugu test edildi");

            hotelMyCampPage.ilkLoginLinki.click();
            extentTest.info("login linkine tiklandi");

            Assert.assertTrue(hotelMyCampPage.usernameBox.isDisplayed());
            extentTest.info("UsernameTextBox gorunurlulugu test edildi");

            hotelMyCampPage.usernameBox.sendKeys(ConfigReader.getProperty("HMCValidUsername")+ Keys.ENTER);
            extentTest.info("UsernameTextBox kutusuna kullanici adi adi gonderildi,enter basildi, kullanilirligi test edildi");

            ReusableMethods.getScreenshot("usernameTextBox kullanilirligi");
            extentTest.info("ekran goruntusu alindi");

            Driver.closeDriver();
            extentTest.info("sayfa kapatildi");



        }



    }



