package Pages.android;

import Pages.pageFactory.HomePage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class AndroidHomePage extends HomePage {

    public AndroidHomePage(AppiumDriver driver) {
        super(driver);
        skipPopupsIfAny();
    }

    By allowNotificationBtnId= By.id("com.android.permissioncontroller:id/permission_allow_button");
    By skipSignInBtnId= By.id("com.amazon.mShop.android.shopping:id/skip_sign_in_button");
    By searchHintBarId= By.id("com.amazon.mShop.android.shopping:id/chrome_search_hint_view");
    By searchBarTxtId= By.id("com.amazon.mShop.android.shopping:id/rs_search_src_text");
    By autocompleteListId= By.id("com.amazon.mShop.android.shopping:id/search_suggestions_frame_layout");


    public void allowNotifications(){
        if(isDisplayed(allowNotificationBtnId)) {
            waitAndClick(allowNotificationBtnId);
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

}
