package pages.pagesUS0004;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HMCHotelListPage {

    public HMCHotelListPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath="//a[@href='/admin/HotelAdmin']")
    public WebElement HotelListElementi;

@FindBy(xpath="//*[text()='Add Hotel ']")
    public WebElement AddHotelButtonElementi;


@FindBy(id="Code")
    public WebElement AddHotelCodeTextBoxElementi ;


@FindBy(id="Name")
    public WebElement AddHotelNameTextBoxElementi ;


@FindBy(id="Address")
    public WebElement AddHotelAddressTextBoxElementi ;


@FindBy(id="Phone")
    public WebElement AddHotelPhoneTextBoxElementi ;


@FindBy(id="Email")
    public WebElement AddHotelEmailTextBoxElementi ;


@FindBy(xpath="//select[@class='form-control input-lg required']")
    public WebElement AddHotelDropdownElementi ;

@FindBy(xpath="//div[@class='portlet box blue']")
    public WebElement CreateHotelFormElementi ;

   //  //button[@type='submit']
@FindBy(xpath="//button[.='Save']")
    public WebElement AddHotelSaveButton;
  //  //div[.='Hotel was inserted successfully']
@FindBy(xpath="/html/body/div[5]/div/div/div[1]/div")
    public WebElement AddHotelBasariliKayityazisiElementi;

@FindBy(xpath="//button[.='OK']")
    public WebElement AddHotelBasariliKayitOkButton;

@FindBy(xpath="//*[@name='Name']")
    public WebElement HotelListSearchNameTextBox;

@FindBy(xpath="//button[text()='Search']")
    public WebElement HotelListSearchButton;

@FindBy(xpath="//*[@id=\"datatable_ajax\"]/tbody/tr[1]/td[3]")
    public WebElement FirstHotelAtSearchList;


    public void AddHotelFormDropdownaKadarGecerliDoldurma() {
        AddHotelCodeTextBoxElementi.sendKeys("HC-34512", Keys.TAB , "HotelParadise",
                Keys.TAB, "Ataköy 2-5-6., 34158 Bakırköy/İstanbul", Keys.TAB,
                "02122221212",Keys.TAB, "info@hotelparadise.com");
    }

    public void AddHotelFormDropdownaKadarGecersizDoldurma() {
        AddHotelCodeTextBoxElementi.sendKeys("@#$", Keys.TAB , "1234",
                Keys.TAB, "but in world", Keys.TAB,
                "HI EVERYBODY",Keys.TAB, "NO AT in this mail");
    }
}
