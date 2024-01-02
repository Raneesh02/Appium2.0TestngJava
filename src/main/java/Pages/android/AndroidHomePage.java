package Pages.android;

import Pages.pageFactory.HomePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AndroidHomePage extends HomePage {

    public AndroidHomePage(AppiumDriver driver) {
        super(driver);
        skipPopupsIfAny();
    }

    By allowNotificationBtnId= By.id("com.android.permissioncontroller:id/permission_allow_button");
    By skipSignInBtnId= By.id("in.amazon.mShop.android.shopping:id/skip_sign_in_button");
    By searchHintBarId= By.id("in.amazon.mShop.android.shopping:id/chrome_search_hint_view");
    By searchBarTxtId= By.id("in.amazon.mShop.android.shopping:id/rs_search_src_text");
    By autocompleteListId= By.id("in.amazon.mShop.android.shopping:id/search_suggestions_frame_layout");
    By bottomNavBarProfileId=By.xpath("(//android.widget.ImageView[@resource-id=\"in.amazon.mShop.android.shopping:id/bottom_tab_button_icon\"])[2]");

    By englishLangOptionId = AppiumBy.accessibilityId("Select English");
    By continueBtnId=By.id("in.amazon.mShop.android.shopping:id/continue_button");
    By buttonClassName=By.className("android.widget.Button");


    public void allowNotifications(){
        if(isDisplayed(allowNotificationBtnId)) {
            waitAndClick(allowNotificationBtnId);
        }
    }

    public void selectLanguage(){
        if(isDisplayed(englishLangOptionId)) {
            waitAndClick(englishLangOptionId);
            waitAndClick(continueBtnId);
        }

    }

    public void skipSignIn(){
        if(isDisplayed(skipSignInBtnId)) {
            waitAndClick(skipSignInBtnId);
        }
    }

    @Override
    public void skipPopupsIfAny(){
        allowNotifications();
        selectLanguage();
        skipSignIn();
    }

    @Override
    public void searchForProduct(String keywordToSearch) {
        waitAndClick(searchHintBarId);
        waitAndSendKeys(searchBarTxtId,keywordToSearch);
    }

    @Override
    public boolean isAutoCompleteListDisplayed() {
        return isDisplayed(autocompleteListId);
    }

    @Override
    public AndroidProfileLoggedOutPage goToUserProfile(){
        waitAndClick(bottomNavBarProfileId);
        return new AndroidProfileLoggedOutPage(this.driver);
    }

    @Override
    public AndroidSearchResultsPage selectAutoCompleteOption(int index){
        WebElement searchListElem = waitForVisible(autocompleteListId);
        List<WebElement> autoCompleteElements = searchListElem.findElements(buttonClassName);
        autoCompleteElements.get(2*(index-1)).click();
        ((AndroidDriver)driver).pressKey(new KeyEvent(AndroidKey.ENTER));
        return new AndroidSearchResultsPage(driver);
    }


}
