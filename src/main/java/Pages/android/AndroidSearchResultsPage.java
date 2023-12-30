package Pages.android;

import Pages.pageFactory.SearchResultsPage;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebElement;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static java.time.Duration.ofMillis;

public class AndroidSearchResultsPage extends SearchResultsPage {

    public AndroidSearchResultsPage(AppiumDriver driver) {
        super(driver);
    }

    By filtersXpath=By.xpath("//android.widget.ToggleButton[@resource-id=\"s-all-filters\"]");
    String searchResultXpath="//android.view.View[contains(@text,'%s')]";
    By productImageXpath=By.xpath("//android.view.View[@resource-id=\"image-block\"]");
    By productGalleryImgXpath=By.xpath("//android.view.ViewGroup[@resource-id=\"zoomable-view\"]");

    @Override
    public AndroidFiltersPage goToFilters(){
        waitAndClick(filtersXpath);
        return new AndroidFiltersPage(driver);
    }


    @Override
    public AndroidProductDetailPage goToProductDetail(String search){
        By searchResultsXpath = By.xpath(String.format(searchResultXpath, search));
        waitAndClick(searchResultsXpath);
        return new AndroidProductDetailPage(driver);
    }

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
