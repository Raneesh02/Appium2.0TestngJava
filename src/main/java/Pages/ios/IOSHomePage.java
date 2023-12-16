package Pages.ios;

import Pages.pageFactory.HomePage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class IOSHomePage extends HomePage {

    public IOSHomePage(AppiumDriver driver) {
        super(driver);
    }

    By searchBarId=By.id("searchTextField");
    By autoComplete=By.id("Amazon Search Autocomplete");

    public void searchForProduct(String searchKeywords){
        waitAndSendKeys(searchBarId,searchKeywords);
    }

    public boolean isAutoCompleteListDisplayed(){
        return isDisplayed(autoComplete);
    }

}
