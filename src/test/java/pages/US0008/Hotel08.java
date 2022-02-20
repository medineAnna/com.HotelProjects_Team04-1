package pages.US0008;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pages.OrtakHMCPageBurayiSakinKurcalama.HMCMainPage;
import utilities.Driver;
public class Hotel08 extends HMCMainPage{
    Actions actions=new Actions(Driver.getDriver());
    public void Hotel08() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath ="(//a[@href='/admin/RoomReservationAdmin'])[1]")
    public WebElement roomReservationsElementi;
    @FindBy(xpath = "//span[text()='List Of Reservations']")
    public WebElement listofreservationsYazisi;
    @FindBy(xpath ="//span[@class='hidden-480'] ")
    public WebElement addRoomReservationElementi;
    @FindBy(xpath ="//select[@id='IDUser']")
    public WebElement ıduser1Elementi;
    @FindBy(xpath ="//select[@title='Select HotelRoom']")
    public WebElement ıduser2Elementi;
}