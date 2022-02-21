package tests.US0008;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US0008.Hotel08;

import utilities.ConfigReader;
import utilities.Driver;
public class US08 extends Hotel08{
    //hello
    @Test
    public void Hotel008() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
        Hotel08 hotel08=new Hotel08();
        hotel08.ilkLoginElementi.click();
        hotel08.userNameBox.sendKeys(ConfigReader.getProperty("HMCValidUsername"));
        hotel08.passwordBox.sendKeys(ConfigReader.getProperty("HMCValidPassword"));
        hotel08.idveSifreyeGirLoginButonu.click();
        Assert.assertTrue(hotel08.yoneticiOlarakGirisYapilincaCikanListOfUsersElementi.isDisplayed());
        hotel08.hotelManagementElementi.click();
        hotel08.roomReservationsElementi.click();
        Assert.assertTrue(hotel08.listofreservationsYazisi.isDisplayed());
        hotel08.addRoomReservationElementi.click();
        Select select=new Select(ıduser1Elementi);
        select.selectByValue("2");
        System.out.println("yönetici olarak keyifli tatil yapak : " +select.getFirstSelectedOption().getText());
        Thread.sleep(3);
    }
}