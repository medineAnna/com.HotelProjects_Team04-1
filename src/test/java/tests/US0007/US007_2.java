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
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US007_2 extends TestBaseRapor {
    HMCMainPage hmcMainPage=new HMCMainPage();


    @Test
    public void ilkLoginButonuGorunurveAktifmiTesti() {

extentTest=extentReports.createTest("Ilk Login Butonu Gorunur ve Aktif mi Testi","ilkLogin Butonu Gorunur ve Aktifmi Test Edildi");
        hmcMainPage.anaSayfayaGit();
// 2-)Yonetici Login Butonunun Gorunur Aktif  Oldugunu Kontrol Eder
// ve Tiklayip  onceden belirlenen sifreyle giris yapar.
        WebElement ilkLoginButonu07=Driver.getDriver().findElement(By.xpath("//li[contains( @id, 'Log')]"));
        Assert.assertTrue(ilkLoginButonu07.isDisplayed(), "Ilk Anasayfa Login Butonu GORUNUR  DEGIL");
        Assert.assertTrue(ilkLoginButonu07.isEnabled(), "Ilk Anasayfa Login Butonu AKTIF  DEGIL");

        extentTest.pass("Ilk Login Butonu Gorunur ve Aktif mi Testi Basariyla TAMAMLANDI :)");
      // hotelMyCampPage.closeTheWindow();

    }

}
