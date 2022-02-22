package tests.US0008;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.OrtakHMCPageBurayiSakinKurcalama.HMCMainPage;
import pages.PagesUS0008.HotelMyCampPage08;
import utilities.TestBaseRapor;

public class TC_02 extends TestBaseRapor {

    @Test
    public void TC002(){

        HMCMainPage hmcMainPage=new HMCMainPage();

        HotelMyCampPage08 hotelMyCampPage08=new HotelMyCampPage08();

        extentTest=extentReports.createTest("TC002 ADD ROOM RESERVATION","ADD ROOM RESERVATION");

        //Yönetici url'e gider.
        //Login butonunu tiklar.
        hmcMainPage.anaSayfayaGit();
        extentTest.info("anasayfaya gidildi");

        hmcMainPage.yoneticiOlarakGirisYap();

        //  "LISTOFUSERS" yazisi gorunur
        Assert.assertTrue(hotelMyCampPage08.yoneticiOlarakGirisYapilincaCikanListOfUsersElementi.isDisplayed());
        extentTest.info("LISTOFUSERS yazisi");

        //"Hotel management" kismina tiklar.
        hotelMyCampPage08.hotelManagementElementi.click();
        extentTest.info("Hotel management yazisi");


        //"Room reservations" kismina tiklar.
        hotelMyCampPage08.roomReservationsElementi.click();
        extentTest.pass("Room reservations test edildi");

        //"ADD ROOM RESERVATION'a" tiklar
        Assert.assertTrue(hotelMyCampPage08.addRoomReservationElementi.isDisplayed());
         extentTest.pass("ADD ROOM RESERVATION yazisi test edildi");




    }
}
