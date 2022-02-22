package pages.PagesUS0008;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
public class HotelMyCampPage08 {



    public HotelMyCampPage08() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[.='Log in']")
    public WebElement ilkLoginElementi;

    @FindBy(xpath = "//input[@id='UserName']")
    public WebElement userNameBox;

    @FindBy(id = "Password")
    public WebElement passwordBox;

    @FindBy(id = "btnSubmit")
    public WebElement idveSifreyeGirLoginButonu;

    @FindBy(linkText = "ListOfUsers")
    public WebElement yoneticiOlarakGirisYapilincaCikanListOfUsersElementi;

    @FindBy(xpath = "//span[.='Hotel Management']")
    public WebElement hotelManagementElementi;

    @FindBy(xpath ="(//a[@href='/admin/RoomReservationAdmin'])[1]")
    public WebElement roomReservationsElementi;

    @FindBy(xpath = "//span[text()='List Of Reservations']")
    public WebElement listofreservationsYazisi;

    @FindBy(xpath ="//span[@class='hidden-480']")
    public WebElement addRoomReservationElementi;

    @FindBy(xpath ="//div[@class='caption']")
    public WebElement createHotelroomreservationYazisi;

    @FindBy(xpath ="//select[@id='IDUser']")
    public WebElement iduser1Elementi;

    @FindBy(xpath ="//select[@title='Select HotelRoom']")
    public WebElement iduser2Elementi;

    @FindBy(xpath ="//input[@id='Price']")
    public WebElement priceElementi;

    @FindBy(xpath ="//input[@id='DateStart']")
    public WebElement dateStartElementi;

    @FindBy(xpath ="//input[@id='DateEnd']")
    public WebElement dateEndElementi;

    @FindBy(xpath ="//div[@id='uniform-Approved']")
    public WebElement approvedButonu;

    @FindBy(xpath ="//button[text()='Save']")
    public WebElement saveButonu;

    @FindBy(xpath ="//div[@class='bootbox-body']")
    public WebElement roomReservationwasinsertedsuccessfullyYazisi;

    @FindBy(xpath ="//button[text()='OK']")
    public WebElement okButonu;



}
