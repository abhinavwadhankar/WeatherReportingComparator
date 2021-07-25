package accuweather.com.ui.pages;

import accuweather.com.ui.utilites.BrowserName;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class BasePage {

    private static WebDriver driver;

    public  BasePage()
    {   // Default Chrome
       this.setUpBrowser("chrome");
    }

    public void setUpBrowser(String browserName )
    {
        if (BrowserName.CHROME.getBrowserName().equalsIgnoreCase(browserName))
        {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
         }
         else if(BrowserName.FIREFOX.getBrowserName().equalsIgnoreCase(browserName))
        {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        BasePage.driver = driver;
    }

    public void openUrl(String url)
    {
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);
        driver.manage().window().maximize();
    }

    public void closeBrowser()
    {
        driver.close();
        driver.quit();
    }
}
