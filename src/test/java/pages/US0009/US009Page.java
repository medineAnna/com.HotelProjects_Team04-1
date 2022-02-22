package pages.US0009;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US009Page {
    public US009Page() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//div[@class='caption']")
    public WebElement listOfUserElement;

    @FindBy(xpath = "//a[normalize-space()='Room reservations']")
    public WebElement roomReservationButton;
    @FindBy(xpath = "//tbody/tr[1]/td[14]/a[1]")
    public WebElement first1DetailButton;

    @FindBy(xpath = "//div[@class='col-md-8 col-sm-12']//div[@class='caption']")
    public WebElement hotelReservationDataElement;

    @FindBy(xpath = "//input[@id='ContactPhone']")
    public WebElement contactPhoneTextBox;

    @FindBy(xpath = "//input[@id='ContactEmail']")
    public WebElement contactEmailTextBox;


    @FindBy(xpath = "//div[@class='col-md-8 col-sm-12']//button[@class='btn green'][normalize-space()='Save']")
    public WebElement saveButton;

    @FindBy(xpath = "//button[@id='btnDelete']")
    public WebElement deleteButton;

    @FindBy(xpath = "//div[@class='bootbox-body']")
    public WebElement saveEdildi;

}
