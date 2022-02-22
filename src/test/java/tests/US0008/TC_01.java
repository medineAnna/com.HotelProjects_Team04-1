package tests.US0008;


import org.testng.Assert;
import org.testng.annotations.Test;
import pages.OrtakHMCPageBurayiSakinKurcalama.HMCMainPage;
import pages.PagesUS0008.HotelMyCampPage08;
import utilities.TestBaseRapor;


public class TC_01 extends TestBaseRapor {

  @Test
    public void TC001(){

      HMCMainPage hmcMainPage=new HMCMainPage();

      HotelMyCampPage08 hotelMyCampPage08=new HotelMyCampPage08();

       extentTest=extentReports.createTest("TC001 giris testi","Anasayfa girisi");
      // Yönetici url'e gider.
      // Login butonunu tiklar.
      hmcMainPage.anaSayfayaGit();
      extentTest.info("anasayfaya gidis testi yapıldı");

      hmcMainPage.yoneticiOlarakGirisYap();
       extentTest.pass("Yönetici olarak giris testi yapıldı");

       //  "LISTOFUSERS" yazisi gorunur
      Assert.assertTrue(hotelMyCampPage08.yoneticiOlarakGirisYapilincaCikanListOfUsersElementi.isDisplayed());
       extentTest.pass("LISTOFUSERS yazisi test edildi");



  }
}
