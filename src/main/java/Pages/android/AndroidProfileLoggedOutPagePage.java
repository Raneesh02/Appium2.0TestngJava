package Pages.android;

import Pages.pageFactory.ProfilePageLoggedOutPage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class AndroidProfileLoggedOutPagePage extends ProfilePageLoggedOutPage {

    public AndroidProfileLoggedOutPagePage(AppiumDriver driver) {
        super(driver);
    }

    By createAccountBtnId= AppiumBy.accessibilityId("cab");


    @Override
    public AndroidCreateAccountPage goToCreateAccount(){
        waitAndClick(createAccountBtnId);
        return new AndroidCreateAccountPage(driver);
    }


}
