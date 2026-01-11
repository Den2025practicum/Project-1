package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class FaqPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Локаторы для вопросов и ответов
    private static final String questionLocator = "accordion__heading-";
    private static final String answerLocator = "accordion__panel-";
    private static final By additionalQuestion = By.className("Home_FAQ__3uVm4");

    public FaqPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Метод для клика по вопросу и получения ответа
    public String getFaqAnswer(int questionNumber) {
        By questionLocator = By.id(FaqPage.questionLocator + questionNumber);
        By answerLocator = By.id(FaqPage.answerLocator + questionNumber);

        scrollToElement(additionalQuestion);
        clickElement(questionLocator);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(answerLocator)).getText();
    }

    private void clickElement(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    private void scrollToElement(By locator) {
        WebElement element = driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});",
                element
        );
    }
}