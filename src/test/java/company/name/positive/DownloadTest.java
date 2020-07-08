package company.name.positive;

import com.codeborne.selenide.Configuration;
import company.name.pages.Download;
import company.name.positive.steps.DownloadStep;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DownloadTest {
    DownloadStep step = new DownloadStep();


    @BeforeMethod
    public void start(){
        Configuration.startMaximized = true;
    }

    @Test
    public void test(){
        step.openTestStand();
        step.openPopUpStep();
        step.clickRegistrationStep();
        step.clickRegistrationClientStep();
        step.downloadAndReadsStep();
    }
}
