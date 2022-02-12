package pages.pagesUS0007;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.OrtakHMCPageBurayiSakinKurcalama.HMCMainPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class HotelMyCampPage extends HMCMainPage  {
    Actions actions = new Actions(Driver.getDriver());

    public HotelMyCampPage() {
        PageFactory.initElements(Driver.getDriver(), this);
        // PageFactory.initElements(Driver.getDriver(),this);
        // bu bizim driverimiza ilk degeri atiyor
        // this icinde bulundugu page sayfasinda kendi
        // driverimizin olduugunu declare etmis oluyor
    }






    public WebElement hotelRoomsIlkSayfaWebTables(int satir, int sutun) {
        String dinamikXpath = "//tbody/tr[" + satir + "]/td[" + sutun + "]";
        WebElement webTableIstediginSutunuYazdir = Driver.getDriver().findElement(By.xpath(dinamikXpath));
        return webTableIstediginSutunuYazdir;
    }


    public void hotelRoomsWebTablinIsteginSayfasinaGit(int sayfa) {
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
        hotelRoomsWebTablinIsteginSayfasinaGit(5);
        ReusableMethods.waitFor(2);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(2);
        webTableSayfasindakiIsteginDetailsButonunaDirekTikla(10, 9);
        propertiesSekmesiElementi.click();
    }
    public void direkPhotostSayfasinaGit() {
        hotelRoomsWebTablinIsteginSayfasinaGit(5);
        ReusableMethods.waitFor(2);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(2);
        webTableSayfasindakiIsteginDetailsButonunaDirekTikla(10, 9);
        photosSekmesiElementi.click();
    }
    public void direkGeneralDataSayfasinaGit(){
        hotelRoomsWebTablinIsteginSayfasinaGit(5);

    }

}