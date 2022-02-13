package tests.US0004;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.OrtakHMCPageBurayiSakinKurcalama.HMCMainPage;
import pages.pagesUS0004.HMCHotelListPage;

public class TC004 {
    @Test
    public void US4TC4() {

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
        //7- "create hotel" formu icerisindeki "ID Gruop" dropdown'ina tiklar.
        //8- Hotel Types opsiyonlarini gorur ve birine tiklar.
        Select select = new Select(hmcHotelListPage.AddHotelDropdownElementi);
        select.selectByIndex(2);
        //9- Tiklamis oldugu type in secilmis oldugunu gorur.
        Assert.assertTrue(select.getFirstSelectedOption().isSelected());

    }
}