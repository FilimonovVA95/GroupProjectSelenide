package company.name.positive.steps;

import company.name.pages.Download;
import io.qameta.allure.Step;
import org.testng.Assert;

import static io.qameta.allure.Allure.step;

public class DownloadStep extends AbstractPositiveStep{

    private Download downloadStep = new Download();


    @Step("Открыть тестовый стенд")
    public void openTestStand(){
        downloadStep.openTestStand();
        step("Проверяем активность кнопки 'Войти'", () -> {
            Assert.assertTrue(downloadStep.checkLoginButton(), "'Login' button not active");
        });
        screenShotStep();
    }

    @Step("Нажать кнопку 'Войти'")
    public void openPopUpStep(){
        downloadStep.openPopUp();
        step("Проверяем активность кнопки 'Забыли пароль'", () -> {
            Assert.assertTrue(downloadStep.checkForgotPassword(), "The 'Forgot Password' button is inactive");
        });
        screenShotStep();
    }

    @Step("Нажать кнопку 'Зарегистрироватся'")
    public void clickRegistrationStep(){
        downloadStep.clickRegistrationButton();
        step("Проверяем активность кнопки 'Стать клиентом'", () -> {
            Assert.assertTrue(downloadStep.checkNewRegistrationClientButton(),"The 'Become a customer' button is inactive");
        });
        screenShotStep();
    }

    @Step("Нажать кнопку 'Стать клиентом'")
    public void clickRegistrationClientStep(){
        downloadStep.clickRegistrationClient();
        step("Проверяем активность кнопки 'Зарегистрироватся'", () -> {
            Assert.assertTrue(downloadStep.checkRegistrationClientOnFieldRegistration(), "'Register' button is not active");
        });
        screenShotStep();
    }
    @Step("Нажать Кнопку 'Условия передачи информации'")
    public void downloadAndReadsStep(){
        downloadStep.downloadAndReads();
    }
}
