package Pages.pageFactory;

import Pages.baseclasses.BasePage;
import io.appium.java_client.AppiumDriver;

import java.util.HashMap;

public abstract class CreateAccountPage extends BasePage {

    public CreateAccountPage(AppiumDriver driver) {
        super(driver);
    }

    public abstract void setEmailIfPresent(String emailPhone);

    public abstract String getContinueBtnText();

    public abstract void fillForm(HashMap<String, String> formMap);
}
