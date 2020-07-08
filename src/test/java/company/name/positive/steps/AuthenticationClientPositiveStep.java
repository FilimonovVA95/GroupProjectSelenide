package company.name.positive.steps;

import company.name.pages.AuthenticationPage;
import io.qameta.allure.Step;
import org.testng.Assert;

import static io.qameta.allure.Allure.step;

/**
 * Класс шагов для теста по авторизации клиента
 */
public class AuthenticationClientPositiveStep extends AbstractPositiveStep {

    private AuthenticationPage authentication = new AuthenticationPage();

    @Step("Открыть тестовый стенд")
    public void openTestStandStep() {
        authentication.openTestStand();
        step("Проверяем активность кнопки 'Войти'", () -> {
            Assert.assertTrue(authentication.checkLoginButton(), "Open test stand exception");
        });
        screenShotStep();
    }

    @Step("Нажать кнопку 'Войти'")
    public void openPopUpStep(){
        authentication.openPopUp();
        step("Проверяем открытие окна авторизации", () -> {
            Assert.assertTrue(authentication.checkClickLogIn(), "Open popUp exception");
        });
        screenShotStep();
    }

    @Step("Ввести e-mail")
    public void inputEmailStep(String email){
        authentication.inputEmail(email);
        step("Проверяем правильность ввода email", () -> {
            Assert.assertTrue(authentication.checkLoginField(email), "Input email authorization exception");
        });
        screenShotStep();
    }

    @Step("Ввести пароль")
    public void inputPasswordStep(String password){
        authentication.inputPassword(password);
        step("Проверяем правильность ввода пароля", () -> {
            Assert.assertTrue(authentication.checkPasswordField(password), "Input password authorization exception");
        });
        screenShotStep();
    }

    @Step("Нажать кнопку войти")
    public void clickAuthenticationStep(){
        authentication.clickAuthentication();
        step("Проверяем активность кнопки 'Выйти'", () -> {
            Assert.assertTrue(authentication.checkClickLogOut(), "Client login exception");
        });
        screenShotStep();
    }

    @Step("Нажать кнопку выйти")
    public void logOutStep(){
        authentication.logOut();
        step("Проверяем активность кнопки 'Войти'", () -> {
            Assert.assertTrue(authentication.checkLoginButton(), "Client LogOut exception");
        });
        screenShotStep();
    }

}
