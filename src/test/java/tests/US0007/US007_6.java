package tests.US0007;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.OrtakHMCPageBurayiSakinKurcalama.HMCMainPage;
import pages.pagesUS0007.HotelMyCampPage;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;

public class US007_6 extends TestBaseRapor {
    Actions actions = new Actions(Driver.getDriver());
    HMCMainPage hmcMainPage=new HMCMainPage();
    SoftAssert softAssert;
    HotelMyCampPage hotelMyCampPage=new HotelMyCampPage();


    @Test
    public void webTablein5SayfadakiBilgilereErismeTesti() throws IOException {
        extentTest=extentReports.createTest("Web Table'in 5. Sayfadaki Bilgilere Erisme Testi","Web Table'in 5. Sayfadaki Bilgilere Erismesi Test Edildi ");
        hmcMainPage.anaSayfayaGit();
//6-)Web Table 5.Tablo Sayfasi Bilgilerine Eristigini Screen Shot la Teyit Et
        hotelMyCampPage. hotelRoomsWebTablinIsteginSayfasinaGit(5);
//ReusableMethods.getScreenshot("WebTable5.SayfaGoruntusu");
        ReusableMethods.waitFor(5);
        extentTest.pass("Web Table'in 5. Sayfadaki Bilgilere Erisme Testi Basariyla TAMAMLANDI :)");
       // hotelMyCampPage.closeTheWindow();
    }

}
