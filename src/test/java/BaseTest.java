import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.FaqPage;
import pages.MainPage;

public class BaseTest {
    WebDriver driver;
    MainPage mainPage;
    OrderPage orderPage;
    FaqPage faqPage;

    @Before
    public void startUp() {
        String browser = System.getProperty("browser", "chrome"); // Значение по умолчанию для браузера Googl chrome
        if (browser.equals("chrome")) {
            startBrowserChrome();
        } else if (browser.equals("firefox")) {
            startBrowserFireFox();
        }
        // Для браузера Firefox
//        String browser = System.getProperty("browser", "firefox"); // Значение по умолчанию
//        if (browser.equals("firefox")) {//(browser.equals("chrome")) {
//            startBrowserFireFox();//startBrowserChrome();
//        } else if (browser.equals("chrome")) {//(browser.equals("firefox")) {
//            startBrowserChrome();//startBrowserFireFox();
//        }
        mainPage = new MainPage(driver);
        orderPage = new OrderPage(driver);
        faqPage = new FaqPage(driver);
    }
    public void startBrowserFireFox() {
        driver = new FirefoxDriver();
        WebDriverManager.firefoxdriver().setup();
    }
    public void startBrowserChrome() {
        driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
    }
    @After
    public void trDown() {
        driver.quit();
    }
}