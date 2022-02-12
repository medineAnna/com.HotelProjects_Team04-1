package pages.pagesUS0007;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class HotelMyCampPage {
    Actions actions = new Actions(Driver.getDriver());

    public HotelMyCampPage() {
        PageFactory.initElements(Driver.getDriver(), this);
        // PageFactory.initElements(Driver.getDriver(),this);
        // bu bizim driverimiza ilk degeri atiyor
        // this icinde bulundugu page sayfasinda kendi
        // driverimizin olduugunu declare etmis oluyor
    }

    @FindBy(xpath = "//a[.='Log in']")
    public WebElement ilkLoginElementi;

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

    @FindBy(xpath = "//a[@href='/admin/HotelRoomAdmin']")
    public WebElement hotelRoomsElementi;

    @FindBy(xpath = "//table/thead/tr/th")
    public List<WebElement> theaderTabloBasliklariElementi;

    @FindBy(xpath = "(//a[@title='Next'])[1]")
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


    public void yoneticiOlarakGirisYap() {
        ilkLoginElementi.click();
        userNameBox.sendKeys(ConfigReader.getProperty("HMCValidUsername"));
        passwordBox.sendKeys(ConfigReader.getProperty("HMCValidPassword"));
        idveSifreyeGirLoginButonu.click();
    }

    public void anaSayfayaGit() {
        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));

    }

    public WebElement hotelRoomsIlkSayfaWebTables(int satir, int sutun) {
        String dinamikXpath = "//tbody/tr[" + satir + "]/td[" + sutun + "]";
        WebElement webTableIstediginSutunuYazdir = Driver.getDriver().findElement(By.xpath(dinamikXpath));
        return webTableIstediginSutunuYazdir;
    }


    public void direkWebTablinIsteginSayfasinaGit(int sayfa) {

        yoneticiOlarakGirisYap();
        hotelManagementElementi.click();
        hotelRoomsElementi.click();
        for (int i = 1; i < sayfa; i++) {
            webTableSayfaDegistirmeNextOku.click();
            ReusableMethods.waitFor(2);
        }

    }

    public void webTableSayfasindakiIsteginDetailsButonunaDirekTikla(int satir, int sutun) {
        String dinamikDetailsXpath = "//tbody/tr[" + satir + "]/td[" + sutun + "]/a";
        WebElement dinamikDetailsXpathElementi = Driver.getDriver().findElement(By.xpath(dinamikDetailsXpath));
        dinamikDetailsXpathElementi.click();
    }

    public void direkPropertiesSayfasinaGit() {
        direkWebTablinIsteginSayfasinaGit(5);
        ReusableMethods.waitFor(2);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(2);
        webTableSayfasindakiIsteginDetailsButonunaDirekTikla(10, 9);
        propertiesSekmesiElementi.click();
    }
    public void direkPhotostSayfasinaGit() {
        direkWebTablinIsteginSayfasinaGit(5);
        ReusableMethods.waitFor(2);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(2);
        webTableSayfasindakiIsteginDetailsButonunaDirekTikla(10, 9);
        photosSekmesiElementi.click();
    }

}