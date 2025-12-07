import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertTrue;
import static pages.FaqPage.driver;


@RunWith(Parameterized.class)
public class OrderTest extends BaseTest {

    // Параметры для теста
    private final String name;
    private final String doubleName;
    private final String address;
    private final String metro;
    private final String phone;
    private static int i = 0;

    // Конструктор с параметрами
    public OrderTest(String name, String doubleName, String address, String metro, String phone) {
        this.name = name;
        this.doubleName = doubleName;
        this.address = address;
        this.metro = metro;
        this.phone = phone;
    }

    // Наборы параметров для тестирования
    @Parameterized.Parameters(name = "Test with {0}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Алексей", "Коваленко", "ул. Мира 46", "Черкизовская", "+79009632148"}, // Данные о 1 пользователе
                {"Евгений", "Петров", "пр. Чехова 82", "ВДНХ", "+79643214569"}, // Данные о 2 пользователе
                {"Петр", "Иванов", "ул. Фрунзе 137", "ВДНХ", "+79356987412"} // Данные о 2 пользователе
        });
    }
    @Test
    public void orderScooter() {
        mainPage.openPage(); // Открыть веб страницу
        mainPage.clickCookiesBtn(); // Кликнуть на кнопку Cookies
        if ( i < 2) {
            mainPage.clickOrderBtnUp(); // Кликнуть на кнопку заказать (в верхней части страницы)
            i = i + 1; // Счетчик используемый для проверки нижней кнопки Заказать
        }    else { mainPage.clickOrderBtnDown(); }// Кликнуть на кнопку заказать (внизу страницы)
        mainPage.getName(name); // Ввод имени в поле
        mainPage.getDoubleName(doubleName); // Ввод фамилии в поле
        mainPage.getAdress(address); // Ввод адреса в поле
        mainPage.getMetro(metro); // Ввод названия станции метро в Поле
        mainPage.clickChoiceMetro(); // Клик из выпадающего списка по названию станции метро
        mainPage.getUserPhone(phone); // Ввод номера телефона в поле
        mainPage.clickThenBtn(); // Клик по кнопке Далее
        mainPage.clickBringScooterField(); // Ввод даты в поле * Когда привезти самокат
        mainPage.clickRentPeriodField(); //Клик по полю Срок аренды
        mainPage.clickNumbDaysRent(); // Клик по выбору количества суток аренды
        mainPage.clickChekBoxColor(); //Клик по чек-боксу выбора цвета самоката
        mainPage.getComit("Позвонить"); // Ввод текста в поле Комментарии для курьера
        mainPage.clickFinishOrderBtn(); // Клик по кнопке Заказать
        mainPage.clickYesBtn(); // Клик по кнопке подтверждения заказа "Да"

        assertTrue("Заказ не оформлен", orderPage.getMessageAboutPlacingOrder().isEnabled()); // Ожидаемый результат - Подтверждение заказа
    }
}