package Pages.baseclasses;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;

import static java.time.Duration.ofMillis;

public class BasePage {
    protected AppiumDriver driver;
    public static final int SHORT_WAIT=10;
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
        try {
            return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
        }catch (TimeoutException e){
            System.out.println("Cannot find element with location: "+locator);
        }
        System.out.println("element with locator : "+locator+" is not displayed");
        return false;
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

    protected String getText(By locator){
        waitForVisible(locator);
        return driver.findElement(locator).getText();
    }


    public void swipe(WebElement element, SWIPE_DIRECTION direction){
        Rectangle elemRect = element.getRect();
        Point midPoint=new Point(elemRect.x+(elemRect.width/2),elemRect.y+(elemRect.height/2));
        PointerInput finger=new PointerInput(PointerInput.Kind.TOUCH,"finger");
        Sequence swipe=new Sequence(finger,1);
        Point endPoint=new Point(midPoint.x,midPoint.y);

        switch(direction){
            case LEFT: endPoint.x=elemRect.x;break;
            case RIGHT: endPoint.x=elemRect.x+elemRect.width;break;
            case UP: endPoint.y=elemRect.y;break;
            case DOWN: endPoint.y=elemRect.y+elemRect.height;break;
            default:throw new IllegalArgumentException("Direction "+direction+" is not correct");
        }

        swipe.addAction(finger.createPointerMove(Duration.ZERO,PointerInput.Origin.viewport(),midPoint));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(ofMillis(500),PointerInput.Origin.viewport(),endPoint));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(swipe));

    }

    public enum SWIPE_DIRECTION{
        LEFT,RIGHT,UP,DOWN
    }

}
