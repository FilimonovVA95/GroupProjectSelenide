package company.name.positive;

import com.codeborne.selenide.Configuration;
import company.name.pages.AuthenticationPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Тест проверяет возможность войти с заданными логином и паролем
 * @author Филимонов Виктор
 */
public class AuthenticationClientTest {

    private String email = "kicoti9729@kartk5.com";     // Почта заранее зарагестрированного пользователя
    private String password = "QlwS1Z";                 // Пароль от личного кабинета клиента

    private AuthenticationPage step = new AuthenticationPage();

    @BeforeMethod
    public void start(){
        Configuration.startMaximized = true;
    }

    @Test
    public void authenticationClient() {
        step.openTestStand();
        step.openPopUp();
        step.inputEmail(email);
        step.inputPassword(password);
        step.clickAuthentication();
        step.logOut();
    }
}
