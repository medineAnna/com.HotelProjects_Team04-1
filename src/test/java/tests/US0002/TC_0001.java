package tests.US0002;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US0002.HotelMyCampPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;



    public class TC_0001 extends TestBaseRapor {
        //1-Yonetici Url gider
        // 2-"Login in" linki gorunurlulugunu kontrol eder
        //3-"Login in" linkine tiklar


        @Test
        public  void  sayfayaGirmeTesti() throws IOException {
            HotelMyCampPage hotelMyCampPage=new HotelMyCampPage();


            extentTest=extentReports.createTest("TC_0002 login testi ","istenen sayfaya gitme login sayfasini gorme");

            Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
            extentTest.info("Istenen adrese gidildi");

            Assert.assertTrue(hotelMyCampPage.ilkLoginLinki.isDisplayed());
            extentTest.info("login linkinin gorunurlulugu test edildi");

            hotelMyCampPage.ilkLoginLinki.click();
            extentTest.info("login linkine tiklandi");

            ReusableMethods.getScreenshot("Login sayfasi");
            extentTest.info("ekran goruntusu alindi");

            Driver.closeDriver();
            extentTest.info("sayfa kapatildi");



        }

    }
