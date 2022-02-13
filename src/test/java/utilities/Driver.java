package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {
    private Driver(){//artik driverdan obje baska class obje uretemez
// iste private yapmaya 13. satirda SingletonPattern denir
    }
    public static WebDriver driver;

    public static WebDriver getDriver() {

        if (driver == null) {//bu if sayesindfe kod calisirken bir kere new keyword ile driver olustrudugumuz
            //icin bu if blogu 1 kere calisacak ve 2.ce if blogu devreye girmeyecektir
            //**burdaki null i  drivera deger atanmamaissa anlaminda kulladik onemli *****

            switch (ConfigReader.getProperty("browser")) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "opera":
                    WebDriverManager.operadriver().setup();
                    driver = new OperaDriver();
                    break;
                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                    break;
                default:
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
            }
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {//burda drivera deger atanmissa anlaminda kullandik
            driver.quit();
            driver = null;
        }

    }


}
