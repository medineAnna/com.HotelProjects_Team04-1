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

}
