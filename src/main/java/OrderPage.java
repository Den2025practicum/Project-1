import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class OrderPage {
    private final WebDriver driver;
    private static final By messageAboutPlacingOrder = By.xpath(".//div[@class='Order_NextButton__1_rCA']/button[text()='Посмотреть статус']"); // Сообщение о подтверждении заказа;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement getMessageAboutPlacingOrder() {
        return driver.findElement(messageAboutPlacingOrder); // Поиск сообщения о подтверждении заказа;
    }
}