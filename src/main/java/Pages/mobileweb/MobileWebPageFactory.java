package Pages.mobileweb;

import Pages.pageFactory.HomePage;
import Pages.pageFactory.PageFactory;
import io.appium.java_client.AppiumDriver;

public class MobileWebPageFactory extends PageFactory {
    AppiumDriver driver;
    public MobileWebPageFactory(AppiumDriver driver) {
        super(driver);
        this.driver=driver;
    }

    @Override
    public HomePage getHomePage() {
        return new MobileWebHomePage(driver);
    }
}
