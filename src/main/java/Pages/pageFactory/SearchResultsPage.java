package Pages.pageFactory;

import Pages.baseclasses.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public abstract class SearchResultsPage extends BasePage {

    public SearchResultsPage(AppiumDriver driver) {
        super(driver);
    }

    public boolean checkFilterApplied(String filterOption){
        return isDisplayed(AppiumBy.accessibilityId(filterOption));
    }


    public abstract FiltersPage goToFilters();

    public abstract ProductDetailPage goToProductDetail(String search);

    public abstract void doActions();
}
