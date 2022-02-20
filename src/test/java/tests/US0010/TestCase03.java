package tests.US0010;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HMCPage10;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TestCase03 extends TestBaseRapor {

    @Test
    public void testCase03() throws InterruptedException {

        extentTest=extentReports.createTest("testCase03","Cikan oda secenekleri tiklayabilmeli ve \"Categories\" text altindaki sonuclari tiklayabilmeli");
        HMCPage10 hmcPage10=new HMCPage10();

        Driver.getDriver().navigate().to(ConfigReader.getProperty("HMCUrl"));
        extentTest.info("Url gidildi");

        /*hmcPage10.logInButtonu.click();
        extentTest.info("\"Log in\" buttonuna tiklanildi");

        hmcPage10.usernameBox.sendKeys("MedinAnna" + Keys.ENTER);
        hmcPage10.passwordBox.sendKeys("aaaaaA6!" + Keys.ENTER);
        hmcPage10.ikinciLoginButonu.click();
        extentTest.info("Kullanici girisi yapti");*/

        hmcPage10.roomsButton.click();
        extentTest.info("\"Rooms\" buttonuna tiklanildi");

        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN).perform();
        hmcPage10.bookNow8.click();
        Thread.sleep(3000);
        hmcPage10.singleRoom.click();
        Assert.assertTrue(hmcPage10.singleRoom.isEnabled(), "erisilemiyor");
        Driver.getDriver().navigate().back();
        hmcPage10.doubleRoom.click();
        Assert.assertTrue(hmcPage10.doubleRoom.isEnabled(), "erisilemiyor");
        Thread.sleep(1000);
        actions.sendKeys(Keys.PAGE_DOWN)
                .perform();
        Thread.sleep(1000);
        Driver.getDriver().navigate().back();
        hmcPage10.tribleRoom.click();
        Assert.assertTrue(hmcPage10.tribleRoom.isEnabled(), "erisilemiyor");
        actions.sendKeys(Keys.PAGE_DOWN)
                .perform();
        Thread.sleep(1000);
        Driver.getDriver().navigate().back();
        hmcPage10.quadRoom.click();
        Assert.assertTrue(hmcPage10.quadRoom.isEnabled(), "erisilemiyor");
        actions.sendKeys(Keys.PAGE_DOWN)
                .perform();
        Thread.sleep(1000);
        Driver.getDriver().navigate().back();
        hmcPage10.queenRoom.click();
        Assert.assertTrue(hmcPage10.queenRoom.isEnabled(), "erisilemiyor");
        actions.sendKeys(Keys.PAGE_DOWN)
                .perform();
        Thread.sleep(1000);
        Driver.getDriver().navigate().back();
        hmcPage10.kingRoom.click();
        Assert.assertTrue(hmcPage10.kingRoom.isEnabled(), "erisilemiyor");
        actions.sendKeys(Keys.PAGE_DOWN)
                .perform();
        Thread.sleep(1000);
        Driver.getDriver().navigate().back();
        hmcPage10.twinRoom.click();
        Assert.assertTrue(hmcPage10.twinRoom.isEnabled(), "erisilemiyor");
        actions.sendKeys(Keys.PAGE_DOWN)
                .perform();
        Thread.sleep(1000);
        Driver.getDriver().navigate().back();
        hmcPage10.doubleDoubleRoom.click();
        Assert.assertTrue(hmcPage10.doubleDoubleRoom.isEnabled(), "erisilemiyor");
        actions.sendKeys(Keys.PAGE_DOWN)
                .perform();
        Thread.sleep(1000);
        Driver.getDriver().navigate().back();
        hmcPage10.studioRoom.click();
        Assert.assertTrue(hmcPage10.studioRoom.isEnabled(), "erisilemiyor");
        actions.sendKeys(Keys.PAGE_DOWN)
                .perform();
        Thread.sleep(1000);
        extentTest.pass("\"Categories\" text yazisi altindaki oda type'lerinin erisebilirligi kontrol edildi");
    }

}
