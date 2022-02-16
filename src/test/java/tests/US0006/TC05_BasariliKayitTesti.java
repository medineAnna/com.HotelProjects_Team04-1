package tests.US0006;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.OrtakHMCPageBurayiSakinKurcalama.HMCMainPage;
import pages.US0006.HMCHotelRoomPage;
import pages.US0006.HMCHotelRoomPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.util.Random;

public class TC05_BasariliKayitTesti extends TestBaseRapor {
    HMCMainPage hmcMainPage;
    HMCHotelRoomPage hmcHotelRoomPage;


    @Test
    public void basariliKayitTesti(){
        extentTest=extentReports.createTest("US0006_TC05","basarili kayit testi");
        hmcHotelRoomPage=new HMCHotelRoomPage();
        hmcMainPage=new HMCMainPage();

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
        hmcMainPage.hotelManagementElementi.click();
        extentTest.info("hotel management elementine tiklandi");
        hmcMainPage.hotelRoomsElementi.click();
        extentTest.info("hotel rooms elementine tiklandi");
        hmcHotelRoomPage.addHotelRoomButonu.click();
        extentTest.info("add hotelroom butonuna tiklandi");

        Select select=new Select(hmcHotelRoomPage.addHotelDropdown);
        Random random=new Random();
        select.selectByIndex(random.nextInt(460));
        Actions actions=new Actions(Driver.getDriver());
        Faker faker=new Faker();
        actions.click(hmcHotelRoomPage.addHotelCodeKutusu).
               sendKeys(faker.address().zipCode())
               .sendKeys(Keys.TAB)
               .sendKeys(faker.name().fullName())
               .sendKeys(Keys.TAB)
               .sendKeys(faker.address().city())
               .sendKeys(Keys.TAB)
               .sendKeys(faker.expression(random.toString()).toLowerCase())
               .sendKeys(Keys.TAB)
               .sendKeys(faker.number().digit()).perform();
       Select slct=new Select(hmcHotelRoomPage.roomTypeDropdown);
       slct.selectByIndex(random.nextInt(9));

       actions.click(hmcHotelRoomPage.maxAdultCountElementi)
               .sendKeys(faker.number().digit())
               .sendKeys(Keys.TAB)
               .sendKeys(faker.number().digit())
               .sendKeys(Keys.TAB)
               .click(hmcHotelRoomPage.approvedElementi)
               .sendKeys(Keys.TAB).
               click(hmcHotelRoomPage.addHotelSaveButonu).
               perform();
       ReusableMethods.waitFor(3);
       extentTest.info("kutucuklari dolduruldu ve save butonuna basildi");

      Assert.assertTrue(hmcHotelRoomPage.basariliOdaEklemeElementiYazisi.isDisplayed());
       extentTest.pass("odanin basarili bir sekilde eklendigi goruldu");

       hmcHotelRoomPage.okElementi.click();









    }
}
