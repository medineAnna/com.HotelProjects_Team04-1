package tests.US0003;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.pagesUS0003.HMCPageUS003;
import utilities.TestBaseRapor;

public class US0003Reports extends TestBaseRapor {

    @Test
    public void us003Reports(){
        HMCPageUS003 hmcPageUS003=new HMCPageUS003();

        extentTest=extentReports.createTest("US0003"," Geçerli dataları kullanarak sisteme kayıt yapılabilindigi test edildi");

        //Step   1-Kullanici hotelmycamp sayfasına gider
        hmcPageUS003.anaSayfayaGit();
        extentTest.info("HMCUrl ye gidildigi test edildi");

        //Step 2-Login butonunu tiklar
        Assert.assertTrue(hmcPageUS003.ilkLoginElementi.isDisplayed());
        Assert.assertTrue(hmcPageUS003.ilkLoginElementi.isEnabled());
        hmcPageUS003.ilkLoginElementi.click();
        extentTest.info("ilk login butonunun erisirebilirligi test edildi");


        //Step 3-   3- 'Create new acccount' butonuna tiklar,  'Registration Form' sayfasina erisir
        Assert.assertTrue(hmcPageUS003.createNewAccountButonu.isDisplayed(), "create a new account butonu gorunur değil");
        hmcPageUS003.createNewAccountButonu.click();
        Assert.assertTrue(hmcPageUS003.RegistrationYazisi.isDisplayed());
        extentTest.info("'Create new acccount' butonuna tiklanildigi ve  'Registration Form' sayfasina erisilebilindigi test edildi");


        //Step 4-'Registration Form' sayfasindaki textboxlara istenen bilgileri girer
        Assert.assertTrue(hmcPageUS003.formEditTextboxlari.isEnabled());
        hmcPageUS003.degerGirTextoxRegistrationForm();
        extentTest.info("'Registration Form' sayfasindaki textboxlara istenen bilgilerin girilebildigi test edildi");

        //Step 5-'Save' butonuna tiklar
        Assert.assertTrue(hmcPageUS003.saveButonu.isDisplayed());
        hmcPageUS003.saveButonu.click();
        extentTest.info("save butonunun erisilebilir ve gorunur oldugu test edildi");


        //Step   6-'User Data was inserted successfully' yazisini gorur
        Assert.assertTrue(hmcPageUS003.UseDatawasInsertedSuccessfullyyazisi.isDisplayed());
        hmcPageUS003.uDwISyazisiOkButonu.click();
        extentTest.pass("'User Data was inserted successfully' yazisinin goruldugu test edildi");









    }



}
