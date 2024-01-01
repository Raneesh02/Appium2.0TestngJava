package Pages.pageFactory;

import Pages.baseclasses.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public abstract class ProductDetailPage extends BasePage {

    public ProductDetailPage(AppiumDriver driver) {
        super(driver);
    }

    public abstract void doActions();

}
