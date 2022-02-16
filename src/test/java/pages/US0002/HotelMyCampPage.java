package pages.US0002;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

public class HotelMyCampPage {


    public HotelMyCampPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }



    @FindBy(xpath = "//a[text()='Log in'] ")
    public WebElement ilkLoginLinki;


    @FindBy(xpath = "//input[@id='UserName']")
    public WebElement usernameBox;


    @FindBy(xpath ="//input[@id='btnSubmit']")
    public WebElement loginButonu;

    @FindBy(xpath = "//*[@id=\"menuYonetim\"]")
    public  WebElement  managerSayfasi;

    @FindBy(xpath = "//div[@class='page-content-wrapper']")
    public  WebElement managerSayfaTest;

    @FindBy(xpath = "//input[@id='Password']")
    public WebElement passwordBox;

    @FindBy(xpath="//span[@class='username username-hide-on-mobile']")
    public WebElement managerButonu;

    @FindBy(xpath = "//div[@class='validation-summary-errors']")
    public WebElement girisYapilamadiYaziElementi;

    @FindBy(xpath="//span[text()='ListOfUsers']")
    public WebElement basariliGirisYaziElementi;

    @FindBy (xpath="(//div[@class='row'])[2]")
    public WebElement loginCercevesi;


    public void bekle(int saniye){
        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



    public void girisYap(){
        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
        ilkLoginLinki.click();
        usernameBox.sendKeys(ConfigReader.getProperty("HMCValidUsername"));
        passwordBox.sendKeys(ConfigReader.getProperty("HMCValidPassword"));
        loginButonu.click();
    }



}
