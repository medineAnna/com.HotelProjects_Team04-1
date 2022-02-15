package tests.US0007;

import org.openqa.selenium.Keys;
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

public class US007_7 extends TestBaseRapor {
    Actions actions = new Actions(Driver.getDriver());
    HMCMainPage hmcMainPage=new HMCMainPage();
    SoftAssert softAssert;
    HotelMyCampPage hotelMyCampPage=new HotelMyCampPage();

    @Test
    public void webTable5inciSayfa10SatirDetailsvePropertieseGirisTesti() {
        extentTest=extentReports.createTest("WebTable 5. Sayfa 10. Satir Details ve Propertiese Giris Testi","WebTable 5. Sayfa 10. Satir Details ve Propertiese Giris Test Edildi");
        hmcMainPage.anaSayfayaGit();
//  7-) //WebTable 5. safya 10. Satir daki Details Butonunun
//  Erisilebilir Oldugunu Kontrol Ederek
//  Details Butonuna Tikla ve Tiklandigini Kontrol Et
        hotelMyCampPage.hotelRoomsWebTablinIsteginSayfasinaGit(5);
//WebTable 5. sayfa 10.satirdaki detailse tikla
        Assert.assertTrue(hotelMyCampPage.hotelRoomsIlkSayfaWebTables(10, 9).isEnabled(), "WebTables 5. sayfa 10. satirdaki Details Butonuna ERISILEMIYOR FAILED");
        ReusableMethods.waitFor(2);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(2);
        hotelMyCampPage. webTableSayfasindakiIsteginDetailsButonunaDirekTikla(10, 9);
//edit hotel Room yazisi Elementi gorunuyormu
        Assert.assertTrue(hmcMainPage.editHotelRoomYaziElementi.isEnabled(), "WebTable 5. sayfa 10 satir details Butonuna Tiklanamadi FAILED");
//Propertiese Tiklandi testi yap
        hmcMainPage.propertiesSekmesiElementi.click();
        Assert.assertTrue(hmcMainPage.addPropertyYaziElementi.isEnabled());
        ReusableMethods.waitFor(5);
        extentTest.pass("WebTable 5. Sayfa 10.Satir Details ve Propertiese Giris Testi Basariyla TAMAMLANDI :)");
       // hotelMyCampPage.closeTheWindow();
    }

}
