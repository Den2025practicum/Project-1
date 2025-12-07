import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class OrderPage {
    private final WebDriver driver;
    private static final By textAboutRent = By.cssSelector("front[text()='Про аренду']"); // Локатор окна с надписью "Про аренду"
    private static final By messageAboutPlacingOrder = By.xpath(".//div[@class='Order_NextButton__1_rCA']/button[text()='Посмотреть статус']"); // Сообщение о подтверждении заказа;
    private static final By textWhoScooterFor = By.cssSelector("div[text()='Для кого самокат']"); // Локатор окна с надписью "Для кого самокат"

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }
    public static By getTextAboutRent() {
        return textAboutRent; // Поиск окна с текстом "Про аренду"
    }
    public static By getTextWhoScooterFor() {
        return textWhoScooterFor; // Ожидание появления окна с надписью "Для кого самокат"
    }
    public WebElement getMessageAboutPlacingOrder() {
        return driver.findElement(messageAboutPlacingOrder); // Поиск сообщения о подтверждении заказа;
    }
}