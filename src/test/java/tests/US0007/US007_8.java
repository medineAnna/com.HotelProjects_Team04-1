package tests.US0007;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.OrtakHMCPageBurayiSakinKurcalama.HMCMainPage;
import pages.pagesUS0007.HotelMyCampPage;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US007_8 extends TestBaseRapor {
    Actions actions = new Actions(Driver.getDriver());
    HMCMainPage hmcMainPage=new HMCMainPage();
    SoftAssert softAssert;
    HotelMyCampPage hotelMyCampPage=new HotelMyCampPage();


    @Test

    public void photosSayfasinaGirisTesti() {
//8
        extentTest=extentReports.createTest("Photos Sayfasina Giris Testi","Photos Sayfasina Giris Test Edildi");
        hmcMainPage.anaSayfayaGit();
        hotelMyCampPage.direkPhotostSayfasinaGit();
        Assert.assertTrue(hmcMainPage.upLoadFilesElementi.isEnabled());
        ReusableMethods.waitFor(5);
        extentTest.pass("Photos Sayfasina Giris Testi Basariyla TAMAMLANDI :)");
       // hotelMyCampPage.closeTheWindow();
    }

}
