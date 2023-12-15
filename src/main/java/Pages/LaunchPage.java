package Pages;


import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class LaunchPage extends BasePage {

    public LaunchPage(AndroidDriver driver) {
        super(driver);
    }


    By allowNotificationBtnId= By.id("com.android.permissioncontroller:id/permission_allow_button");
    By skipSignInBtnId= By.id("com.amazon.mShop.android.shopping:id/skip_sign_in_button");

    public void allowNotifications(){
        waitAndClick(allowNotificationBtnId);
    }

    public void skipSignIn(){
        waitAndClick(skipSignInBtnId);
    }



}
