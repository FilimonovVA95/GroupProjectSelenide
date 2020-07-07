package company.name.positive.steps;

import java.text.SimpleDateFormat;
import java.util.Date;
import static com.codeborne.selenide.Selenide.screenshot;

public class AbstractPositiveStep {

    /**
     * Метод для получения скриншота и сохранения его в папке build\reports\tests\ScreenShots
     */
    protected void screenShotStep() {
        String screenName = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
        String className = this.getClass().getSimpleName();
        screenshot("./ScreenShots/" + className + "/" + screenName + "_Screenshot.png");
    }
}
