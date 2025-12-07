import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.Collection;
import pages.FaqPage;

@RunWith(Parameterized.class)
public class FaqTest extends BaseTest{

    private final By questionLocator;
    private final By answerLocator;
    private final String expectedAnswer;

    // Конструктор, принимающий параметры из набора данных
    public FaqTest(By questionLocator, By answerLocator, String expectedAnswer) {
        this.questionLocator = questionLocator;
        this.answerLocator = answerLocator;
        this.expectedAnswer = expectedAnswer;
    }
    // Метод, предоставляющий наборы параметров для тестов
    @Parameterized.Parameters(name = "FAQ: {2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {FaqPage.clickQuestionRentPrice(), FaqPage.getAnswerRentPrice(),
                        "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {FaqPage.clickquestMultScooters(), FaqPage.getansMultScooters(),
                        "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {FaqPage.clickquestRentTime(), FaqPage.getansRentTime(),
                        "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {FaqPage.clickquestScooterForToday(), FaqPage.getansScooterForToday(),
                        "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {FaqPage.clickquestLeaseExtension(), FaqPage.getansLeaseExtension(),
                        "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {FaqPage.clickquestCharging(), FaqPage.getansCharging(),
                        "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {FaqPage.clickQuestCancellation(), FaqPage.getcancellationAnsv(),
                        "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {FaqPage.clickquestMcd(), FaqPage.getansMcd(),
                        "Да, обязательно. Всем самокатов! И Москве, и Московской области."}
        });
    }
    @Test
    public void checkFaqAnswer() {
        mainPage.openPage(); // Открыть веб страницу
        mainPage.clickCookiesBtn(); // Кликнуть на кнопку Cookies
        FaqPage.clickQuestion(questionLocator);
        String actualAnswer = driver.findElement(answerLocator).getText();
        assertEquals("Текст ответа не совпадает с ожидаемым",expectedAnswer, actualAnswer);
    }
}