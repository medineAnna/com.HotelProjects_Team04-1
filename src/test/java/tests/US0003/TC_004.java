package tests.US0003;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.pagesUS0003.HMCPageUS003;
import utilities.Driver;

import java.io.IOException;

public class TC_004 {

    //TC_004-'Save' butonu gorunur ve tiklanabilir olmalı

    @Test
    public void us3Tc002() throws IOException {

        HMCPageUS003 hmcPageUS003=new HMCPageUS003();
        //Step   1-Kullanici hotelmycamp sayfasına gider
        hmcPageUS003.anaSayfayaGit();

        //Step 2-Login butonunu tiklar
        hmcPageUS003.ilkLoginElementi.click();


        //Step 3-   3- 'Create new acccount' butonuna tiklar,  'Registration Form' sayfasina erisir
        Assert.assertTrue(hmcPageUS003.createNewAccountButonu.isDisplayed(),"create a new account butonu gorunur değil");
        hmcPageUS003.createNewAccountButonu.click();
        Assert.assertTrue(hmcPageUS003.RegistrationYazisi.isDisplayed());



        //Step 4-'Registration Form' sayfasindaki textboxlara istenen bilgileri girer
        Assert.assertTrue(hmcPageUS003.formEditTextboxlari.isEnabled());
        hmcPageUS003.degerGirTextoxRegistrationForm();

        //Step 5-'Save' butonuna tiklar
        Assert.assertTrue(hmcPageUS003.saveButonu.isDisplayed());
        hmcPageUS003.saveButonu.click();

        Driver.closeDriver();











    }


}
