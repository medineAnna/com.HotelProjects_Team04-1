package SmokeTest_Package;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HMCPage10;
import pages.OrtakHMCPageBurayiSakinKurcalama.HMCMainPage;
import pages.PagesUS0008.HotelMyCampPage08;
import pages.US0002.HotelMyCampPage;
import pages.US0006.HMCHotelRoomPage;
import pages.US0009.US009Page;
import pages.pagesUS0003.HMCPageUS003;
import pages.pagesUS0004.HMCHotelListPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;

public class ProjeSmokeTest extends TestBaseRapor {

    HMCMainPage hmcMainPage;
    HMCHotelRoomPage hmcHotelRoomPage;
    Actions actions = new Actions(Driver.getDriver());
    SoftAssert softAssert;
    pages.pagesUS0007.HotelMyCampPage hotelMyCampPage=new pages.pagesUS0007.HotelMyCampPage();
    US009Page us009Page;






//ben 2 dk ya geliyom bi calistiralim

    @Test(priority = 1)
    public void tc01Testi(){

        // kullanici url e gider
        Driver.getDriver().get("https://www.hotelmycamp.com");

        // url in dogrulugu test edilir
        String actualurl=Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualurl.contains("hotelmycamp"));
        Driver.closeDriver();
//1
    }
    @Test(priority = 2)
    public void managerYazisiGorunurTesti() throws  InterruptedException, IOException {

        //1-Yonetici Url gider
        //    2-"Login in" linki gorunurlulugunu kontrol eder
        //    3-"Login in" linkine tiklar
        //    4-Username textbox'unun gorunur oldugunu kontrol eder
        //    5-Username textbox'una usernamesinin girilip girilmedigini kontrol eder
        //    6-Password textbox'unun gorunur oldugunu kontrol eder
        //    7-Password textbox'una sifresinin girilip girilmedigini kontrol eder
        //    8-Login butonuna tiklar
        //    9-Login in butonunun gorunurlulugunu kontrol eder
        //    10-"manager" yazisinin gorunurlulugunu kontrol eder

        HotelMyCampPage hotelMyCampPage=new HotelMyCampPage();
        SoftAssert softAssert=new SoftAssert();

        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
        extentTest=extentReports.createTest("Manager sayfasina gitme","yonetici datalar ile login olunacak");

        softAssert.assertTrue(hotelMyCampPage.ilkLoginLinki.isDisplayed());
        extentTest.info("ilk Login butonu goruldu");

        hotelMyCampPage.ilkLoginLinki.click();
        extentTest.info("Ilk login linkine tiklandi");

        softAssert.assertTrue(hotelMyCampPage.usernameBox.isDisplayed());
        extentTest.pass("username textbox goruldu ");

        hotelMyCampPage.usernameBox.sendKeys(ConfigReader.getProperty("HMCValidUsername")+ Keys.ENTER);
        extentTest.info("Username textbox una kullanici adi girildi");

        softAssert.assertTrue(hotelMyCampPage.passwordBox.isDisplayed());
        extentTest.info("password textbox goruldu");

        hotelMyCampPage.passwordBox.sendKeys(ConfigReader.getProperty("HMCValidPassword")+Keys.ENTER);
        extentTest.info("password textbox'una sifre girildi");
        Thread.sleep(3000);

        softAssert.assertTrue(hotelMyCampPage.loginCercevesi.isDisplayed());
        extentTest.info("login butonu goruldu");

        hotelMyCampPage.loginCercevesi.click();
        extentTest.info("login butonuna tiklandi");

        softAssert.assertTrue(hotelMyCampPage.managerSayfaTest.isDisplayed());
        extentTest.info("manager system sayfasi gorunurlulugu test edildi");
        softAssert.assertAll();

        ReusableMethods.getScreenshot("Login butonuna tiklandi manager system sayfasina gidildi");
        extentTest.info("ekran goruntusu alindi");
        Driver.closeDriver();
        extentTest.info("sayfa kapatildi");
//2

    }
    @Test(priority = 3)
    public void us3Tc002() throws IOException {


        HMCPageUS003 hmcPageUS003 = new HMCPageUS003();
        //Step   1-Kullanici hotelmycamp sayfasına gider
        hmcPageUS003.anaSayfayaGit();


        //Step 2-Login butonunu tiklar
        hmcPageUS003.ilkLoginElementi.click();


        //Step 3-   3- 'Create new acccount' butonuna tiklar,  'Registration Form' sayfasina erisir
        Assert.assertTrue(hmcPageUS003.createNewAccountButonu.isDisplayed(), "create a new account butonu gorunur değil");
        hmcPageUS003.createNewAccountButonu.click();
        Assert.assertTrue(hmcPageUS003.RegistrationYazisi.isDisplayed());


        //Step 4-'Registration Form' sayfasindaki textboxlara istenen bilgileri girer
        Assert.assertTrue(hmcPageUS003.formEditTextboxlari.isEnabled());
        hmcPageUS003.degerGirTextoxRegistrationForm();

        //Step 5-'Save' butonuna tiklar
        Assert.assertTrue(hmcPageUS003.saveButonu.isDisplayed());
        hmcPageUS003.saveButonu.click();


        //Step   6-'User Data was inserted successfully' yazisini gorur
        ReusableMethods.getScreenshot("User Data was inserted successfully yazisi");
        Assert.assertTrue(hmcPageUS003.UseDatawasInsertedSuccessfullyyazisi.isDisplayed());
        hmcPageUS003.uDwISyazisiOkButonu.click();


     Driver.closeDriver();
        //3
    }
    @Test(priority = 4)
    public void US4TC7() {
        extentTest=extentReports.createTest("US004TC07",
                "form gecerli bilgilerle doldurulup Save edildiginde Hotel list'e eklendigi test edildi");

        HMCMainPage hmcMainPage = new HMCMainPage();
        HMCHotelListPage hmcHotelListPage = new HMCHotelListPage();
        //1- Yonetici url e gider.
        hmcMainPage.anaSayfayaGit();
        extentTest.info("Sayfaya girildi");
        //2- Login butonunu tiklar.
        //3- Yonetici kendisine verilen username ve password ile giris yapar.
        hmcMainPage.yoneticiOlarakGirisYap();
        extentTest.info("Yonetici olarak giris yapildi");
        //4- "Hotel management" kismina tiklar.
        hmcMainPage.hotelManagementElementi.click();
        extentTest.info("Hotel Management'a tiklandi");
        //5- Gorunur hale gelen "Hotel List" kismina tiklar.
        hmcHotelListPage.HotelListElementi.click();
        extentTest.info("\"Hotel List\" sayfasina girildi");
        //6- "Add Hotel" butonuna tiklar.
        hmcHotelListPage.AddHotelButtonElementi.click();
        extentTest.info("\"Add Hotel\" butonuna basildi");
        //7- "create hotel" formunu gecerli bilgiler ile doldurur.
        hmcHotelListPage.AddHotelFormDropdownaKadarGecerliDoldurma();
        Select select= new Select(hmcHotelListPage.AddHotelDropdownElementi);
        select.selectByIndex(1);
        ReusableMethods.waitFor(2);
        extentTest.info("\"Create Hotel form\"'u gecerli bilgilerle douduruldu");
        //8- Save butonuna tiklar.
        hmcHotelListPage.AddHotelSaveButton.click();
        extentTest.info("\"Save\" butonuna basildi");
        //9- "Hotel was inserted successfully" yazisini gorur.
        ReusableMethods.waitForVisibility(hmcHotelListPage.AddHotelBasariliKayityazisiElementi,15);
        Assert.assertTrue(hmcHotelListPage.AddHotelBasariliKayityazisiElementi.isDisplayed());
        extentTest.pass("\"Hotel was inserted successfully\" yazisini GORULDU");
        //Developer Hatasi 44. satir WebElement hic bir sekilde bulunamiyor
        ReusableMethods.waitForClickablility(hmcHotelListPage.AddHotelBasariliKayitOkButton,15);
        //10- OK butonuna tiklar.
        Assert.assertTrue(hmcHotelListPage.AddHotelBasariliKayitOkButton.isEnabled());
        extentTest.pass("\"OK\" butonun tiklanabilir oldugu GORULDU");
        hmcHotelListPage.AddHotelBasariliKayitOkButton.click();
        extentTest.info("\"OK\" butonuna basildi");

        //11- Yeniden "Hotel List" kismina tiklar.
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_UP).perform();
        ReusableMethods.waitFor(2);
        hmcHotelListPage.HotelListElementi.click();
        extentTest.info("\"Hotel List\" acildi");
        //12- Name sutunu altindaki Search textbox'a bir onceki adimda yazdigi hotel adini yazar.
        hmcHotelListPage.HotelListSearchNameTextBox.sendKeys(ConfigReader.getProperty("hotelName"));
        //13- sag kosedeki search buttonuna tiklar.
        ReusableMethods.waitFor(2);
        hmcHotelListPage.HotelListSearchButton.click();
        extentTest.info("search edildi");
        //14- Listede olusturdugu oteli gorur.
        Assert.assertFalse(hmcHotelListPage.FirstHotelAtSearchList.getText().isEmpty());
        extentTest.pass("Eklenen otel hotel listte GORULDU");
        pages.pagesUS0007.HotelMyCampPage ho = new pages.pagesUS0007.HotelMyCampPage();
     //   ReusableMethods.waitFor(5);

       // actions.moveToElement(hotelMyCampPage.managerDropDownButton).perform();
      //  ReusableMethods.waitFor(2);
     //   ho.logOutButton.click();

     Driver.closeDriver();
        //4
    }
    @Test(priority = 5)
    public void createHotelroomTesti(){
        extentTest=extentReports.createTest("US0006_TC04","Create hotelroom Testi");
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
        Assert.assertTrue( hmcHotelRoomPage.createHotelroomElementi.isDisplayed());
        pages.pagesUS0007.HotelMyCampPage ho = new pages.pagesUS0007.HotelMyCampPage();
        ReusableMethods.waitFor(2);
    //    actions.moveToElement(hotelMyCampPage.managerDropDownButton).perform();
    //    ReusableMethods.waitFor(2);
     //   ho.logOutButton.click();

      Driver.closeDriver();

        extentTest.pass("create hotelroom sayfasina ulasildi");
//5
    }
    @Test(priority = 6)
    public void TC004(){


        Actions actions=new Actions(Driver.getDriver());

        HMCMainPage hmcMainPage=new HMCMainPage();

        HotelMyCampPage08 hotelMyCampPage08=new HotelMyCampPage08();

        extentTest=extentReports.createTest("TC004 SAVE testi","SAVE testi");

        //Yönetici url'e gider.
        //Login butonunu tiklar.
        hmcMainPage.anaSayfayaGit();
        hmcMainPage.yoneticiOlarakGirisYap();
        extentTest.info("anasayfaya gidildi");

        //"Hotel management" kismina tiklar.
        hotelMyCampPage08.hotelManagementElementi.click();
        extentTest.info("Hotel management yazisi");

        //"Room reservations" kismina tiklar.
        hotelMyCampPage08.roomReservationsElementi.click();
        extentTest.info("Room reservations test edildi");

        //"ADD ROOM RESERVATION'a" tiklar
        hotelMyCampPage08.addRoomReservationElementi.click();
        extentTest.info("ADD ROOM RESERVATION yazisi test edildi");

        //"Create Hotelroomreservatıon" sayfasinda gerekli bilgiler girilir
        Assert.assertTrue(hotelMyCampPage08.createHotelroomreservationYazisi.isDisplayed());
        extentTest.info("Create Hotelroomreservatıon test edildi");



        Select select=new Select(hotelMyCampPage08.iduser1Elementi);

        select.selectByIndex(1);

        Select select1=new Select(hotelMyCampPage08.iduser2Elementi);
        select1.selectByIndex(3);


        hotelMyCampPage08.priceElementi.click();

        actions.sendKeys("1000").sendKeys(Keys.TAB).sendKeys("02/23/2022")
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys("02/26/2022").sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).sendKeys("1").sendKeys(Keys.TAB).sendKeys("0").sendKeys(Keys.TAB)
                .sendKeys("Mehmet MEHMET").sendKeys(Keys.TAB).sendKeys("9999999999").sendKeys(Keys.TAB)
                .sendKeys("hello@gmail.com").sendKeys(Keys.TAB).sendKeys("İYİ TATİLLER PATRON")
                .sendKeys(Keys.TAB).perform();

        //"Approved" butonu tiklanir
        ReusableMethods.waitFor(3);
        hotelMyCampPage08.approvedButonu.click();
        extentTest.info("Approved test edildi");

        //"SAVE" butonu tiklanir
        ReusableMethods.waitFor(3);
        hotelMyCampPage08.saveButonu.click();
        extentTest.info("SAVE test edildi");
        //pages.pagesUS0007.HotelMyCampPage ho = new pages.pagesUS0007.HotelMyCampPage();
    //    ReusableMethods.waitFor(2);
    //    actions.moveToElement(hotelMyCampPage.managerDropDownButton).perform();
     //   ReusableMethods.waitFor(2);
     //   ho.logOutButton.click();
        //6 ***
          Driver.closeDriver();
    }
    @Test(priority = 7)
    public void testCase05() throws InterruptedException {
        //http://www.hotelmycamp.com/ url'e gidilir
        //"Log in" butonuna tıklar
        //"Username" ve "password" bilgileri girilir ve "Log in" linkine tiklanir
        //"User Menu" altindaki "Reservations" buttonuna tiklanir
        //"Reservations" sayfasindaki reserve edilen oda kullanici sayfasinda gorulur

        extentTest=extentReports.createTest("testCase05","\"User menu\"den \"Reservations\" butonunu tiklayarak, otel reservasyonlarini gorebilmeli.");
        HMCPage10 hmcPage10=new HMCPage10();

        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
        extentTest.info("Url gidilir");

        hmcPage10.logInButtonu.click();
        extentTest.info("\"Log in\" butonuna tıklar");

        hmcPage10.usernameBox.sendKeys("MedinAnna" + Keys.ENTER);
        hmcPage10.passwordBox.sendKeys("aaaaaA6!" + Keys.ENTER);
        hmcPage10.ikinciLoginButonu.click();
        extentTest.info("\"Username\" ve \"password\" bilgileri girilir ve \"Log in\" linkine tiklanir");

        hmcPage10.profileUrldekiButton.click();

        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_UP)
                .perform();
        hmcPage10.reservationsButton.click();
        extentTest.info("\"User Menu\" altindaki \"Reservations\" buttonuna tiklanir");

        Assert.assertTrue(hmcPage10.reservationsTextStr.isEnabled());
        System.out.println("Kullanici Sayfa Rooms Text " + hmcPage10.reservationsTextStr);

        Assert.assertTrue(hmcPage10.room.isDisplayed());
        System.out.println("room yazisi"+hmcPage10.room.getText());
        Assert.assertTrue(hmcPage10.price.isDisplayed());
        System.out.println("price  yazisi"+hmcPage10.price.getText());
        Assert.assertTrue(hmcPage10.startDate.isDisplayed());
        System.out.println("startdate yazisi"+hmcPage10.startDate.getText());
        Assert.assertTrue(hmcPage10.endDate.isDisplayed());
        System.out.println("endDate yazisi"+hmcPage10.endDate.getText());
        Assert.assertTrue(hmcPage10.approved.isDisplayed());
        System.out.println("approved yazisi"+hmcPage10.approved.getText());

      //  pages.pagesUS0007.HotelMyCampPage ho = new pages.pagesUS0007.HotelMyCampPage();
     //   ho.logOutButton.click();


        Driver.closeDriver();

        extentTest.pass("\"Reservations\" sayfasindaki reserve edilen oda kullanici sayfasinda gorulur");
        extentTest.info("Reserve edilen ayni oda, ayni tarihte baska kullanici tarafindan da reserve edilebiliniyor");

