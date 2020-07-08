package company.name.pages;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.cssSelector;

/**
 * Класс страницы для авторизации клиента
 */
public class Authentication extends AbstractPage {

    private By loginButton = cssSelector("#header-lk-button");                      // кнопка открытия окна авторизации
    private By loginFiled = cssSelector("#login");                                  // поле для ввода логина при входе
    private By passwordField = cssSelector("[type=password]");                      // поле для ввода пароля
    private By clickLogIn = cssSelector("[ng-tr=\"WHE1.WHE4\"]");                   // Кнопка войти в аккаунт
    private By clickLogOut = cssSelector("#logout");                                // Кнопка выйти
    /**
     * Конструктор. Загружает ссылку на тест-стенд из файла конфигурации и подгружает указанные веб-элементы
     */
    public Authentication () {
        super();
    }

    /**
     * Открытие тест стенда
     */
    public void openTestStand() {
        Selenide.open(testStand);
    }

    /**
     * Открывает окно авторизации
     */
    public void openPopUp() {
        $(loginButton).click();
    }

    /**
     * Заполняет поле email
     * @param email строка содержащая корректный email
     */
    public void inputEmail (String email) {
        $(loginFiled).sendKeys(email);
    }

    /**
     * Заполняет поле пароля
     * @param password строка содержащая корректный пароль
     */
    public void inputPassword(String password) {
        $(passwordField).sendKeys(password);
    }

    /**
     * Нажимает кнопку "Войти"
     */
    public void clickAuthentication(){
        $(clickLogIn).click();
    }

    /**
     * Нажимаем кнопку "Выйти"
     */
    public void logOut(){
        $(clickLogOut).click();
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
