package tests;

import DriverManagement.BaseDriver;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;

public class BaseTest extends BaseDriver {
    AndroidDriver driver;

    @BeforeSuite
    public void initSuite(){
        initAppiumService();
    }

    @BeforeMethod
    public void initialize() throws MalformedURLException {
        driver=initAndroidDriver();
    }


    @AfterMethod
    public void tearDown(){
        quitDriver();
    }

    @AfterSuite
    public void tearDownSuite(){
        tearDownAppiumService();
    }

}
