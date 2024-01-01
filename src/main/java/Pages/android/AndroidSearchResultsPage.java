package Pages.android;

import Pages.pageFactory.SearchResultsPage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.*;


import static java.time.Duration.ofMillis;

public class AndroidSearchResultsPage extends SearchResultsPage {

    public AndroidSearchResultsPage(AppiumDriver driver) {
        super(driver);
    }

    By filtersXpath=By.xpath("//android.widget.ToggleButton[@resource-id=\"s-all-filters\"]");
    String searchResultXpath="//android.view.View[contains(@text,'%s')]";

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










}
