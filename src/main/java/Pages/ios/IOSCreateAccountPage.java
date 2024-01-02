package Pages.ios;

import Pages.pageFactory.CreateAccountPage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

import java.util.HashMap;

public class IOSCreateAccountPage extends CreateAccountPage {

    By emailIosPred= AppiumBy.iOSNsPredicateString("name == 'Enter your mobile number or email'");
    By continueBtnId=AppiumBy.accessibilityId("Continue");
    By proceedBtnIosClassChain=AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == \"Proceed to create an account\"`]");
    By countryDropDownIosPred=AppiumBy.iOSNsPredicateString("value contains '+'");
    String countryOptionIosPred="name contains '%s'";
    By phoneNumberTxtId=AppiumBy.accessibilityId("Mobile number");
    By custNameTxtId=By.xpath("//XCUIElementTypeOther[@name=\"First and last name\"]/following-sibling::XCUIElementTypeTextField");
    By pswdTxtId=AppiumBy.accessibilityId("Password");
    By showPasswordCheckBox=By.xpath("//XCUIElementTypeStaticText[@name=\"Show password\"]/preceding-sibling::XCUIElementTypeSwitch");
    By submitBtnId=AppiumBy.accessibilityId("Verify mobile number");

    public IOSCreateAccountPage(AppiumDriver driver) {
        super(driver);
    }

    @Override
    public void setEmailIfPresent(String emailPhone) {
        if(isDisplayed(emailIosPred)){
            waitAndClick(emailIosPred);
            waitAndSendKeys(emailIosPred,emailPhone);
            waitAndClick(continueBtnId);
        }
        if(isDisplayed(proceedBtnIosClassChain)){
            waitAndClick(proceedBtnIosClassChain);
        }
    }

    public void selectCountryCode(String countryCode){
        waitAndClick(countryDropDownIosPred);
        waitAndClick(AppiumBy.iOSNsPredicateString(String.format(countryOptionIosPred,countryCode)));
    }

    @Override
    public String getContinueBtnText() {
        return getText(submitBtnId);
    }

    @Override
    public void fillForm(HashMap<String, String> formMap) {
        setEmailIfPresent(formMap.get("email"));
        waitAndSendKeys(custNameTxtId,formMap.get("name"));
        selectCountryCode(formMap.get("countryCode"));
        waitAndSendKeys(phoneNumberTxtId,formMap.get("phone"));
        waitAndSendKeys(pswdTxtId,formMap.get("password"));
        waitAndClick(this.showPasswordCheckBox);
    }
}
