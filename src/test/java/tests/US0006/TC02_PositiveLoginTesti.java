package tests.US0006;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.OrtakHMCPageBurayiSakinKurcalama.HMCMainPage;
// import pages.pagesUS0006.HMCHotelRoomPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC02_PositiveLoginTesti extends TestBaseRapor {

    HMCMainPage hmcMainPage;
  //  HMCHotelRoomPage hmcHotelRoomPage;

    @Test
    public void positiveLoginTesti(){
        extentTest=extentReports.createTest("US0006_TC02","Positive Login Testi");
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
        Assert.assertTrue(hmcMainPage.yoneticiOlarakGirisYapilincaCikanListOfUsersElementi.isDisplayed());
        extentTest.pass("list of users sayfasina ulasildi");
    }
}
