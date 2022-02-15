package pages.pagesUS0007;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import pages.OrtakHMCPageBurayiSakinKurcalama.HMCMainPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

//
public class HotelMyCampPage   extends  HMCMainPage{
    Actions actions = new Actions(Driver.getDriver());
HMCMainPage hmcMainPage=new HMCMainPage();
    public HotelMyCampPage () {
        PageFactory.initElements(Driver.getDriver(),this);
        // PageFactory.initElements(Driver.getDriver(),this);
        // bu bizim driverimiza ilk degeri atiyor
        // this icinde bulundugu page sayfasinda kendi
        // driverimizin olduugunu declare etmis oluyor
    }

@FindBy (xpath = "//li[contains( @id, 'Log')]")
public WebElement hmcIlkLogin;

@FindBy(xpath = "//select[@title='Select Hotel']")
public WebElement generalDatahotelDDElementi;//5

@FindBy(xpath = "//input[@id='Code']")
public WebElement generalDataCodeElementi;//5

@FindBy (xpath = "//input[@id='Name']")
public WebElement getGeneralDataNameElementi;//5

@FindBy (xpath = "//input[@id='Location']")
public WebElement generalDataLocationElementi;

@FindBy (xpath = "//textarea[@role='textbox']")
public WebElement generalDataDescriptionElementi;

@FindBy (xpath = "//input[@id='Price']")//5
public WebElement generalDataPriceElementi;

@FindBy (xpath = "//select[@id='IDGroupRoomType']")
public WebElement generalRoomTypeDDElementi;

@FindBy (xpath = "//input[@id='MaxAdultCount']")
public WebElement generalDataMaxAdultCountElementi;

@FindBy (xpath = "//input[@id='MaxChildCount']")
public WebElement generalDataMaxChildrenCountElementi;

@FindBy (xpath = "//input[@id='IsAvailable']")
public WebElement generalDataIsAvailableElementi;

@FindBy (xpath = "(//button[@class='btn green'])[1]")
public WebElement generalDataSaveButonuElementi;

@FindBy (xpath = "(//button[@id='btnDelete'])[1]")
public WebElement generalDataDeleteButonuElementi;//5

@FindBy (xpath = "//div[.='HotelRoom was updated successfully']")
public WebElement generalDataRoomsUpdateText;//6

@FindBy (xpath = "//button[.='OK']")
public WebElement generalDataUpdateOKButonElementi;//6

@FindBy (xpath = "(//input[@class='form-control form-filter input-sm'])[3]")
public WebElement listOfHotelRoomsNameElementi;

@FindBy (xpath = "//button[@class='btn btn-sm yellow filter-submit margin-bottom']")
public WebElement listOfHotelRoomsyellowSearchButton;


    @FindBy (linkText = "/html/body/div[5]/div/div/div[1]/div")
    public WebElement generalDataDeleteSuccessText;//6

    @FindBy (xpath = "//div[2]/button[2]")
    public  WebElement generalDataSaveClickOkButonu;

    @FindBy(xpath = "//div[.='HotelRoom successfully deleted']")
    public WebElement odaSilindiSuccessText;

    @FindBy(xpath = "//input[@id='UserName']")
    public WebElement endUserName;

    @FindBy(xpath = "//input[@id='Password']")
    public WebElement endPassword;

    @FindBy(xpath = "//button[.='Log in']")
    public WebElement endLogInButton;

    @FindBy (xpath = "(//div[@class='caption'])[2]")
    public WebElement generalDataHotelroomDataText;

 //@FindBy (className = "btn btn-primary")
 //public WebElement generalDataDeleteOnaylamaButonu5;//6
    //Bu ELEMENT BIR BUG DIKKAAAAT!!!!!!!!!!!!!!!!!!

    public void listOfHotelRoomsNameBoxDataPush(String data){
  listOfHotelRoomsNameElementi.sendKeys(data);

}

    public WebElement hotelRoomsIlkSayfaWebTables(int satir, int sutun) {
        String dinamikXpath = "//tbody/tr[" + satir + "]/td[" + sutun + "]";
        WebElement webTableIstediginSutunuYazdir = Driver.getDriver().findElement(By.xpath(dinamikXpath));
        return webTableIstediginSutunuYazdir;
    }


    public void hotelRoomsWebTablinIsteginSayfasinaGit(int sayfa) {
  yoneticiOlarakGirisYap2();
  hmcMainPage. hotelManagementElementi.click();
   hmcMainPage.hotelRoomsElementi.click();

        for (int i = 1; i < sayfa; i++) {
            hmcMainPage.webTableSayfaDegistirmeNextOku.click();
          ReusableMethods.waitFor(2);
        }

    }

    public void webTableSayfasindakiIsteginDetailsButonunaDirekTikla(int satir, int sutun) {
        String dinamikDetailsXpath = "//tbody/tr[" + satir + "]/td[" + sutun + "]/a";
        WebElement dinamikDetailsXpathElementi = Driver.getDriver().findElement(By.xpath(dinamikDetailsXpath));
        dinamikDetailsXpathElementi.click();
    }

