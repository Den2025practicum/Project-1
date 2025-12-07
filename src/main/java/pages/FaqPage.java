package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class FaqPage {
    public static WebDriver driver;

    // Локаторы раздела "Вопросы о важном" (FAQ)
    private static final By questRentPrice = By.id("accordion__heading-0");
    private static final By ansRentPrice = By.id("accordion__panel-0");
    private static final By questMultScooters = By.id("accordion__heading-1");
    private static final By ansMultScooters = By.id("accordion__panel-1");
    private static final By questRentTime = By.id("accordion__heading-2");
    private static final By ansRentTime = By.id("accordion__panel-2");
    private static final By questScooterForToday = By.id("accordion__heading-3");
    private static final By ansScooterForToday = By.id("accordion__panel-3");
    private static final By questLeaseExtension = By.id("accordion__heading-4");
    private static final By ansLeaseExtension = By.id("accordion__panel-4");
    private static final By questCharging = By.id("accordion__heading-5");
    private static final By ansCharging = By.id("accordion__panel-5");
    private static final By questCancellation = By.id("accordion__heading-6");
    private static final By cancellationAnsv = By.id("accordion__panel-6");
    private static final By questMcd = By.id("accordion__heading-7");
    private static final By ansMcd = By.id("accordion__panel-7");

    public FaqPage(WebDriver driver) {
        FaqPage.driver = driver;
    }

    public static By clickQuestionRentPrice() { return questRentPrice; }
    public static By getAnswerRentPrice() { return ansRentPrice; }
    public static By clickquestMultScooters() { return questMultScooters;}
    public static By getansMultScooters() { return ansMultScooters; }
    public static By clickquestRentTime() { return questRentTime; }
    public static By getansRentTime() { return ansRentTime; }
    public static By clickquestScooterForToday() { return questScooterForToday; }
    public static By getansScooterForToday() { return ansScooterForToday; }
    public static By clickquestLeaseExtension() {
        return questLeaseExtension;
    }
    public static By getansLeaseExtension() { return ansLeaseExtension; }
    public static By clickquestCharging() {
        return questCharging;
    }
    public static By getansCharging() { return ansCharging; }
    public static By clickQuestCancellation() {
        return questCancellation;
    }
    public static By getcancellationAnsv() { return cancellationAnsv; }
    public static By clickquestMcd() {
        return questMcd;
    }
    public static By getansMcd() { return ansMcd; }
    public static void clickQuestion(By questionLocator) {

        WebElement element = driver.findElement(By.className("Home_FAQ__3uVm4"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(questionLocator).click();
        try {
            TimeUnit.SECONDS.sleep(1); // 1 секунда ожидания
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}