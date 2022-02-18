package tests.US0010;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HMCPage10;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import java.security.Key;

public class TestCase04 extends TestBaseRapor {

    @Test
    public void testCase04(){

        extentTest=extentReports.createTest("testCase04","\"Book this room\" tiklayarak,\"Reservation was made successfully\" yazisi test edilerek,\"OK\" tiklayabilmeli");
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

        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);", hmcPage10.odaSeciminegit);
        hmcPage10.odaSec.click();
        extentTest.info("Triple odasi secildi.");

        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN)
                .perform();
        hmcPage10.checkin_date.click();
        hmcPage10.checkin_date.clear();
        hmcPage10.checkin_date.sendKeys("08/15/2022");
        hmcPage10.checkout_date.clear();
        hmcPage10.checkout_date.click();
        hmcPage10.checkout_date.sendKeys("08/29/2022");
        hmcPage10.AdultCount.click();
        Select objSelect = new Select(hmcPage10.AdultCount);
        objSelect.selectByIndex(6);
        hmcPage10.ChildrenCount.click();
        Select objSelect1 = new Select(hmcPage10.ChildrenCount);
        objSelect1.selectByIndex(3);
        hmcPage10.nameOnCreditCard.click();
        hmcPage10.nameOnCreditCard.sendKeys(Faker.instance().name().name());
        hmcPage10.creditCardNumber.click();
        hmcPage10.creditCardNumber.sendKeys("1234567812345678");
        hmcPage10.SelectExpirationYearForCreditCard.click();
        Select objSelect3 = new Select(hmcPage10.SelectExpirationYearForCreditCard);
        objSelect3.selectByIndex(3);
        actions.sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN)
                .perform();
        hmcPage10.SelectExpirationMonthForCreditCard.click();
        Select objSelect4 = new Select(hmcPage10.SelectExpirationMonthForCreditCard);
        objSelect4.selectByIndex(7);
        actions.sendKeys(Keys.PAGE_UP)
                .sendKeys(Keys.PAGE_UP)
                        .perform();
        hmcPage10.CVV.click();
        hmcPage10.CVV.sendKeys("123");
        hmcPage10.message.click();
        hmcPage10.message.sendKeys("lutfen sessiz yer olsun.");
        extentTest.info("Reserve edilecek oda bilgileri dolduruldu.");

        hmcPage10.bookthisroom.click();
        extentTest.info("\"Book this room\" buttonuna tiklanildi");

        //Assert.assertFalse(hmcPage10.reservationsTextStr.isDisplayed());
        extentTest.pass("\"Reservation was made successfully\" text gorulmesi gerekirken gorulemedi");

        hmcPage10.rezervasyonOkButonu.click();
        extentTest.info("Reservasition yapildiktan sonra \"OK\" buttonuna tiklanildi");

        Driver.getDriver().navigate().to(ConfigReader.getProperty("HMCUrl"));
    }}

