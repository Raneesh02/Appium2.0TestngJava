package Pages.pageFactory;

import Pages.android.AndroidPageFactory;
import Pages.ios.IOSPageFactory;
import io.appium.java_client.AppiumDriver;

public abstract class PageFactory {

    AppiumDriver driver;

    public PageFactory(AppiumDriver driver){
        this.driver=driver;
    }

    public static PageFactory getPageFactory(AppiumDriver driver, String platform){
        return switch (platform) {
            case "android" -> new AndroidPageFactory(driver);
            case "ios" -> new IOSPageFactory(driver);
            default -> throw new IllegalArgumentException("Platform " + platform + "is not correct value");
        };
    }

    public  abstract HomePage getHomePage();

}
