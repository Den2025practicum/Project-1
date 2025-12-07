package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import static pages.Constant.urlPageScooter;

public class MainPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    // Локаторы формы заказа самоката
    private final By CookiesBtn = By.cssSelector("button[id='rcc-confirm-button']");
    private final By OrderBtnUp = By.cssSelector("button[class='Button_Button__ra12g']"); //Кнопка заказать (вверху страницы)
    private final By OrderBtnDown = By.cssSelector("button[class='Button_Button__ra12g Button_Middle__1CSJM']"); //Кнопка заказать (внизу страницы)
    private final By Name = By.cssSelector("input[placeholder='* Имя']"); //Поле ввода Имени
    private final By DoubleName = By.cssSelector("input[placeholder='* Фамилия']"); //Поле ввода фамилии
    private final By Adress = By.cssSelector("input[placeholder='* Адрес: куда привезти заказ']"); //Поле ввода адреса
    private final By Metro = By.cssSelector("input[placeholder='* Станция метро']"); //Поле выбора станции метро
    private final By ChoiceMetro = By.className("select-search__row"); // Кнопка выбора станции метро из выпадающего списка
    private final By UserPhone = By.cssSelector("input[placeholder='* Телефон: на него позвонит курьер']"); //Поле ввода номера телефона
    private final By ThenBtn = By.xpath(".//div[@class='Order_NextButton__1_rCA']/button[text()='Далее']"); //Кнопка Далее
    private final By BringScooterField = By.xpath(".//div[@class='react-datepicker__input-container']/input[@type='text']"); //Поле ввода даты начала аренды самоката
    private final By DataOpenOrder = By.xpath(".//div[@class='react-datepicker__day react-datepicker__day--030 react-datepicker__day--selected']"); // Выбор даты из выпадающего списка
    private final By RentPeriodField = By.xpath(".//div[@class='Dropdown-root']"); //Поле Срок аренды
    private final By NumbDaysRent = By.xpath(".//div[@class='Dropdown-menu']/div[text()='двое суток']"); //Кнопка выбора срока аренды
    private final By ChekBoxColor = By.id("black"); //Кнопка чек-бокс выбора черного цвета самоката
    private final By Comint = By.cssSelector("input[placeholder='Комментарий для курьера']"); //Поле комментарий для курьера
    private final By FinishOrderBtn = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");
    private final By YesBtn = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Да']");
    private final By WindOrderScooter = By.className("Order_ModalHeader__3FDaJ"); // Окно с надписью Хотите оформить заказ?

    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public void openPage() { //Открыть страницу
        driver.get(urlPageScooter);
    }
    public void clickCookiesBtn() { driver.findElement(CookiesBtn).click(); } //Нажать на кнопку Cookie
    public void clickOrderBtnUp() { driver.findElement(OrderBtnUp).click(); } //Нажать на кнопку Заказать (вверху страницы)
    public void clickOrderBtnDown() { // Используем метод путем скролла до появления кнопки Заказать в нижней части и небольшого ожидания
        WebElement element = driver.findElement(OrderBtnDown);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        try {
            TimeUnit.SECONDS.sleep(3); // 1 секунда ожидания
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(OrderBtnDown).click(); //Нажать на кнопку Заказать (внизу страницы)
    }
    public void getName(String string) { driver.findElement(Name).sendKeys(string); }
    public void getDoubleName(String string) { driver.findElement(DoubleName).sendKeys(string); }
    public void getAdress(String string) {
        driver.findElement(Adress).sendKeys(string);
    }
    public void getMetro(String string) {
        driver.findElement(Metro).sendKeys("Черкизовская");
    }
    public void clickChoiceMetro() { // Выбор станции метро из выпадающего списка
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(ChoiceMetro));
        input.click();
    }
    public void getUserPhone(String string) { // Ввод номера телефона
        driver.findElement(UserPhone).sendKeys(string);
    }
    public void clickThenBtn() { //Нажимаем на кнопку далее
        driver.findElement(ThenBtn).click();
    }
    public void clickBringScooterField() { //В поле вводим дату когда привезти самокат
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(BringScooterField));
        input.sendKeys("30.12.2025");
    }
    public void clickRentPeriodField() { // Выбираем срок аренды
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(DataOpenOrder));
        input.click(); //Кликаем (активируем) по полю выбора даты
        driver.findElement(RentPeriodField).click();
    }
    public void clickNumbDaysRent() { //Кликаем по дате из выпадающего списка
        driver.findElement(NumbDaysRent).click();
    }
    public void clickChekBoxColor() { //Кликаем по чек-боксу выбора цвета самоката
        driver.findElement(ChekBoxColor).click();
    }
    public void getComit(String string) { //Вводим доп.коментарии
        driver.findElement(Comint).sendKeys(string);
    }
    public void clickFinishOrderBtn() {
        driver.findElement(FinishOrderBtn).click();
        // Добавляем ожидание чтобы удостовериться, что предыдущие элементы выполнены
        try {
            TimeUnit.SECONDS.sleep(1); // 1 секунд ожидания
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void clickYesBtn() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(WindOrderScooter)); // Ожидание появления элемента окна с надписью "Хотите оформить заказ?"
        driver.findElement(YesBtn).click();
    }
}