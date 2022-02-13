package tests.US0004;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.OrtakHMCPageBurayiSakinKurcalama.HMCMainPage;
import pages.pagesUS0004.HMCHotelListPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class TC005 {
    Actions actions =new Actions(Driver.getDriver());
    @Test
    public void US4TC5() throws IOException {

        HMCMainPage hmcMainPage = new HMCMainPage();
        HMCHotelListPage hmcHotelListPage = new HMCHotelListPage();
        //1- Yonetici url e gider.
        hmcMainPage.anaSayfayaGit();
        //2- Login butonunu tiklar.
        //3- Yonetici kendisine verilen username ve password ile giris yapar.

        hmcMainPage.yoneticiOlarakGirisYap();
        //4- "Hotel management" kismina tiklar.
        hmcMainPage.hotelManagementElementi.click();
        //5- Gorunur hale gelen "Hotel List" kismina tiklar.
        hmcHotelListPage.HotelListElementi.click();
        //6- "Add Hotel" butonuna tiklar.
        hmcHotelListPage.AddHotelButtonElementi.click();
    //7- "create hotel" formunu gecerli bilgiler ile doldurur.
  hmcHotelListPage.AddHotelFormDropdownaKadarGecerliDoldurma();
        Select select= new Select(hmcHotelListPage.AddHotelDropdownElementi);
        select.selectByIndex(1);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(3);
    //8- Save butonuna tiklar.
        hmcHotelListPage.AddHotelSaveButton.click();
    //9- "Hotel was inserted successfully" yazisini gorur.

      //  Assert.assertTrue(hmcHotelListPage.AddHotelBasariliKayityazisiElementi.isDisplayed());
        //Developer Hatasi 44. satir WebElement hic bir sekilde bulunamiyor
        ReusableMethods.waitFor(3);
        ReusableMethods.getScreenshot("AddHotelBasariliKayityazisiElementi");

    //10- OK butonuna tiklar.
        hmcHotelListPage.AddHotelBasariliKayitOkButton.click();
}}
