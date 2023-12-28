package Pages.android;

import Pages.pageFactory.SearchResultsPage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class AndroidSearchResultsPage extends SearchResultsPage {

    public AndroidSearchResultsPage(AppiumDriver driver) {
        super(driver);
    }

    By filtersXpath=By.xpath("//android.widget.ToggleButton[@resource-id=\"s-all-filters\"]");

    @Override
    public AndroidFiltersPage goToFilters(){
        waitAndClick(filtersXpath);
        return new AndroidFiltersPage(driver);
    }



}
