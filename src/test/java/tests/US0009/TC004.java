package tests.US0009;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.OrtakHMCPageBurayiSakinKurcalama.HMCMainPage;
import pages.US0009.US009Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC004 extends TestBaseRapor {
    //1-yonetici url e gider
    //2-Yonetici olarak giris yapar
    //3-"Rom reservaton" linkine tiklar
    //4- "List of Reservation" tablosunu gorur
    //5-Herhangi bir otel icin Details butonuna tiklar
    //6-"Edit Hotelroomreservatıon" sayfasini gorur
    //7-ContactPhone ve ContactEmail bilgileri degistirir
    //8-Save butonuna basar


    HMCMainPage hmcMainPage;
    US009Page us009Page;
    @Test
    public void editRoomAndSaveReservation() {
        extentTest=extentReports.createTest("US0009_TC04", "Edit Hotel room reservation and save Test");

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

        Faker faker = new Faker();
        us009Page.contactPhoneTextBox.clear();
        us009Page.contactPhoneTextBox.sendKeys(faker.phoneNumber().cellPhone());

        us009Page.contactEmailTextBox.clear();
        us009Page.contactEmailTextBox.sendKeys(faker.internet().emailAddress());
        extentTest.info("yeni telefon numarsi ve mail adresi girildi");
        us009Page.saveButton.click();
        extentTest.info("save butonuna tiklandi");

        Assert.assertTrue(us009Page.saveEdildi.isEnabled());
        extentTest.pass("degisiklikler kaydedildi");
    }
}
