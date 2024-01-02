package Pages.ios;

import Pages.pageFactory.CreateAccountPage;
import Pages.pageFactory.ProfileLoggedOutPage;
import io.appium.java_client.AppiumDriver;

public class IOSProfileLoggedOutPage extends ProfileLoggedOutPage {

    public IOSProfileLoggedOutPage(AppiumDriver driver) {
        super(driver);
    }

    @Override
    public CreateAccountPage goToCreateAccount() {
        waitAndClick(createAccountBtnId);
        return new IOSCreateAccountPage(driver);
    }




}
