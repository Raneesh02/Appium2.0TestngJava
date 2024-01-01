package Pages.pageFactory;

import Pages.baseclasses.BasePage;
import io.appium.java_client.AppiumDriver;

public abstract class FiltersPage extends BasePage {

    public FiltersPage(AppiumDriver driver) {
        super(driver);
    }


    public abstract void setFilter(String filterName, String filterOption);

    public abstract SearchResultsPage applyFilter();
}
