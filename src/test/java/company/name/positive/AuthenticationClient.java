package company.name.positive;

import com.codeborne.selenide.Configuration;
import company.name.positive.steps.AuthenticationClientPositiveStep;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Тест проверяет возможность войти с заданными логином и паролем
 * @author Филимонов Виктор
 * @see AuthenticationClientPositiveStep
 */
public class AuthenticationClient {

    private String email = "kicoti9729@kartk5.com";     // Почта заранее зарагестрированного пользователя
    private String password = "QlwS1Z";                 // Пароль от личного кабинета клиента

    private AuthenticationClientPositiveStep step = new AuthenticationClientPositiveStep();

    @BeforeMethod
    public void start(){
        Configuration.startMaximized = true;
    }

    @Test
    public void authenticationClient() {
        step.openTestStandStep();
        step.openPopUpStep();
        step.inputEmailStep(email);
        step.inputPasswordStep(password);
        step.clickAuthenticationStep();
        step.logOutStep();
    }
}
