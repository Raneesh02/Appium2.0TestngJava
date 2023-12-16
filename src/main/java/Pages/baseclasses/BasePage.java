package Pages.baseclasses;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    AppiumDriver driver;
    public static final int SHORT_WAIT=30;
    WebDriverWait webDriverWait;

    public BasePage(AppiumDriver driver){
        this.driver=driver;
        webDriverWait=new WebDriverWait(this.driver, Duration.ofSeconds(SHORT_WAIT));
    }

    protected void waitAndClick(By locator){
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        WebElement element=driver.findElement(locator);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    protected boolean isDisplayed(By locator){
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        WebElement element=driver.findElement(locator);
        return element.isDisplayed();
    }

    protected void waitAndSendKeys(By locator,String keysToSend){
        WebElement element=waitForVisible(locator);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
        element.sendKeys(keysToSend);
    }

    protected WebElement waitForVisible(By locator){
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator);
    }


}
