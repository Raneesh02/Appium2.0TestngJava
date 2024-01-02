package Pages.android;

import Pages.pageFactory.ProfileLoggedOutPage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class AndroidProfileLoggedOutPage extends ProfileLoggedOutPage {

    public AndroidProfileLoggedOutPage(AppiumDriver driver) {
        super(driver);
    }



    @Override
    public AndroidCreateAccountPage goToCreateAccount(){
        waitAndClick(createAccountBtnId);
        return new AndroidCreateAccountPage(driver);
    }


}
