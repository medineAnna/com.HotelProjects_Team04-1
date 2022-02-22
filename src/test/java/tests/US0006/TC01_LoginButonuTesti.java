package tests.US0006;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.OrtakHMCPageBurayiSakinKurcalama.HMCMainPage;
import pages.US0006.HMCHotelRoomPage;
import pages.US0006.HMCHotelRoomPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC01_LoginButonuTesti extends TestBaseRapor {
    HMCMainPage hmcMainPage;
    HMCHotelRoomPage hmcHotelRoomPage;

    @Test
    public void loginButonuTesti(){
        extentTest=extentReports.createTest("US0006_TC01", "Login Butonu Testi");
        hmcHotelRoomPage=new HMCHotelRoomPage();
        hmcMainPage=new HMCMainPage();
        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
        extentTest.info("HotelMyCamp sayfasina gidildi");
        hmcMainPage.ilkLoginElementi.click();
        extentTest.info("ilk login elementine tiklandi");
        Assert.assertTrue(hmcHotelRoomPage.loginyazisiElementi.isDisplayed());
        extentTest.pass("login sayfasina ulasildi");
        // denemeeeeeeee

    }






}
