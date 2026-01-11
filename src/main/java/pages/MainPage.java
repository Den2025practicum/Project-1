package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static pages.Constant.urlPageScooter;

public class MainPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    // Локаторы формы заказа самоката
    private final By cookiesBtn = By.cssSelector("button[id='rcc-confirm-button']");
    private final By orderBtnUp = By.cssSelector("button[class='Button_Button__ra12g']"); //Кнопка заказать (вверху страницы)
    private final By orderBtnDown = By.cssSelector("button[class='Button_Button__ra12g Button_Middle__1CSJM']"); //Кнопка заказать (внизу страницы)
    private final By nameField = By.cssSelector("input[placeholder='* Имя']"); //Поле ввода Имени
    private final By doubleNameField = By.cssSelector("input[placeholder='* Фамилия']"); //Поле ввода фамилии
    private final By adressField = By.cssSelector("input[placeholder='* Адрес: куда привезти заказ']"); //Поле ввода адреса
    private final By metroField = By.cssSelector("input[placeholder='* Станция метро']"); //Поле выбора станции метро
    private final By choiceMetro = By.className("select-search__row"); // Кнопка выбора станции метро из выпадающего списка
    private final By userPhoneField = By.cssSelector("input[placeholder='* Телефон: на него позвонит курьер']"); //Поле ввода номера телефона
    private final By thenBtn = By.xpath(".//div[@class='Order_NextButton__1_rCA']/button[text()='Далее']"); //Кнопка Далее
    private final By bringScooterField = By.xpath(".//div[@class='react-datepicker__input-container']/input[@type='text']"); //Поле ввода даты начала аренды самоката
    private final By dataOpenOrder = By.xpath(".//div[@class='react-datepicker__day react-datepicker__day--030 react-datepicker__day--selected']"); // Выбор даты из выпадающего списка
    private final By rentPeriodField = By.xpath(".//div[@class='Dropdown-root']"); //Поле Срок аренды
    private final By numbDaysRent = By.xpath(".//div[@class='Dropdown-menu']/div[text()='двое суток']"); //Кнопка выбора срока аренды
    private final By chekBoxColor = By.id("black"); //Кнопка чек-бокс выбора черного цвета самоката
    private final By comintField = By.cssSelector("input[placeholder='Комментарий для курьера']"); //Поле комментарий для курьера
    private final By finishOrderBtn = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");
    private final By yesBtn = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Да']");
    private final By windOrderScooter = By.className("Order_ModalHeader__3FDaJ"); // Окно с надписью Хотите оформить заказ?

    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public void openPage() { //Открыть страницу
        driver.get(urlPageScooter);
    }
    public void clickCookiesBtn() { driver.findElement(cookiesBtn).click(); } //Нажать на кнопку Cookie
    public void clickOrderBtnUp() { driver.findElement(orderBtnUp).click(); } //Нажать на кнопку Заказать (вверху страницы)
    public void clickOrderBtnDown() { // Используем метод путем скролла до появления кнопки Заказать в нижней части и небольшого ожидания
        WebElement element = driver.findElement(orderBtnDown);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(orderBtnDown).click(); //Нажать на кнопку Заказать (внизу страницы)
    }
    public void getName(String string) { driver.findElement(nameField).sendKeys(string); }
    public void getDoubleName(String string) { driver.findElement(doubleNameField).sendKeys(string); }
    public void getAdress(String string) {
        driver.findElement(adressField).sendKeys(string);
    }
    public void getMetro(String string) {
        driver.findElement(metroField).sendKeys("Черкизовская");
    }
    public void clickChoiceMetro() { // Выбор станции метро из выпадающего списка
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(choiceMetro));
        input.click();
    }
    public void getUserPhone(String string) { // Ввод номера телефона
        driver.findElement(userPhoneField).sendKeys(string);
    }
    public void clickThenBtn() { //Нажимаем на кнопку далее
        driver.findElement(thenBtn).click();
    }
    public void clickBringScooterField() { //В поле вводим дату когда привезти самокат
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(bringScooterField));
        input.sendKeys("30.12.2025");
    }
    public void clickRentPeriodField() { // Выбираем срок аренды
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(dataOpenOrder));
        input.click(); //Кликаем (активируем) по полю выбора даты
        driver.findElement(rentPeriodField).click();
    }
    public void clickNumbDaysRent() { //Кликаем по дате из выпадающего списка
        driver.findElement(numbDaysRent).click();
    }
    public void clickChekBoxColor() { //Кликаем по чек-боксу выбора цвета самоката
        driver.findElement(chekBoxColor).click();
    }
    public void getComit(String string) { //Вводим доп.комментарии
        driver.findElement(comintField).sendKeys(string);
    }
    public void clickFinishOrderBtn() {
        driver.findElement(finishOrderBtn).click();
    }
    public void clickYesBtn() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(windOrderScooter)); // Ожидание появления элемента окна с надписью "Хотите оформить заказ?"
        driver.findElement(yesBtn).click();
    }
}