/*
        actions.moveToElement(hotelMyCampPage.managerDropDownButton).perform();
        ReusableMethods.waitFor(2);
        hotelMyCampPage.logOutButton.click();
*/
        //7
    }

//10
/*
    @Test(priority = 8)

    public void odaBilgileriGuncellemeTesti() throws IOException {
        Driver.closeDriver();
        extentTest=extentReports.createTest("Oda Bilgileri Guncelleme Testi","Oda Bilgileri Guncelleme Test Edildi");
    //    ReusableMethods.waitFor(3);//
      //  actions.moveToElement(hotelMyCampPage.managerDropDownButton).perform();//
     //   ReusableMethods.waitFor(2);//
     //   hotelMyCampPage.logOutButton.click();//
        hmcHotelRoomPage=new HMCHotelRoomPage();
        hmcMainPage=new HMCMainPage();
        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));

        hotelMyCampPage.direkGeneralDataSayfasinaGit();
        hotelMyCampPage. hotelRoomGuncellemeDatasiGonderme("0007","MustafaDRoom10",
                "Muslihittin mah. No:48  Afrika ",
                "Huzurlu ve Mutlu tatilin adresi",
                "500.000","5","1");
        Assert.assertTrue(hotelMyCampPage.generalDataRoomsUpdateText.isDisplayed(),"Room Guncellenemedi FAILED");
        hotelMyCampPage.generalDataUpdateOKButonElementi.click();
        Driver.getDriver().navigate().back();
        hotelMyCampPage.listOfHotelRoomsNameBoxDataPush("MustafaDRoom10");
        hotelMyCampPage.listOfHotelRoomsyellowSearchButton.click();
        ReusableMethods.waitFor(3);
        String actualText=hotelMyCampPage.listOfHotelRoomsNameElementi.getText();
        ReusableMethods.getScreenshot("Oda Bilgileri Kayit Edildi Teyit Photo (US07)");
        ReusableMethods.waitFor(3);
        actions.moveToElement(hotelMyCampPage.managerDropDownButton).perform();
        ReusableMethods.waitFor(2);
        hotelMyCampPage.logOutButton.click();
        extentTest.pass("Oda Bilgileri Kayit");
    }


*/
/*
    @Test(priority = 9)
    public void odaBilgileriSilmeTesti() throws IOException {
        extentTest=extentReports.createTest("Oda Bilgileri Silme Testi","Oda Bilgileri Silme Test Edildi");
        hmcHotelRoomPage=new HMCHotelRoomPage();
        hmcMainPage=new HMCMainPage();
        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
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

    }*/
    /*
    @Test(priority = 10)
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

        softAssert.assertTrue(us009Page.saveEdildi.isEnabled());//*

        extentTest.pass("degisiklikler kaydedildi");
        pages.pagesUS0007.HotelMyCampPage ho = new pages.pagesUS0007.HotelMyCampPage();
        ho.logOutButton.click();
        Driver.closeDriver();
        softAssert.assertAll();//*

    }
    @Test(priority = 11)
    public void deleteRoomReservation() {
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

*/


}
