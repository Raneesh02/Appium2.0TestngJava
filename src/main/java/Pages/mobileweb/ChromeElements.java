package Pages.mobileweb;

import Pages.baseclasses.BasePage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class ChromeElements extends BasePage {
    public ChromeElements(AppiumDriver driver) {
        super(driver);
    }

    By useWithoutAcntBtnId = By.id("com.android.chrome:id/signin_fre_dismiss_button");
    By noThanksBtnId=By.id("com.android.chrome:id/negative_button");

    public void handleChromeStartup(){
        if(isDisplayed(useWithoutAcntBtnId)) {
            waitAndClick(useWithoutAcntBtnId);
        }
        if(isDisplayed(noThanksBtnId)) {
            waitAndClick(noThanksBtnId);
        }
    }

}
