package Pages.android;

import Pages.pageFactory.FiltersPage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class AndroidFiltersPage extends FiltersPage {

    public AndroidFiltersPage(AppiumDriver driver) {
        super(driver);
    }

    By applyFilterXpath=By.xpath("//android.widget.TextView[contains(@text,'Show')]");
    String filterOptionXpath= "//android.widget.TextView[@text=\"%s\"]";
    String filtersListUISel="new UiScrollable(new UiSelector().resourceId(\"sf-filters-vtabs\").childSelector(new UiSelector(). className(\"android.widget.TabWidget\")))" +
            ".scrollIntoView(new UiSelector().text(\"%s\"))";


    @Override
    public void setFilter(String filterName, String filterOption){
        String filterOptionSelector=String.format(filtersListUISel,filterName);
        waitAndClick(AppiumBy.androidUIAutomator(filterOptionSelector));
        waitAndClick(AppiumBy.xpath(String.format(filterOptionXpath,filterOption)));
    }

    @Override
    public AndroidSearchResultsPage applyFilter(){
        waitAndClick(applyFilterXpath);
        return new AndroidSearchResultsPage(driver);
    }

}
