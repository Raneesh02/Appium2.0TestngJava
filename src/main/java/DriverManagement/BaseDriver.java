package DriverManagement;

import Pages.mobileweb.ChromeElements;
import com.google.common.collect.ImmutableMap;
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
    final static String ANDROID="android";
    final static String ANDROID_CHROME="android_chrome";
    final static String IOS="ios";
    protected static Properties prop = new Properties();

    public AppiumDriver initDriver() throws Exception {
        loadPropertyFile();
        String platform= prop.getProperty("platform");
        DesiredCapabilities desiredCapabilities = getDesiredCapabilities(platform);
        switch(platform){
            case ANDROID:driver=new AndroidDriver(new URL(APPIUM_SERVER),desiredCapabilities );break;
            case ANDROID_CHROME:
                driver= new AndroidDriver(new URL(APPIUM_SERVER),desiredCapabilities );
                initAndroidChrome(driver);
                break;
            case IOS :
                driver=new IOSDriver(new URL(APPIUM_SERVER), desiredCapabilities);
            default: throw new IllegalArgumentException("Unexpected value: " + platform);
        };

        return driver;
    }

    private void initAndroidChrome(AppiumDriver driver){
        ChromeElements chromeElements=new ChromeElements(driver);
        chromeElements.handleChromeStartup();
        driver.get(prop.getProperty("weburl"));
        ((AndroidDriver) driver).context("WEBVIEW_chrome");
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

        switch (platform){
            case ANDROID:
                capabilities.setCapability("automationName", "UIAutomator2");
                capabilities.setCapability("platformName", "Android");
                //Use below capabilities when app is already installed
                capabilities.setCapability("appPackage","in.amazon.mShop.android.shopping");
                capabilities.setCapability("appActivity","com.amazon.mShop.home.HomeActivity");
                //use below in case app needs to be installed
                //capabilities.setCapability("app", System.getProperty("user.dir") + "/src/main/resources/App/amazon-shopping-26-18-4-100.apk");
                break;
            case IOS:
                capabilities.setCapability("automationName", "xcuitest");
                capabilities.setCapability("platformName", "iOS");
                capabilities.setCapability("udid","00008030-000128680A04C02E");
                //for amazon app
                //capabilities.setCapability("bundleId","com.amazon.Amazon");
                //for settings app
                capabilities.setCapability("bundleId","com.apple.Preferences");
            case ANDROID_CHROME:
                capabilities.setCapability("automationName","UIAutomator2");
                capabilities.setCapability("platformName","Android");
                //capability for chrome
                capabilities.setCapability("appPackage","com.android.chrome");
                capabilities.setCapability("appActivity","com.google.android.apps.chrome.Main");
                //ENable below to turn off w3c standards to use locator strategy other than xpath and css
//                capabilities.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));
            break;
            default: throw new IllegalArgumentException("Wrong Platform Name"+platform);
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
