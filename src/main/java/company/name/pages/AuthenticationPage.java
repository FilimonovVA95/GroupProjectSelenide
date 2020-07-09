package company.name.pages;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.cssSelector;

/**
 * Класс страницы для авторизации клиента
 */
public class AuthenticationPage extends AbstractPage {

    private By loginButton = cssSelector("#header-lk-button");                      // кнопка открытия окна авторизации
    private By loginFiled = cssSelector("#login");                                  // поле для ввода логина при входе
    private By passwordField = cssSelector("[type=password]");                      // поле для ввода пароля
    private By clickLogIn = cssSelector("[ng-tr=\"WHE1.WHE4\"]");                   // Кнопка войти в аккаунт
    private By clickLogOut = cssSelector("#logout");                                // Кнопка выйти
    /**
     * Конструктор. Загружает ссылку на тест-стенд из файла конфигурации и подгружает указанные веб-элементы
     */
    public AuthenticationPage() {
        super();
    }

    @Step("Открыть тестовый стенд")
    public void openTestStand() {
        Selenide.open(getStand());
        checkAndScreenShot("Проверяем активность кнопки 'Войти'",
                checkLoginButton(), "Open test stand exception");
    }

    @Step("Нажать кнопку 'Войти'")
    public void openPopUp() {
        $(loginButton).click();
        checkAndScreenShot("Проверяем открытие окна авторизации",
                checkClickLogIn(), "Open popUp exception");
    }

    @Step("Ввести e-mail")
    public void inputEmail (String email) {
        $(loginFiled).sendKeys(email);
        checkAndScreenShot("Проверяем правильность ввода email",
                checkLoginField(email), "Input email authorization exception");
    }

    @Step("Ввести пароль")
    public void inputPassword(String password) {
        $(passwordField).sendKeys(password);
        checkAndScreenShot("Проверяем правильность ввода пароля",
                checkPasswordField(password), "Input password authorization exception");
    }

    @Step("Нажать кнопку войти")
    public void clickAuthentication(){
        $(clickLogIn).click();
        checkAndScreenShot("Проверяем активность кнопки 'Выйти'",
                checkClickLogOut(), "Client login exception");
    }

    @Step("Нажать кнопку выйти")
    public void logOut(){
        $(clickLogOut).click();
        checkAndScreenShot("Проверяем активность кнопки 'Войти'",
                checkLoginButton(), "Client LogOut exception");
    }

    /**
     * Проверяем активность кнопки "Войти"
     * @return true, если элемент найден
     */
    public boolean checkLoginButton() {
        return $(loginButton).isEnabled();
    }

    /**
     * Проверяем, что email коррентно введен
     * @param email введеный email
     * @return true, если элемент найден
     */
    public boolean checkLoginField(String email) {
        return $(loginFiled).getAttribute("value").equals(email);
    }

    /**
     * Проверяем, что пароль коррентно введен
     * @param password введеный пароль
     * @return true, если элемент найден
     */
    public boolean checkPasswordField(String password) {
        return $(passwordField).getAttribute("value").equals(password);
    }

    /**
     * Проверяем наличие кнопки "Войти"
     * @return true, если элемент найден
     */
    public boolean checkClickLogIn() {
        return $(clickLogIn).isEnabled();
    }

    /**
     * Проверяем наличие кнопки "Выйти"
     * @return true, если элемент найден
     */
    public boolean checkClickLogOut() {
        return $(clickLogOut).isEnabled();
    }

}
