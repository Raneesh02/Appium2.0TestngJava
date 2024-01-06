package tests;

import DriverManagement.BaseDriver;
import Pages.pageFactory.PageFactory;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
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
    public void tearDown(ITestResult testResult) throws IOException {
        attachScreenshotOnFailure(testResult);
        quitDriver();
    }

    @AfterSuite
    public void tearDownSuite(){
        tearDownAppiumService();
    }

    private void attachScreenshotOnFailure(ITestResult testResult) throws IOException {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            File outputFile=new File("target/failureScreenshots/" + testResult.getName() + ".jpg");
            FileUtils.copyFile(scrFile, outputFile);
            Allure.addAttachment(testResult.getTestName(), Files.newInputStream(outputFile.toPath()));
        }

    }

}
