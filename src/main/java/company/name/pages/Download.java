package company.name.pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import com.itextpdf.text.pdf.parser.SimpleTextExtractionStrategy;
import com.itextpdf.text.pdf.parser.TextExtractionStrategy;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;

import java.io.*;

import static com.codeborne.selenide.Selenide.$;
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

    public boolean downloadAndReads(String message) {
        String filePath = ".\\Download\\";
        Configuration.reportsFolder = filePath;
        String fullName = null;
        String text = null;

        File file;
        try {
            file = $(downloadButton).download();
            fullName = ".\\" + file.getPath();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        PdfReader reader = null;
        try {
            reader = new PdfReader(fullName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 1; i <= reader.getNumberOfPages(); ++i) {
            TextExtractionStrategy strategy = new SimpleTextExtractionStrategy();
            try {
                text = PdfTextExtractor.getTextFromPage(reader, i, strategy);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        reader.close();
        try {
            FileUtils.deleteDirectory(new File(".\\build\\downloads"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text.contains(message);
    }
}

