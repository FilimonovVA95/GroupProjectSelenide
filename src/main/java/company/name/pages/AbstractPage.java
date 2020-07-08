package company.name.pages;

import io.qameta.allure.Attachment;
import org.testng.Assert;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.screenshot;
import static io.qameta.allure.Allure.step;

/**
 * Абстрактный класс страницы. Загружает ссылку на тест-стенд из файла конфигурации и подгружает указанные веб-элементы
 */
public abstract class AbstractPage {
        /**
         * Поле страницы тест-стенда, загруженного с файла конфигурации
         */
        private static String testStand;

        /**
         * Конструктор. Загружает ссылку на тест-стенд из файла конфигурации и подгружает указанные веб-элементы
         */
        public AbstractPage() {
            InputStream inputStream = AbstractPage.class.getClassLoader().getResourceAsStream("config.properties");
            Properties properties = new Properties();
            try {
                properties.load(inputStream);
            } catch (IOException e) {
                throw new RuntimeException((e));
            }
            testStand = properties.getProperty("test.stand");
        }

        public static String getStand() {
            return testStand;
        }

    @Attachment(value = "Page screenshot", type = "image/png")
    protected void screenShotStep() {
        String screenName = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
        String className = this.getClass().getSimpleName();
        screenshot("./ScreenShots/" + className + "/" + screenName + "_Screenshot.png");
    }

    protected void checkAndScreenShot (String nameStep, boolean check, String message) {
        step(nameStep, () -> {
            Assert.assertTrue(check, message);
        });
        screenShotStep();
    }
}
