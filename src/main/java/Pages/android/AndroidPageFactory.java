package Pages.android;

import Pages.pageFactory.PageFactory;
import io.appium.java_client.AppiumDriver;

public class AndroidPageFactory extends PageFactory {
    AppiumDriver driver;

    public AndroidPageFactory(AppiumDriver driver) {
        super(driver);
        this.driver=driver;
    }

    @Override
    public AndroidHomePage getHomePage() {
        return new AndroidHomePage(driver);
    }
}
