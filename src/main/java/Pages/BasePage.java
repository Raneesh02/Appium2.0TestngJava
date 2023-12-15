package Pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    AndroidDriver driver;
    public static final int SHORT_WAIT=30;
    WebDriverWait webDriverWait;

    public BasePage(AndroidDriver driver){
        this.driver=driver;
        webDriverWait=new WebDriverWait(this.driver, Duration.ofSeconds(SHORT_WAIT));
    }

    public void waitAndClick(By locator){
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        WebElement element=driver.findElement(locator);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public boolean isDisplayed(By locator){
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        WebElement element=driver.findElement(locator);
        return element.isDisplayed();
    }


}
