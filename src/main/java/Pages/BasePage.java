package Pages;

import DriverManagement.BaseDriver;
import io.appium.java_client.android.AndroidDriver;

public class BasePage {
    AndroidDriver driver;

    public BasePage(AndroidDriver driver){
        this.driver=driver;
    }
}
