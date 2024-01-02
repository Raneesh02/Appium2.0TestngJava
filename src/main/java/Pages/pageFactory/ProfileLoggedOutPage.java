package Pages.pageFactory;

import Pages.baseclasses.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public abstract class ProfileLoggedOutPage extends BasePage {


    protected By createAccountBtnId= AppiumBy.accessibilityId("cab");

    public ProfileLoggedOutPage(AppiumDriver driver) {
        super(driver);
    }

    public abstract CreateAccountPage goToCreateAccount();
}
