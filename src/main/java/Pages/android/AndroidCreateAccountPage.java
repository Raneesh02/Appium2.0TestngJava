package Pages.android;

import Pages.pageFactory.CreateAccountPage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

import java.util.HashMap;

public class AndroidCreateAccountPage extends CreateAccountPage {

    public AndroidCreateAccountPage(AppiumDriver driver) {
        super(driver);
    }

    By emailPhoneTxtId=By.xpath("//android.widget.EditText[@resource-id=\"ap_email_login\"]");
    By continueBtnXpath=By.xpath("//android.widget.Button[@text=\"Continue\"]");
    By submitBtnXpath =By.xpath("//android.widget.Button[@resource-id=\"continue\"]");
    By proceedToCreateBtnXpath= By.xpath("//android.widget.Button[@text=\"Proceed to create an account\"]");
    By countrySelectorId=By.xpath("//android.view.View[@resource-id=\"auth-country-picker\"]");
    String countryOptionSelectorXpath ="//android.view.View[contains(@text,\"%s\")]";
    By phoneNumberTxtId =By.xpath("//android.widget.EditText[@resource-id=\"ap_phone_number\"]");
    By custNameTxtId=By.xpath("//android.widget.EditText[@resource-id=\"ap_customer_name\"]");
    By pswdTxtId=By.xpath("//android.widget.EditText[@resource-id=\"ap_password\"]");
    By showPasswordCheckBox=By.xpath("//android.view.View[@resource-id=\"auth-show-password-checkbox-container\"]");
    By cancelEmailSelectionId=By.id("com.google.android.gms:id/cancel");

    public void cancelEmailSelectionIfPresent(){
        if(isDisplayed(cancelEmailSelectionId)){
            waitAndClick(cancelEmailSelectionId);
        }
    }
    @Override
    public void setEmailIfPresent(String emailPhone) {
        if(isDisplayed(emailPhoneTxtId)) {
            waitAndSendKeys(emailPhoneTxtId, emailPhone);
            waitAndClick(continueBtnXpath);
        }
        if(isDisplayed(proceedToCreateBtnXpath)){
            waitAndClick(proceedToCreateBtnXpath);
        }
    }

    @Override
    public String getContinueBtnText() {
        return getText(submitBtnXpath);
    }

    public void submit(){
        waitAndClick(submitBtnXpath);
    }

    @Override
    public void fillForm(HashMap<String,String> formMap) {
        setEmailIfPresent(formMap.get("email"));
        cancelEmailSelectionIfPresent();
        waitAndSendKeys(custNameTxtId,formMap.get("name"));
        selectCountryCode(formMap.get("countryCode"));
        waitAndSendKeys(phoneNumberTxtId,formMap.get("phone"));
        waitAndSendKeys(pswdTxtId,formMap.get("password"));
        waitAndClick(this.showPasswordCheckBox);
    }

    public void selectCountryCode(String countryCode){
        waitAndClick(countrySelectorId);
        waitAndClick(By.xpath(String.format(countryOptionSelectorXpath,countryCode)));
    }

}
