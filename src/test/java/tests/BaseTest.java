package tests;

import DriverManagement.BaseDriver;
import Pages.pageFactory.PageFactory;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import java.util.Properties;

public class BaseTest extends BaseDriver {
    protected AppiumDriver driver;
    protected static Properties appProperties;
    protected static PageFactory pageFactory;


    @BeforeSuite
    public void initSuite() {
        appProperties= getApplicationProperties();
        initAppiumService();
    }



    @BeforeMethod
    public void initialize() throws Exception {
        driver= initDriver();
        pageFactory=PageFactory.getPageFactory(driver,prop.getProperty("platform"));

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
