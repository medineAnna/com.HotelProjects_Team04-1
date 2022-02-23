package tests.US0007;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.pagesUS0007.HotelMyCampPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class US007_NegatifTest extends TestBaseRapor {
    @DataProvider
    public static Object[][] wrongUserList() {

        String liste[][]={{"manager11","manager11"},{"manager12","manager12"},{"manager13","manager13"}};
        return liste;
    }
    @Test(dataProvider = "wrongUserList")
    public void yanlisSifreUsernameYanlisPasswordTesti(String wrongUsername, String wrongPassword){
        extentTest=extentReports.createTest("YanlisSifreUsernameYanlisPasswordTesti","yanlisSifreUsernameTesti Edildi");
        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
        HotelMyCampPage hotelMyCampPage=new HotelMyCampPage();
        hotelMyCampPage.hmcIlkLogin.click();
        hotelMyCampPage.userNameBox.sendKeys(wrongUsername);
        hotelMyCampPage.passwordBox.sendKeys(wrongPassword);
        hotelMyCampPage.idveSifreyeGirLoginButonu.click();
        WebElement girisYapilamadiYaziElementi=Driver.getDriver().findElement(By.xpath("//li[.='Username or password is incorrect, please correct them and try again']"));
        Assert.assertTrue(girisYapilamadiYaziElementi.isDisplayed());
        Driver.closeDriver();
        extentTest.pass("Yanlis UserName Test");
    }
}
