package company.name.positive;

import com.codeborne.selenide.Configuration;
import company.name.pages.DownloadPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DownloadPageTest {

    private String message = "Условия передачи информации";

    DownloadPage step = new DownloadPage();

    @BeforeMethod
    public void start(){
        Configuration.startMaximized = true;
    }

    @Test
    public void test(){
        step.openTestStand();
        step.openPopUp();
        step.clickRegistrationButton();
        step.clickRegistrationClient();
        step.clickDownloadButton();
        step.downloadAndReads(message);
    }
}
