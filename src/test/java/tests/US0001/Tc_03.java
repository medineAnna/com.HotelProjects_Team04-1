package tests.US0001;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.pagesUS0001.HotelMyCampPage;
import utilities.ConfigReader;
import utilities.Driver;

public class Tc_03 {
  @Test
    public void tc03Testi(){


      // 1-kullanici url e gider

      HotelMyCampPage hotelMyCamHpPage = new HotelMyCampPage();
      Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));


      //2-Kullanici rezervasyon kutularini ve check availability butonunun gorunur oldugunu ve tiklanabilir oldugunu test et

      // checkIn butonu gorunurlugunu test et
     // checkIN butonuna tikla
      Assert.assertTrue(hotelMyCamHpPage.checkIn.isDisplayed());
      hotelMyCamHpPage.checkIn.click();

    // checkOut butonu gorunurlugunu test et
    // checkOut butonuna tikla
      Assert.assertTrue(hotelMyCamHpPage.checkOut.isDisplayed());
      hotelMyCamHpPage.checkOut.click();

    // RoomType butonu gorunurlugunu test et
    // RoomType butonuna tikla
      Assert.assertTrue(hotelMyCamHpPage.roomTypeDropdown.isDisplayed());
      hotelMyCamHpPage.roomTypeDropdown.click();

    // Customer butonu gorunurlugunu test et
    // Customer butonuna tikla
      Assert.assertTrue(hotelMyCamHpPage.addCustomer.isDisplayed());
      hotelMyCamHpPage.addCustomer.click();

    // Check availability butonu gorunurlugunu test et
    // Check availability butonuna tikla
      Assert.assertTrue(hotelMyCamHpPage.CheckAvailabilityButonu.isDisplayed());
      hotelMyCamHpPage.CheckAvailabilityButonu.click();



      // sayfa kapatildi
    Driver.closeDriver();
  }


}
