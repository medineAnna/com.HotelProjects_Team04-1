package pages.OrtakHMCPageBurayiSakinKurcalama;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;
import java.util.List;
public class HMCMainPage {
    Actions actions = new Actions(Driver.getDriver());
    public HMCMainPage(){
        PageFactory.initElements(Driver.getDriver(),this);
        // PageFactory.initElements(Driver.getDriver(),this);
        // bu bizim driverimiza ilk degeri atiyor
        // this icinde bulundugu page sayfasinda kendi
        // driverimizin olduugunu declare etmis oluyor
    }
    //Buradaki Kodlari kimse Degistirilmeyecek Ekleme Yapilmayacak
//Sadece Kullanabilirsiniz



    @FindBy(xpath = "//a[.='Log in']")
    public WebElement ilkLoginElementi;
    //
    @FindBy(xpath = "//input[@id='UserName']")
    public WebElement userNameBox;
    @FindBy(id = "Password")
    public WebElement passwordBox;
    @FindBy(id = "btnSubmit")
    public WebElement idveSifreyeGirLoginButonu;
    @FindBy(xpath = "//h3[.='Categories']")
    public WebElement sifreGirmeSayfasiCategories;
    @FindBy(linkText = "ListOfUsers")
    public WebElement yoneticiOlarakGirisYapilincaCikanListOfUsersElementi;
    @FindBy(xpath = "//span[.='Hotel Management']")
    public WebElement hotelManagementElementi;
    @FindBy(xpath = "//div[3]/div[1]/div/ul/li[3]/ul/li[2]/ul/li[2]/a")
    public WebElement hotelRoomsElementi;
    @FindBy(xpath = "//table/thead/tr/th")
    public List<WebElement> theaderTabloBasliklariElementi;
    @FindBy(xpath = "//*[@id=\"datatable_ajax_paginate\"]/div/a[2]")
    public WebElement webTableSayfaDegistirmeNextOku;
    @FindBy(xpath = "(//div[@class='caption'])[1]")
    public WebElement editHotelRoomYaziElementi;
    @FindBy(linkText = "Properties")
    public WebElement propertiesSekmesiElementi;
    @FindBy(xpath = "(//i[@class='fa fa-cogs'])[1]")
    public WebElement addPropertyYaziElementi;
    @FindBy(xpath = "//select[@id='lkpBarcodeTypes']")
    public WebElement propertiesdekiTipDropDownElementi;
    @FindBy(linkText = "Photos")
    public WebElement photosSekmesiElementi;
    @FindBy(xpath = "//a[@id='tab_images_uploader_uploadfiles']")
    public  WebElement upLoadFilesElementi;
    @FindBy (xpath = ("(//div[@class='caption'])[2]"))
    public WebElement generalDataElementi;
    public void anaSayfayaGit() {
        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
    }
    public void yoneticiOlarakGirisYap() {
        ilkLoginElementi.click();
        userNameBox.sendKeys(ConfigReader.getProperty("HMCValidUsername"));
        passwordBox.sendKeys(ConfigReader.getProperty("HMCValidPassword"));
        idveSifreyeGirLoginButonu.click();
    }
}








