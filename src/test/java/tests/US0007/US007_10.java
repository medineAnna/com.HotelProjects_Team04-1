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

public class US007_10 extends TestBaseRapor {
    Actions actions = new Actions(Driver.getDriver());
    HMCMainPage hmcMainPage=new HMCMainPage();
    SoftAssert softAssert;
    HotelMyCampPage hotelMyCampPage=new HotelMyCampPage();



    @Test
//10
    public void odaBilgileriGuncellemeTesti(){
        extentTest=extentReports.createTest("Oda Bilgileri Guncelleme Testi","Oda Bilgileri Guncelleme Test Edildi ");
        hmcMainPage.anaSayfayaGit();
        hotelMyCampPage.direkGeneralDataSayfasinaGit();
        hotelMyCampPage. hotelRoomGuncellemeDatasiGonderme("0007","MustafaDRoom1",
                "Muslihittin mah. No:48  Afrika ",
                "Huzurlu ve Mutlu tatilin adresi",
                "500.000","5","1");
        Assert.assertTrue(hotelMyCampPage.generalDataRoomsUpdateText.isDisplayed(),"Room Guncellenemedi FAILED");
        hotelMyCampPage.generalDataUpdateOKButonElementi.click();
        Driver.getDriver().navigate().back();
        hotelMyCampPage.listOfHotelRoomsNameBoxDataPush("MustafaDRoom1");
        hotelMyCampPage.listOfHotelRoomsyellowSearchButton.click();
        ReusableMethods.waitFor(3);
        String actualText=hotelMyCampPage.listOfHotelRoomsNameElementi.getText();
        WebElement odaKayitNameYazisi=Driver.getDriver().findElement(By.xpath("//td[.='MustafaDRoom1']"));
        Assert.assertTrue(odaKayitNameYazisi.isDisplayed(),"Oda Kaydi Basarisiz");
        ReusableMethods.waitFor(5);
        extentTest.pass("Oda Bilgileri Guncelleme Testi Basariyla TAMAMLANDI :)");
       // hotelMyCampPage.closeTheWindow();
    }

}
