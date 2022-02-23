package pages.US0006;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HMCHotelRoomPage {

    public HMCHotelRoomPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy (xpath = "//h2[@class='mb-4']")
    public WebElement loginyazisiElementi;

    @FindBy (xpath = "//span[@class='hidden-480']")
    public WebElement addHotelRoomButonu;

    @FindBy (xpath = "//div[@class='caption']")
    public WebElement createHotelroomElementi;

    @FindBy(xpath = "//input[@id='Code']")
    public WebElement addHotelCodeKutusu;

    @FindBy ( xpath="//select[@id='IDHotel']")
    public WebElement addHotelDropdown;

    @FindBy(xpath = "//button[@id='btnSubmit']")
    public WebElement addHotelSaveButonu;

    @FindBy (xpath = "//select[@id='IDGroupRoomType']")
    public WebElement roomTypeDropdown;

    @FindBy (xpath = "//input[@id='MaxAdultCount']")
    public WebElement maxAdultCountElementi;

    @FindBy (xpath = "//input[@id='IsAvailable']")
    public WebElement approvedElementi;

    @FindBy (xpath = "//div[@class='bootbox-body']")
    public WebElement basariliOdaEklemeElementiYazisi;

    @FindBy (xpath = "(//button[@type='button'])[6]")
    public WebElement okElementi;

    @FindBy (xpath = "//span[text()='List Of Hotelrooms']")
    public WebElement listofhotelroomsElementi;

}
