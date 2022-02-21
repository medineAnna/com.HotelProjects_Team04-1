package tests.US0007;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
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

import java.util.List;

public class US007_9 extends TestBaseRapor {
    Actions actions = new Actions(Driver.getDriver());
    HMCMainPage hmcMainPage=new HMCMainPage();
    SoftAssert softAssert;
    HotelMyCampPage hotelMyCampPage=new HotelMyCampPage();


@Test
    public void photosSayfasinaGirisTesti(){
    extentTest=extentReports.createTest("Photos Sayfasina Giris Testi ","Photos Sayfasina Giris Test Edildi");
    hmcMainPage.anaSayfayaGit();
//8
    hotelMyCampPage.direkPhotostSayfasinaGit();
    Assert.assertTrue(hmcMainPage.upLoadFilesElementi.isEnabled());
    ReusableMethods.waitFor(3);
    actions.moveToElement(hotelMyCampPage.managerDropDownButton).perform();
    ReusableMethods.waitFor(2);
    hotelMyCampPage.logOutButton.click();
    extentTest.pass("Photos Sayfasina Giris Basariyla TAMAMLANDI :)");
    }
}

//8
