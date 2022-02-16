package tests.US0003;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.pagesUS0003.HMCPageUS003;
import utilities.Driver;

public class TC_001 {

    //TC_001-'Create a new account' butonu gorunur ve tiklanabilir olmali

    @Test
    public void us3Tc001(){
        //Step   1-Kullanici hotelmycamp sayfasına gider
        HMCPageUS003 hmcPageUS003=new HMCPageUS003();

        hmcPageUS003.anaSayfayaGit();
        String actualUrl= Driver.getDriver().getCurrentUrl();
        String expectedUrl="https://www.hotelmycamp.com/";
        Assert.assertEquals(actualUrl,expectedUrl,"HMCUrl'ye erişilmiyor");


        //Step 2-Login butonunu gorur ve tiklar
        Assert.assertTrue(hmcPageUS003.ilkLoginElementi.isDisplayed() ,"ilk login elementi gorunur degil");
        hmcPageUS003.ilkLoginElementi.click();


       //Step 3- 'Create new acccount' butonunu gorur ve tiklar
        Assert.assertTrue(hmcPageUS003.createNewAccountButonu.isDisplayed(),"create a new account butonu gorunur değil");
       hmcPageUS003.createNewAccountButonu.click();



    }

}
