package company.name.pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import java.io.*;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.element;
import static org.openqa.selenium.By.cssSelector;

public class Download extends AbstractPage {

    private By loginButton = cssSelector("#header-lk-button");  // кнопка открытия окна авторизации
    private By forgotPassword = cssSelector("[ng-tr=\"WHE.WHE23\"]");
    private By registrationButton = cssSelector("[ng-tr=\"WHE.WHE20\"]");
    private By registrationClient = cssSelector("[ng-tr=\"WHE1.WHE12\"]");
    private By downloadButton = cssSelector("[href=\"assets/files/tester_conditions.pdf\"]");
    private By registrationClientOnFieldRegistration = cssSelector("[ng-tr=\"WHE.WHE26\"]");

    /**
     * Конструктор. Загружает ссылку на тест-стенд из файла конфигурации и подгружает указанные веб-элементы
     */
    public Download() {
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

    public void clickRegistrationButton() {
        $(registrationButton).click();
    }

    /**
     *
     */
    public void clickRegistrationClient() {
        $(registrationClient).click();
    }

    public void clickDownloadButton() {
        $(downloadButton).click();
    }

    /**
     * @return
     */
    public boolean checkLoginButton() {
        return $(loginButton).isEnabled();
    }

    /**
     * @return
     */
    public boolean checkForgotPassword() {
        return $(forgotPassword).isEnabled();
    }

    /**
     * @return
     */
    public boolean checkNewRegistrationClientButton() {
        return $(registrationClient).isEnabled();
    }

    /**
     * @return
     */
    public boolean checkRegistrationClientOnFieldRegistration() {
        return $(registrationClientOnFieldRegistration).isEnabled();
    }

    public void downloadAndReads() {
        String filePath = "./Download";
        Configuration.reportsFolder = filePath;
        File file = null;
        try {
            file = element(downloadButton).download();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

