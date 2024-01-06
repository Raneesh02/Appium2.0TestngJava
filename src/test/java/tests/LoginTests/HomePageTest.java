package tests.LoginTests;

import Pages.pageFactory.HomePage;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class HomePageTest extends BaseTest {

    @Test
    @Description("this is the test for search autocomplete")
    public void validateSearchAutoComplete()  {
        System.out.println("ValidateHomePageTitleAndLogo Test case started");
        HomePage homePage = pageFactory.getHomePage();
        homePage.searchForProduct("neck band");
        Assert.assertTrue(homePage.isAutoCompleteListDisplayed(),"Autocomplete list is not displayed");
    }

    @Test
    public void validateHomePageUserNamePass(){
        System.out.println("validateHomePageUserNamePass Test case started");
        Assert.assertTrue(false,"failure in test case");
    }

}
