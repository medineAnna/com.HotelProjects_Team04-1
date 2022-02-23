package tests.US0006;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.OrtakHMCPageBurayiSakinKurcalama.HMCMainPage;
import pages.US0006.HMCHotelRoomPage;
import pages.US0006.HMCHotelRoomPage;
import pages.pagesUS0007.HotelMyCampPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC04_CreateHotelroomTesti extends TestBaseRapor {
    HMCMainPage hmcMainPage;
    HMCHotelRoomPage hmcHotelRoomPage;

    @Test
    public void createHotelroomTesti(){
        extentTest=extentReports.createTest("US0006_TC04","Create hotelroom Testi");
        hmcHotelRoomPage=new HMCHotelRoomPage();
        hmcMainPage=new HMCMainPage();
        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
        extentTest.info("HotelMyCamp sayfasina gidildi");
        hmcMainPage=new HMCMainPage();
        hmcMainPage.ilkLoginElementi.click();
        extentTest.info("ilk login elementine tiklandi");
        hmcMainPage.userNameBox.sendKeys(ConfigReader.getProperty("HMCValidUsername"));
        extentTest.info("kullanici adi girildi");
        hmcMainPage.passwordBox.sendKeys(ConfigReader.getProperty("HMCValidPassword"));
        extentTest.info("sifre girildi");
        ReusableMethods.waitFor(1);
        hmcMainPage.idveSifreyeGirLoginButonu.click();
        extentTest.info("giris icin login butonuna basildi");
        hmcMainPage.hotelManagementElementi.click();
        extentTest.info("hotel management elementine tiklandi");
        hmcMainPage.hotelRoomsElementi.click();
        extentTest.info("hotel rooms elementine tiklandi");
        hmcHotelRoomPage.addHotelRoomButonu.click();
        extentTest.info("add hotelroom butonuna tiklandi");
        Assert.assertTrue( hmcHotelRoomPage.createHotelroomElementi.isDisplayed());
        HotelMyCampPage ho = new HotelMyCampPage();
        ho.logOutButton.click();
        Driver.closeDriver();

        extentTest.pass("create hotelroom sayfasina ulasildi");

    }

}
