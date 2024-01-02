package Pages.pageFactory;

import Pages.baseclasses.BasePage;
import io.appium.java_client.AppiumDriver;

public abstract class HomePage extends BasePage {


    public HomePage(AppiumDriver driver) {
        super(driver);
    }

    public void skipPopupsIfAny(){}

    public abstract void searchForProduct(String keywordToSearch);

    public abstract boolean isAutoCompleteListDisplayed();

    public abstract ProfileLoggedOutPage goToUserProfile();

    public abstract SearchResultsPage selectAutoCompleteOption(int index);
}
