package DriverManagement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseDriver {
    AndroidDriver driver;
    AppiumDriverLocalService appiumService;

    public AndroidDriver initAndroidDriver() throws MalformedURLException {
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), getDesiredCapabilities());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }

    private DesiredCapabilities getDesiredCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium:platformVersion", "14");
        capabilities.setCapability("appium:automationName","UIAutomator2");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("app",System.getProperty("user.dir")+"/src/main/resources/App/amazon-shopping-26-18-4-100.apk");
        capabilities.setCapability("newCommandTimeout",120);
        return capabilities;
    }

    public void initAppiumService(){
        appiumService = AppiumDriverLocalService.buildService(
                new AppiumServiceBuilder()
//                        .usingDriverExecutable(new File("/usr/local/bin/node")) //If Node not added in PATH
//                        .withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js")) //if Appium not added in PATH
                        .withLogFile(new File(System.getProperty("user.dir")+"/target/appiumServiceLogs.txt"))  // Change to the absolute path
                        .withArgument(GeneralServerFlag.LOCAL_TIMEZONE));

        appiumService.start();
    }

    public void quitDriver(){
        driver.quit();
        System.out.println("Driver has quit");

    }

    public void tearDownAppiumService(){
        appiumService.stop();
        System.out.println("Appium Service has quit");
    }

}