    public void direkPropertiesSayfasinaGit() {
        hotelRoomsWebTablinIsteginSayfasinaGit(5);
        ReusableMethods.waitFor(2);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(2);
        webTableSayfasindakiIsteginDetailsButonunaDirekTikla(10, 9);
       hmcMainPage. propertiesSekmesiElementi.click();
    }
    public void direkPhotostSayfasinaGit() {
        hotelRoomsWebTablinIsteginSayfasinaGit(5);
        ReusableMethods.waitFor(2);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(2);
        webTableSayfasindakiIsteginDetailsButonunaDirekTikla(10, 9);
      hmcMainPage.  photosSekmesiElementi.click();
    }
    public void direkGeneralDataSayfasinaGit(){
        hotelRoomsWebTablinIsteginSayfasinaGit(5);
        webTableSayfasindakiIsteginDetailsButonunaDirekTikla(10, 9);
    }


public void hotelRoomGuncellemeDatasiGonderme(String Code,String Name ,
String Location,String Description,String PriceDouble,String MaxAdultCount,
String MaxChildrenCount){
hotelDDMethod(15);//Cyber Space
ReusableMethods.waitFor(2);
generalDataCodeElementi.clear();
generalDataCodeElementi.sendKeys(Code);

ReusableMethods.waitFor(2);
getGeneralDataNameElementi.clear();
getGeneralDataNameElementi.sendKeys(Name);
ReusableMethods.waitFor(2);

generalDataLocationElementi.clear();
generalDataLocationElementi.sendKeys(Location);
ReusableMethods.waitFor(2);

generalDataDescriptionElementi.clear();
generalDataDescriptionElementi.sendKeys(Description);
ReusableMethods.waitFor(2);

generalDataPriceElementi.clear();
generalDataPriceElementi.sendKeys(PriceDouble);
ReusableMethods.waitFor(2);

roomTypeDDMethod(6);
ReusableMethods.waitFor(2);
generalDataMaxAdultCountElementi.clear();
generalDataMaxAdultCountElementi.sendKeys(MaxAdultCount);
ReusableMethods.waitFor(2);
generalDataMaxChildrenCountElementi.clear();
generalDataMaxChildrenCountElementi.sendKeys(MaxChildrenCount);
    if (!generalDataIsAvailableElementi.isSelected()) {
        generalDataIsAvailableElementi.click();
    }
generalDataSaveButonuElementi.click();
    ReusableMethods.waitFor(3);


}

    public void hotelRoomDeleteDatasiGonderme(String Code,String Name ,
String Location,String Description,String PriceDouble,String MaxAdultCount,
String MaxChildrenCount) {
        hotelDDMethod(15);//Cyber Space
        ReusableMethods.waitFor(2);
        generalDataCodeElementi.clear();
        generalDataCodeElementi.sendKeys(Code);

        ReusableMethods.waitFor(2);
        getGeneralDataNameElementi.clear();
        getGeneralDataNameElementi.sendKeys(Name);
        ReusableMethods.waitFor(2);

        generalDataLocationElementi.clear();
        generalDataLocationElementi.sendKeys(Location);
        ReusableMethods.waitFor(2);

        generalDataDescriptionElementi.clear();
        generalDataDescriptionElementi.sendKeys(Description);
        ReusableMethods.waitFor(2);

        generalDataPriceElementi.clear();
        generalDataPriceElementi.sendKeys(PriceDouble);
        ReusableMethods.waitFor(2);

        roomTypeDDMethod(6);
        ReusableMethods.waitFor(2);
        generalDataMaxAdultCountElementi.clear();
        generalDataMaxAdultCountElementi.sendKeys(MaxAdultCount);
        ReusableMethods.waitFor(2);
        generalDataMaxChildrenCountElementi.clear();
        generalDataMaxChildrenCountElementi.sendKeys(MaxChildrenCount);
        if (!generalDataIsAvailableElementi.isSelected()) {
            generalDataIsAvailableElementi.click();
        }

    }


public void hotelDDMethod(int index){
    Select select=new Select(generalDatahotelDDElementi);
    select.selectByIndex(index);//Cyber Space i Secer 15



}
    public void roomTypeDDMethod(int index){
        Select select=new Select(generalRoomTypeDDElementi);
        //6
        select.selectByIndex(index);
    }

public void closeTheWindow(){

Driver.closeDriver();
}
    public void yoneticiOlarakGirisYap2() {
        HMCMainPage hmcMainPage=new HMCMainPage();
        hmcIlkLogin.click();
        hmcMainPage.userNameBox.sendKeys(ConfigReader.getProperty("HMCValidUsername"));
        hmcMainPage. passwordBox.sendKeys(ConfigReader.getProperty("HMCValidPassword"));
        hmcMainPage.    idveSifreyeGirLoginButonu.click();
    }










/*
@FindBy (className = "btn btn-primary")
public WebElement generalDataDeleteOnaylamaButonu;//6
//Bu ELEMENT BIR BUG DIKKAAAAT!!!!!!!!!!!!!!!!!!
*/

}