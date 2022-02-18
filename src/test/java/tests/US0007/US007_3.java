package tests.US0007;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
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

public class US007_3 extends TestBaseRapor {
    Actions actions = new Actions(Driver.getDriver());
    HMCMainPage hmcMainPage=new HMCMainPage();
    SoftAssert softAssert;
    HotelMyCampPage hotelMyCampPage=new HotelMyCampPage();
    @BeforeMethod
    public void AanaSayfaGiris() {

    }

    @Test
    public void sayfayaSifreyleGirisYapildiginaDairTest() {
        extentTest=extentReports.createTest("Sayfaya Sifreyle Giris Yapildigina Dair Test","Sayfaya Sifreyle Giris Yapildigina Dair Test Edildi");
        hmcMainPage.anaSayfayaGit();
        extentTest.info("HMC Sayfasina Gidildi");
//3-) Yonetici Onceden Belirlenen Sifreyle Giris Yaptigini Teyit Eder
//Ve Yonetici Hotel Management (DD) Aktif Oldugunu Teyit Eder
        hmcMainPage. ilkLoginElementi.click();
        Assert.assertTrue(hmcMainPage.sifreGirmeSayfasiCategories.isDisplayed(), "ilk Login Butonuna Tiklanamadi FAILED");
        hmcMainPage.userNameBox.sendKeys(ConfigReader.getProperty("HMCValidUsername"));
        hmcMainPage. passwordBox.sendKeys(ConfigReader.getProperty("HMCValidPassword"));
        hmcMainPage. idveSifreyeGirLoginButonu.click();
        Assert.assertTrue(hmcMainPage.yoneticiOlarakGirisYapilincaCikanListOfUsersElementi.isDisplayed(), "Yonetici Olarak Sayfaya Giris Yapilamadi FAILED");
        ReusableMethods.waitFor(5);
        extentTest.pass("Sayfaya Sifreyle Giris Yapildigina Dair Test Basariyla TAMAMLANDI :)");
      //  hotelMyCampPage.closeTheWindow();
    }

}
