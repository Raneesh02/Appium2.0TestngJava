package DriverManagement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

public class BaseDriver {
    AppiumDriver driver;
    AppiumDriverLocalService appiumService;
    static String APPIUM_SERVER="http://127.0.0.1:4723";
    static String ANDROID="android";
    static String IOS="ios";
    protected static Properties prop = new Properties();

    public AppiumDriver initDriver() throws Exception {
        loadPropertyFile();

        if(prop.get("platform").equals(ANDROID)){
            driver = new AndroidDriver(new URL(APPIUM_SERVER), getDesiredCapabilities(ANDROID));
        }
        else if(prop.get("platform").equals(IOS)){
            driver = new IOSDriver(new URL(APPIUM_SERVER), getDesiredCapabilities(IOS));
        }
        else{
            throw new IllegalArgumentException("Platform name "+ prop.get("platform")+" is not valid");
        }
        return driver;
    }

    public void loadPropertyFile() throws IOException {
        InputStream input = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/application.properties");
        //Load properties file
        prop.load(input);
    }

    public Properties getApplicationProperties(){
        return prop;
    }

    private DesiredCapabilities getDesiredCapabilities(String platform) {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformVersion", prop.getProperty("platformVersion"));

        if(platform.equals(ANDROID)) {
            capabilities.setCapability("platformVersion", "14");
            capabilities.setCapability("automationName", "UIAutomator2");
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("app", System.getProperty("user.dir") + "/src/main/resources/App/amazon-shopping-26-18-4-100.apk");
        }
        else if(platform.equals(IOS)){
            capabilities.setCapability("automationName", "xcuitest");
            capabilities.setCapability("platformName", "iOS");
            capabilities.setCapability("udid","00008030-000128680A04C02E");
            capabilities.setCapability("bundleId","com.amazon.Amazon");
        }
        else{
            throw new IllegalArgumentException("Platform "+platform+" is not a valid value");
        }

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
