package Pages.android;

import Pages.pageFactory.ProductDetailPage;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

public class AndroidProductDetailPage extends ProductDetailPage {

    public AndroidProductDetailPage(AppiumDriver driver) {
        super(driver);
    }

    By productImageXpath=By.xpath("//android.view.View[@resource-id=\"image-block\"]");
    By productGalleryImgXpath=By.xpath("//android.view.ViewGroup[@resource-id=\"zoomable-view\"]");


    @Override
    public void doActions(){
        doSwipeActions();
        doActionsWithJS();
    }

    public void doSwipeActions(){
        swipe(waitForVisible(productImageXpath),SWIPE_DIRECTION.LEFT);
        swipe(waitForVisible(productImageXpath),SWIPE_DIRECTION.RIGHT);
        swipe(waitForVisible(productImageXpath),SWIPE_DIRECTION.UP);
        swipe(waitForVisible(productImageXpath),SWIPE_DIRECTION.DOWN);

    }

    public void doActionsWithJS(){
        waitAndClick(productImageXpath);
        waitForVisible(productGalleryImgXpath);
        WebElement productImageElem = driver.findElement(productGalleryImgXpath);

        ((JavascriptExecutor) driver).executeScript("mobile: doubleClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) productImageElem).getId()
        ));



    }


}
