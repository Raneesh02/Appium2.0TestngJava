package Pages.ios;

import Pages.pageFactory.PageFactory;
import io.appium.java_client.AppiumDriver;

public class IOSPageFactory extends PageFactory {
    AppiumDriver driver;

    public IOSPageFactory(AppiumDriver driver) {
        super(driver);
        this.driver=driver;
    }

    @Override
    public IOSHomePage getHomePage() {
    return  new IOSHomePage(driver);
    }
}
