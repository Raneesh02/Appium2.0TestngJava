import DriverManagement.BaseDriver;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;

public class BaseTest extends BaseDriver {
    AndroidDriver driver;

    @BeforeMethod
    public void initialize() throws MalformedURLException {
        driver=initAndroidDriver();
    }


    @AfterMethod
    public void tearDown(){
        quitDriver();
    }

}
