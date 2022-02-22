package tests.US0010;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HMCPage10;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TestCase01 extends TestBaseRapor {

    @Test
    public void testCase01() throws InterruptedException {

        extentTest=extentReports.createTest("testCase01","\"Log in\" buttonuna tiklayarak, \"Create a new account\"'tan sonra \"save\" yapabilmeli.");
        HMCPage10 hmcPage10=new HMCPage10();

        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
        extentTest.info("Url gidildi");

       hmcPage10.logInButtonu.click();
       extentTest.info("\"Log in\" buttonuna tiklanildi");

       hmcPage10.createNewAccount.click();
       extentTest.info("\"Create a new account\" butonuna tiklanir");

       Actions actions = new Actions(Driver.getDriver());
       Faker faker = new Faker();
       actions.click(hmcPage10.createUsername).sendKeys(faker.name().name())
               .sendKeys(Keys.TAB).sendKeys("aaaaaA6!")
               .sendKeys(Keys.TAB).sendKeys(faker.internet().emailAddress())
               .sendKeys(Keys.TAB).sendKeys(faker.name().fullName())
               .sendKeys(Keys.TAB).sendKeys(faker.phoneNumber().phoneNumber())
               .sendKeys(Keys.TAB).sendKeys(faker.phoneNumber().phoneNumber())
               .sendKeys(Keys.TAB).sendKeys("No")
               .sendKeys(Keys.TAB).sendKeys(faker.country().name())
               .sendKeys(Keys.TAB)
               .sendKeys(Keys.TAB).sendKeys(faker.address().fullAddress())
               .sendKeys(Keys.TAB).sendKeys(faker.job().position())
               .sendKeys(Keys.TAB).sendKeys("15.05.1996")
               .sendKeys(Keys.TAB)
               .perform();
       hmcPage10.createSaveButton.click();
       extentTest.info("Kullanici yeni hesap olusturdu");
       extentTest.info("Create account'ta STATE buttonuna yazilamadi");

       Assert.assertFalse(hmcPage10.createSaveTexti.isDisplayed());
       extentTest.pass("\"User Data was inserted successfully\" yazisi gorulemesi gerekirken gorulemedi.");

        hmcPage10.createOkButton.click();
        hmcPage10.createOkButton.click();
        extentTest.info("Yeni hesap olusturturduktan sonra OK buttonu 2 kere tiklanildi");

        }
    }
