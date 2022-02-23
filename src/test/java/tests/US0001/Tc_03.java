package tests.US0001;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.pagesUS0001.HotelMyCampPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class Tc_03 extends TestBaseRapor {
  @Test
    public void tc03Testi(){
    extentTest=extentReports.createTest("US001TC03",
            "Check availability butonu gorunurlugunu test edildi.");


      // 1-kullanici url e gider

      HotelMyCampPage hotelMyCamHpPage = new HotelMyCampPage();
      Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
       extentTest.info("URL e gidildi.");

      //2-Kullanici rezervasyon kutularini ve check availability butonunun gorunur oldugunu ve tiklanabilir oldugunu test et

      // checkIn butonu gorunurlugunu test et
     // checkIN butonuna tikla
      Assert.assertTrue(hotelMyCamHpPage.checkIn.isDisplayed());
      hotelMyCamHpPage.checkIn.click();
    extentTest.info("Check in butonu tiklandi.");
    // checkOut butonu gorunurlugunu test et
    // checkOut butonuna tikla
      Assert.assertTrue(hotelMyCamHpPage.checkOut.isDisplayed());
      hotelMyCamHpPage.checkOut.click();
    extentTest.info("Check out butonu tiklandi.");
    // RoomType butonu gorunurlugunu test et
    // RoomType butonuna tikla
      Assert.assertTrue(hotelMyCamHpPage.roomTypeDropdown.isDisplayed());
      hotelMyCamHpPage.roomTypeDropdown.click();
    extentTest.info("Check out butonu tiklandi.");
    // Customer butonu gorunurlugunu test et
    // Customer butonuna tikla
      Assert.assertTrue(hotelMyCamHpPage.addCustomer.isDisplayed());
      hotelMyCamHpPage.addCustomer.click();
    extentTest.info("Customer butonu tiklandi.");
    // Check availability butonu gorunurlugunu test et
    // Check availability butonuna tikla
      Assert.assertTrue(hotelMyCamHpPage.CheckAvailabilityButonu.isDisplayed());
      hotelMyCamHpPage.CheckAvailabilityButonu.click();
    extentTest.pass("Check availability butonu gorunurlugunu test edildi.");

      // sayfa kapatildi
    Driver.closeDriver();
  }


}
