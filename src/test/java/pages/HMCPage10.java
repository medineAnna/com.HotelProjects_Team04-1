package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class HMCPage10 {
   public HMCPage10() {
       PageFactory.initElements(Driver.getDriver(), this);
   }

 @FindBy(xpath = "//a[text()='Log in']")
 public WebElement logInButtonu;
 @FindBy(xpath = "//span[text()='Create a new account']")
 public WebElement createNewAccount;
 @FindBy(xpath = "//input[@id='UserName']")
 public WebElement createUsername;



 @FindBy(xpath = "//input[@id='btnSubmit']")
 public WebElement createSaveButton;

 @FindBy(xpath = "//div[@class='bootbox-body']")
 public WebElement createSaveTexti;

 @FindBy(xpath = "//button[@class='btn btn-primary']")
 public WebElement createOkButton;

 @FindBy(xpath = "//input[@id='UserName']")
 public WebElement usernameBox;

 @FindBy(xpath = "//input[@id='Password']")
 public WebElement passwordBox;

 @FindBy(xpath = "//input[@id='btnSubmit']")
 public WebElement ikinciLoginButonu;

 @FindBy(xpath = "//a[.='Rooms']")
 public WebElement roomsButton;
 @FindBy(xpath = "//input[@class='form-control checkout_date required']")
 public WebElement checOutDateTextBox;

 @FindBy(xpath = "//input[@class='form-control checkin_date required']")
 public WebElement checkInDateTextBox;

 @FindBy(xpath = "(//select[@class='form-control'])[1]")
 public WebElement selectRoomTextBox;

 @FindBy(xpath = "(//select[@class='form-control'])[2]")
 public WebElement selectAdultTextBox;

 @FindBy(xpath = "(//select[@class='form-control'])[3]")
 public  WebElement selectChildrenTextBox;

 @FindBy(xpath = "//input[@id='location']")
 public WebElement locationTextBox;


 @FindBy(xpath = "//input[@value='Search']")
 public WebElement searchButton;

 @FindBy(xpath = "(//a[@class='btn-custom'])[8]")
 public WebElement bookNow8;

 @FindBy(xpath = "(//a[@class='btn-custom'])[6]")
 public WebElement bookNow6;

 @FindBy(xpath = "//a[@href='/Rooms/6']")
 public WebElement singleRoom;


 @FindBy(xpath = "//a[@href='/Rooms/7']")
 public WebElement doubleRoom;

 @FindBy(xpath = "//a[@href='/Rooms/8']")
 public WebElement tribleRoom;

 @FindBy(xpath = "//a[@href='/Rooms/317']")
 public WebElement quadRoom;

 @FindBy(xpath = "//a[@href='/Rooms/318']")
 public WebElement queenRoom;

 @FindBy(xpath = "//a[@href='/Rooms/319']")
 public WebElement kingRoom;

 @FindBy(xpath = "//a[@href='/Rooms/320']")
 public WebElement twinRoom;

 @FindBy(xpath = "//a[@href='/Rooms/321']")
 public WebElement doubleDoubleRoom;

 @FindBy(xpath = "//a[@href='/Rooms/322']")
 public WebElement studioRoom;

 @FindBy(xpath = "//select[@title='Select Room Type']")
 public WebElement selectRoomType;

 @FindBy(xpath = "//a[.='Triple room']")
 public WebElement odaSec;

 @FindBy(xpath = "//h2[@class='mb-4']")
 public WebElement secilenOdaTex;

 @FindBy(xpath = "//a[.='King room']")
 public WebElement odaSeciminegit;

 @FindBy(xpath = "//input[@id='checkin_date']")
 public WebElement checkin_date;

 @FindBy(xpath = "//input[@id='checkout_date']")
 public WebElement checkout_date;


 @FindBy(xpath = "//select[@id='AdultCount']")
 public WebElement AdultCount;

 @FindBy(xpath = "//select[@id='ChildrenCount']")
 public WebElement ChildrenCount;

 @FindBy(xpath = "//input[@placeholder='Name On Credit Card']")
 public WebElement nameOnCreditCard;

 @FindBy(xpath = "//input[@placeholder='Credit Card Number']")
 public WebElement creditCardNumber;

 @FindBy(xpath = "//select[@name='CreditCardExpirationYear']")
 public WebElement SelectExpirationYearForCreditCard;

 @FindBy(xpath = "//select[@name='CreditCardExpirationMonth']")
 public WebElement SelectExpirationMonthForCreditCard;

 @FindBy(xpath = "//input[@id='CVV']")
 public WebElement CVV;

 @FindBy(xpath = "//textarea[@id='Message']")
 public WebElement message;

 @FindBy(xpath = "//input[@value='Book this room']")
 public WebElement bookthisroom;

 @FindBy(xpath = "//div[@class='bootbox-body']")
 public WebElement reservationBasariliTexti;

 @FindBy(xpath = "//button[@class='btn btn-primary']")
 public WebElement rezervasyonOkButonu;

 @FindBy(xpath = "//button[@type='button']")
 public WebElement rezervasyonKapatmaButonu;

 @FindBy(xpath = "//a[.='Reservations']")
 public WebElement reservationsButton;

 @FindBy(xpath = "//h1[@class='mb-4 bread']")
 public WebElement reservationsTextStr;

 @FindBy(xpath = "(//tbody//tr//th)[5]")
 public WebElement approved;


 @FindBy(xpath = "(//tbody//tr//th)[4]")
 public WebElement endDate;

 @FindBy(xpath = "(//tbody//tr//th)[3]")
 public WebElement startDate;

 @FindBy(xpath = "(//tbody//tr//th)[2]")
 public WebElement price;

 @FindBy(xpath = "(//tbody//tr//th)[1]")
 public WebElement room;

 @FindBy(xpath = "//li[.='Profile']")
 public WebElement profileUrldekiButton;

}

