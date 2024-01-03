package tests.ios_gestures;

import Pages.ios.settingsApp.IOSSettingsAppPage;
import org.testng.annotations.Test;
import tests.BaseTest;

public class IOSGesturesTests extends BaseTest {

    @Test
    public void testSwipeOnSettings(){
        IOSSettingsAppPage iosSettingsAppPage=new IOSSettingsAppPage(driver);
        iosSettingsAppPage.doActions();
    }
}
