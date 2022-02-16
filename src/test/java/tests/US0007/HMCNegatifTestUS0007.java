package tests.US0007;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.pagesUS0007.HotelMyCampPage;
import utilities.ConfigReader;
import utilities.Driver;

public class HMCNegatifTestUS0007 {





    /*
    @Test
    public void yanlisSifreTesti(){
        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
        hotelMyCampPage=new HotelMyCampPage();
        hotelMyCampPage.ilkLoginLinki.click();
        hotelMyCampPage.usernameBox.sendKeys(ConfigReader.getProperty("HMCValidUsername"));
        hotelMyCampPage.passwordBox.sendKeys(ConfigReader.getProperty("HMCWrongPassword"));
        hotelMyCampPage.loginButonu.click();
        Assert.assertTrue(hotelMyCampPage.girisYapilamadiYaziElementi.isDisplayed());
        Driver.closeDriver();
    }

    @Test
    public void yanlisUsernameTesti(){
        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
        hotelMyCampPage=new HotelMyCampPage();
        hotelMyCampPage.ilkLoginLinki.click();
        hotelMyCampPage.usernameBox.sendKeys(ConfigReader.getProperty("HMCWrongUsername"));
        hotelMyCampPage.passwordBox.sendKeys(ConfigReader.getProperty("HMCValidPassword"));
        hotelMyCampPage.loginButonu.click();
        Assert.assertTrue(hotelMyCampPage.girisYapilamadiYaziElementi.isDisplayed());
        Driver.closeDriver();
    }
    @Test
    public void yanlisSifreUsernameTesti(){
        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
        hotelMyCampPage=new HotelMyCampPage();
        hotelMyCampPage.ilkLoginLinki.click();
        hotelMyCampPage.usernameBox.sendKeys(ConfigReader.getProperty("HMCWrongUsername"));
        hotelMyCampPage.passwordBox.sendKeys(ConfigReader.getProperty("HMCWrongPassword"));
        hotelMyCampPage.loginButonu.click();
        Assert.assertTrue(hotelMyCampPage.girisYapilamadiYaziElementi.isDisplayed());
        Driver.closeDriver();
    }
*/


        @DataProvider
    public static Object[][] wrongUserList() {

        String liste[][]={{"manager11","manager11"},{"manager12","manager12"},{"manager13","manager13"}};
        return liste;
    }
    @Test(dataProvider = "wrongUserList")
    public void yanlisSifreUsernameTesti(String wrongUsername, String wrongPassword){
        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
        HotelMyCampPage hotelMyCampPage=new HotelMyCampPage();
        hotelMyCampPage.hmcIlkLogin.click();
        hotelMyCampPage.userNameBox.sendKeys(wrongUsername);
        hotelMyCampPage.passwordBox.sendKeys(wrongPassword);
        hotelMyCampPage.idveSifreyeGirLoginButonu.click();
        WebElement girisYapilamadiYaziElementi=Driver.getDriver().findElement(By.xpath("//li[.='Username or password is incorrect, please correct them and try again']"));
     Assert.assertTrue(girisYapilamadiYaziElementi.isDisplayed());
        Driver.closeDriver();
    }

}
