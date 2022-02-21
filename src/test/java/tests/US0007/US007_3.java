package tests.US0007;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
//3-) Yonetici Onceden Belirlenen Sifreyle Giris Yaptigini Teyit Eder
//Ve Yonetici Hotel Management (DD) Aktif Oldugunu Teyit Eder
//hotelMyCampPage. hmcIlkLogin.click();
        WebElement ilkLoginButonunaTikla=Driver.getDriver().findElement(By.xpath("//li[contains( @id, 'Log')]"));
        ReusableMethods.waitForVisibility(ilkLoginButonunaTikla,20);
        ilkLoginButonunaTikla.click();
//ReusableMethods.waitFor(3);
//ReusableMethods.waitForVisibility(hotelMyCampPage.userNameBox07,30);
//ReusableMethods.waitFor(3);


        hmcMainPage.userNameBox.sendKeys(ConfigReader.getProperty("HMCValidUsername"));
        hmcMainPage. passwordBox.sendKeys(ConfigReader.getProperty("HMCValidPassword"));

        Assert.assertTrue(hotelMyCampPage.createaNewAccountButonu.isEnabled(), "ilk Login Butonuna Tiklanamadi FAILED");
        hmcMainPage. idveSifreyeGirLoginButonu.click();
        Assert.assertTrue(hmcMainPage.yoneticiOlarakGirisYapilincaCikanListOfUsersElementi.isDisplayed(), "Yonetici Olarak Sayfaya Giris Yapilamadi FAILED");
        actions.moveToElement(hotelMyCampPage.managerDropDownButton).perform();
        ReusableMethods.waitFor(2);
        hotelMyCampPage.logOutButton.click();
        extentTest.pass("Sayfaya Sifreyle Giris Yapildigina Dair Test Basariyla TAMAMLANDI :)");
      //  hotelMyCampPage.closeTheWindow();
    }

}
