package tests.LoginTests;

import Pages.LaunchPage;
import org.testng.annotations.Test;
import tests.BaseTest;

public class HomePageTest extends BaseTest {

    @Test
    public void validateHomePageTitleAndLogo() throws InterruptedException {
        System.out.println("ValidateHomePageTitleAndLogo Test case started");
        LaunchPage launchPage=new LaunchPage(this.driver);
        launchPage.allowNotifications();
        launchPage.skipSignIn();
    }

    @Test
    public void validateHomePageUserNamePass(){
        System.out.println("validateHomePageUserNamePass Test case started");
    }

}
