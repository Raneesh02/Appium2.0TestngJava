package Pages.mobileweb;

import Pages.pageFactory.HomePage;
import Pages.pageFactory.ProfileLoggedOutPage;
import Pages.pageFactory.SearchResultsPage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class MobileWebHomePage extends HomePage {
    public MobileWebHomePage(AppiumDriver driver) {
        super(driver);
    }

    By searchBarId =By.cssSelector("input[id='nav-search-keywords']");
    By autocompleteList=By.cssSelector("div[class='autocomplete-results-container']");

    @Override
    public void searchForProduct(String keywordToSearch) {
        waitAndSendKeys(searchBarId,keywordToSearch);
    }

    @Override
    public boolean isAutoCompleteListDisplayed() {
        return isDisplayed(autocompleteList);
    }

    @Override
    public ProfileLoggedOutPage goToUserProfile() {
        return null;
    }

    @Override
    public SearchResultsPage selectAutoCompleteOption(int index) {
        return null;
    }
}
