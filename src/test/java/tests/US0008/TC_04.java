package tests.US0008;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.OrtakHMCPageBurayiSakinKurcalama.HMCMainPage;
import pages.PagesUS0008.HotelMyCampPage08;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC_04 extends TestBaseRapor {

    @Test
    public void TC004(){


        Actions actions=new Actions(Driver.getDriver());

        HMCMainPage hmcMainPage=new HMCMainPage();

        HotelMyCampPage08 hotelMyCampPage08=new HotelMyCampPage08();

        extentTest=extentReports.createTest("TC004 SAVE testi","SAVE testi");

        //Yönetici url'e gider.
        //Login butonunu tiklar.
        hmcMainPage.anaSayfayaGit();
        hmcMainPage.yoneticiOlarakGirisYap();
        extentTest.info("anasayfaya gidildi");

        //"Hotel management" kismina tiklar.
        hotelMyCampPage08.hotelManagementElementi.click();
        extentTest.info("Hotel management yazisi");

        //"Room reservations" kismina tiklar.
        hotelMyCampPage08.roomReservationsElementi.click();
        extentTest.info("Room reservations test edildi");

        //"ADD ROOM RESERVATION'a" tiklar
        hotelMyCampPage08.addRoomReservationElementi.click();
        extentTest.info("ADD ROOM RESERVATION yazisi test edildi");

        //"Create Hotelroomreservatıon" sayfasinda gerekli bilgiler girilir
        Assert.assertTrue(hotelMyCampPage08.createHotelroomreservationYazisi.isDisplayed());
        extentTest.info("Create Hotelroomreservatıon test edildi");



        Select select=new Select(hotelMyCampPage08.iduser1Elementi);

         select.selectByIndex(1);

         Select select1=new Select(hotelMyCampPage08.iduser2Elementi);
         select1.selectByIndex(3);


         hotelMyCampPage08.priceElementi.click();

         actions.sendKeys("1000").sendKeys(Keys.TAB).sendKeys("02/23/2022")
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys("02/26/2022").sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).sendKeys("1").sendKeys(Keys.TAB).sendKeys("0").sendKeys(Keys.TAB)
                .sendKeys("Mehmet MEHMET").sendKeys(Keys.TAB).sendKeys("9999999999").sendKeys(Keys.TAB)
                 .sendKeys("hello@gmail.com").sendKeys(Keys.TAB).sendKeys("İYİ TATİLLER PATRON")
                 .sendKeys(Keys.TAB).perform();

         //"Approved" butonu tiklanir
         hotelMyCampPage08.approvedButonu.click();
         extentTest.info("Approved test edildi");

         //"SAVE" butonu tiklanir
         hotelMyCampPage08.saveButonu.click();
         extentTest.info("SAVE test edildi");

    }
}
