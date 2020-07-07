package company.name.pages;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Абстрактный класс страницы. Загружает ссылку на тест-стенд из файла конфигурации и подгружает указанные веб-элементы
 */
public abstract class AbstractPage {
        /**
         * Поле страницы тест-стенда, загруженного с файла конфигурации
         */
        public static String testStand;

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
}
