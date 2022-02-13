package tests.US0004;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.OrtakHMCPageBurayiSakinKurcalama.HMCMainPage;
import pages.pagesUS0004.HMCHotelListPage;

public class TC001 {

@Test
    public void US4TC1(){
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
    //6- "Add Hotel" butonunu gorur.
    Assert.assertTrue(hmcHotelListPage.AddHotelButtonElementi.isDisplayed());
    //7- "Add Hotel" butonuna erisebilir.
    Assert.assertTrue(hmcHotelListPage.AddHotelButtonElementi.isEnabled());
}

}
