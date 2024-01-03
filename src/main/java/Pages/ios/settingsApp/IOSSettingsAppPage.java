package Pages.ios.settingsApp;

import Pages.baseclasses.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.HashMap;

public class IOSSettingsAppPage extends BasePage {
    public IOSSettingsAppPage(AppiumDriver driver) {
        super(driver);
    }

    By leftNavigationPane= By.xpath("//XCUIElementTypeNavigationBar[@name=\"Settings\"]/following-sibling::XCUIElementTypeOther");
    By searchId= AppiumBy.accessibilityId("Search");

    public void doActions(){
        doSwipeActions();
        doActionsWithJS();
    }
    public void doSwipeActions(){
        swipe(waitForVisible(leftNavigationPane),SWIPE_DIRECTION.UP);
        swipe(waitForVisible(leftNavigationPane),SWIPE_DIRECTION.DOWN);
        swipe(waitForVisible(leftNavigationPane),SWIPE_DIRECTION.DOWN);
    }

    public void doActionsWithJS(){
        HashMap<String, String> scrollObject = new HashMap<String, String>();
        scrollObject.put("element", ((RemoteWebElement)waitForVisible(searchId)).getId());
        scrollObject.put("duration", "3.0");
        driver.executeScript("mobile:touchAndHold",scrollObject);

    }

}
