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



    public class TC_0003 extends TestBaseRapor {

        @Test
        public  void  passwordTextboxTesti() throws IOException {
            //1-Yonetici Url gider
            // 2-"Login in" linki gorunurlulugunu kontrol eder
            //  3-"Login in" linkine tiklar
            // 4-Password textbox'unun gorunur oldugunu kontrol eder
            //5-Password textbox'una sifresinin girilip girilmedigini kontrol eder

            HotelMyCampPage hotelMyCampPage=new HotelMyCampPage();

            Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
            extentTest=extentReports.createTest("Password box testi","Password box un calisabilirligi testi");

            Assert.assertTrue(hotelMyCampPage.ilkLoginLinki.isDisplayed());
            extentTest.info("ilk Login butonu goruldu");

            hotelMyCampPage.ilkLoginLinki.click();
            extentTest.info("Ilk login linkine tiklandi");

            Assert.assertTrue(hotelMyCampPage.passwordBox.isDisplayed());
            extentTest.pass("password textbox goruldu ");

            hotelMyCampPage.passwordBox.sendKeys(ConfigReader.getProperty("HMCValidPassword")+ Keys.ENTER);
            extentTest.info("Paasword textbox una sifre girildi");

            ReusableMethods.getScreenshot("Password kutusu kullanirliligi");
            extentTest.info("ekran goruntusu alindi");

            Driver.closeDriver();

        }

    }
