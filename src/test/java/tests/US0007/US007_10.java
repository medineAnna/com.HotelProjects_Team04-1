package tests.US0007;

import org.openqa.selenium.By;
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

public class US007_10 extends TestBaseRapor {
    Actions actions = new Actions(Driver.getDriver());
    HMCMainPage hmcMainPage=new HMCMainPage();
    SoftAssert softAssert;
    HotelMyCampPage hotelMyCampPage=new HotelMyCampPage();



    @Test
    public void propertiesSayfasiErisimTesti() {
        extentTest=extentReports.createTest("Properties Sayfasi Erisim Testi","Properties Sayfasi Erisim Test Edildi");
        hmcMainPage.anaSayfayaGit();
//9
        hotelMyCampPage.direkPropertiesSayfasinaGit();
        Select select = new Select(hmcMainPage.propertiesdekiTipDropDownElementi);
// Propertiesde Girdigimizi Kontrol Icin Tip DD leri yazdiriniz
        List<WebElement> tipDDElementi = select.getOptions();
        for (WebElement each : tipDDElementi) {
            System.out.print("Tip DD Listesi =>" + each.getText() + " ");

        }
        ReusableMethods.waitFor(3);
        actions.moveToElement(hotelMyCampPage.managerDropDownButton).perform();
        ReusableMethods.waitFor(2);
        hotelMyCampPage.logOutButton.click();
               extentTest.pass("Properties Sayfasi Erisim Testi BASARIYLA TEST EDILDI:) ");
    }

}
