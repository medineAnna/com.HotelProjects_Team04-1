package tests.US0007;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.OrtakHMCPageBurayiSakinKurcalama.HMCMainPage;
import pages.pagesUS0007.HotelMyCampPage;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;

public class US007_12  extends TestBaseRapor {
    Actions actions = new Actions(Driver.getDriver());
    HMCMainPage hmcMainPage=new HMCMainPage();
    SoftAssert softAssert;
    HotelMyCampPage hotelMyCampPage=new HotelMyCampPage();

    @Test
    public void odaBilgileriSilmeTesti() throws IOException {
        extentTest=extentReports.createTest("Oda Bilgileri Silme Testi","Oda Bilgileri Silme Test Edildi");
        hmcMainPage.anaSayfayaGit();
//11
        hotelMyCampPage.direkGeneralDataSayfasinaGit();
        hotelMyCampPage.hotelRoomDeleteDatasiGonderme("0007","MustafaDRoom10",
                "Muslihittin mah. No:48  Afrika ",
                "Huzurlu ve Mutlu tatilin adresi",
                "510.000","5","1");
        hotelMyCampPage.generalDataSaveButonuElementi.click();
        hotelMyCampPage.generalDataUpdateOKButonElementi.click();
        ReusableMethods.waitFor(2);
        hotelMyCampPage.generalDataDeleteButonuElementi.click();
        ReusableMethods.waitFor(2);
        hotelMyCampPage.generalDataSaveClickOkButonu.click();// ////*********

        WebElement errorYazisi=Driver.getDriver().findElement(By.xpath("//div[@class='bootbox-body']"));
        Assert.assertFalse(errorYazisi.isDisplayed());//Dogru
        ReusableMethods.getScreenshot("Oda Bilgileri Silinemedi Yazisi (US07)");

        ReusableMethods.waitFor(3);//wsadasd
        actions.moveToElement(hotelMyCampPage.managerDropDownButton).perform();
        ReusableMethods.waitFor(2);
        hotelMyCampPage.logOutButton.click();
        extentTest.pass("Oda Bilgilerini Silme Test Edildi :)");
    }


}
