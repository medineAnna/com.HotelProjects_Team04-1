package tests.US0008;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.OrtakHMCPageBurayiSakinKurcalama.HMCMainPage;
import pages.PagesUS0008.HotelMyCampPage08;
import utilities.TestBaseRapor;

public class TC_03 extends TestBaseRapor {

    @Test
    public void TC003(){

        HMCMainPage hmcMainPage=new HMCMainPage();

        HotelMyCampPage08 hotelMyCampPage08=new HotelMyCampPage08();

        extentTest=extentReports.createTest("TC003 Create Hotelroomreservation","Create Hotelroomreservation");

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

        //"Create Hotelroomreservatıon" yazisi gorunur
        Assert.assertTrue(hotelMyCampPage08.createHotelroomreservationYazisi.isDisplayed());
        extentTest.pass("Create Hotelroomreservation test edildi");
    }

}

