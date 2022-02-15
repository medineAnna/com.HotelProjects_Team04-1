package tests.US0007;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.OrtakHMCPageBurayiSakinKurcalama.HMCMainPage;
import pages.pagesUS0007.HotelMyCampPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;

public class US007_11 extends TestBaseRapor {
    Actions actions = new Actions(Driver.getDriver());
    HMCMainPage hmcMainPage=new HMCMainPage();
    SoftAssert softAssert;
    HotelMyCampPage hotelMyCampPage=new HotelMyCampPage();



    @Test
    public void odaBilgileriSilmeTesti() throws IOException {
        extentTest=extentReports.createTest(" Oda Bilgileri Silme Testi"," OdaBilgileri Silme Test Edildi");
//11
        hmcMainPage.anaSayfayaGit();
        hotelMyCampPage.direkGeneralDataSayfasinaGit();
        hotelMyCampPage.hotelRoomDeleteDatasiGonderme("0007","MustafaDRoom1",
                "Muslihittin mah. No:48  Afrika ",
                "Huzurlu ve Mutlu tatilin adresi",
                "500.000","5","1");
        hotelMyCampPage.generalDataSaveButonuElementi.click();
        hotelMyCampPage.generalDataUpdateOKButonElementi.click();
        ReusableMethods.waitFor(2);
        hotelMyCampPage.generalDataDeleteButonuElementi.click();
        ReusableMethods.waitFor(2);
        hotelMyCampPage.generalDataSaveClickOkButonu.click();
        hotelMyCampPage.endUserName.sendKeys(ConfigReader.getProperty("HMCValidUsername"));
        hotelMyCampPage.endPassword.sendKeys(ConfigReader.getProperty("HMCValidPassword"));
        hotelMyCampPage.endLogInButton.click();
        hotelMyCampPage.listOfHotelRoomsNameBoxDataPush("MustafaDRoom1");
        hotelMyCampPage.listOfHotelRoomsyellowSearchButton.click();
//ReusableMethods.getScreenshot("Oda Bilgileri Silindi Teyit Photos");
        ReusableMethods.waitFor(5);
        extentTest.pass("Oda Bilgileri Silme Testi Basariyla TAMAMLANDI :)");
       // hotelMyCampPage.closeTheWindow();

    }

}

