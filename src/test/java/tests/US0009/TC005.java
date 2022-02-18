package tests.US0009;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.OrtakHMCPageBurayiSakinKurcalama.HMCMainPage;
import pages.US0009.US009Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC005 extends TestBaseRapor {

    HMCMainPage hmcMainPage;
    US009Page us009Page;
    @Test
    public void roomReservation() {
        extentTest=extentReports.createTest("US0009_TC04", "Delete reservation Test");

        hmcMainPage=new HMCMainPage();
        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));

        extentTest.info("HotelMyCamp sayfasina gidildi");
        hmcMainPage.ilkLoginElementi.click();
        extentTest.info("ilk login elementine tiklandi");
        hmcMainPage.userNameBox.sendKeys(ConfigReader.getProperty("HMCValidUsername"));
        hmcMainPage.passwordBox.sendKeys(ConfigReader.getProperty("HMCValidPassword"));
        hmcMainPage.idveSifreyeGirLoginButonu.click();
        extentTest.info("yonetici olarak giris yapildi");
        us009Page = new US009Page();
        hmcMainPage.hotelManagementElementi.click();
        extentTest.info("Hotel Management Elementi gorundu");

        Assert.assertTrue( us009Page.roomReservationButton.isEnabled());

        extentTest.info("Rom reservation elementi gorundu ");

        us009Page.roomReservationButton.click();
        extentTest.info("Rom reservation sayfasina gidildi");

        us009Page.first1DetailButton.click();

        Assert.assertTrue(us009Page.hotelReservationDataElement.isEnabled());
        extentTest.info("Edit Hotelroomreservatıon sayfasina gidildi");

        Actions actions = new Actions(Driver.getDriver());

        actions.sendKeys(Keys.END).perform();

        us009Page.deleteButton.click();
        extentTest.info("delete butonuna tiklandi");



        Assert.assertTrue(us009Page.saveEdildi.isEnabled());
        extentTest.pass("room reservation silindi");
    }
}
