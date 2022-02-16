package pages.pagesUS0003;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

public class HMCPageUS003 {

    public HMCPageUS003(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    public void anaSayfayaGit() {
        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));

    }
    @FindBy(xpath = "//a[.='Log in']")
    public WebElement ilkLoginElementi;


    @FindBy(xpath ="//span[@class='btn btn-primary py-3 px-5']" )
    public WebElement createNewAccountButonu;

    @FindBy(xpath = "//h2[text()='Registration Form']")
    public WebElement RegistrationYazisi;

    @FindBy(xpath = "//form[@class='bg-white col-md-12 contact-form login-form']")
    public WebElement formEditTextboxlari;

    @FindBy(xpath = "//input[@id='btnSubmit']")
    public WebElement saveButonu;

    @FindBy(xpath = "//div[@class='bootbox-body']")
    public WebElement UseDatawasInsertedSuccessfullyyazisi;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement uDwISyazisiOkButonu;





    public void degerGirTextoxRegistrationForm(){

        WebElement u3userName= Driver.getDriver().findElement(By.xpath("//input[@id='UserName']"));

        Actions actions=new Actions(Driver.getDriver());
        Faker faker=new Faker();

        actions.click(u3userName)
                .sendKeys(faker.name().name())
                .sendKeys(Keys.TAB)
                .sendKeys("Kullanici06!")
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().emailAddress())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().fullName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.phoneNumber().phoneNumber())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.phoneNumber().phoneNumber())
                .sendKeys(Keys.TAB)
                .sendKeys("No")
                .sendKeys(Keys.TAB)
                .sendKeys(faker.country().name())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().fullAddress())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.job().position())
                .sendKeys(Keys.TAB)
                .sendKeys("17/03/1999")
                .sendKeys(Keys.TAB)
                .perform();


    }

}
