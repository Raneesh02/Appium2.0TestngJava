package Pages.pageFactory;

import Pages.android.AndroidCreateAccountPage;
import Pages.baseclasses.BasePage;
import io.appium.java_client.AppiumDriver;

public abstract class ProfilePageLoggedOutPage extends BasePage {


    public ProfilePageLoggedOutPage(AppiumDriver driver) {
        super(driver);
    }

    public abstract CreateAccountPage goToCreateAccount();
}
