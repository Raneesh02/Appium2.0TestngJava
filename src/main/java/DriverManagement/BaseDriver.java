package DriverManagement;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseDriver {
    AndroidDriver driver;

    public AndroidDriver initAndroidDriver() throws MalformedURLException {
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), getDesiredCapabilities());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }

    private static DesiredCapabilities getDesiredCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium:platformVersion", "14");
        capabilities.setCapability("appium:automationName","UIAutomator2");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("noReset","true");
        capabilities.setCapability("app",System.getProperty("user.dir")+"/src/main/resources/App/amazon-shopping-26-18-4-100.apk");
        capabilities.setCapability("newCommandTimeout",120);
        return capabilities;
    }

    public void quitDriver(){
        driver.quit();
    }

}
