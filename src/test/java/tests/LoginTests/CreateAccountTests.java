package tests.LoginTests;

import Pages.pageFactory.CreateAccountPage;
import Pages.pageFactory.HomePage;
import Pages.pageFactory.ProfileLoggedOutPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

import java.util.HashMap;

public class CreateAccountTests extends BaseTest {

    @Test
    public void testRegisterUserForm(){
        System.out.println("testRegisterUserForm Test case started");
        HomePage homePage = pageFactory.getHomePage();
        ProfileLoggedOutPage profileLoggedOutPage = homePage.goToUserProfile();
        CreateAccountPage createAccountPage= profileLoggedOutPage.goToCreateAccount();

        HashMap<String,String> formMap=new HashMap<>();
        formMap.put("email","123newemail12@gmail.com");
        formMap.put("countryCode","+62");
        formMap.put("phone","7499999999");
        formMap.put("name","Raaj");
        formMap.put("password","R4aj@pas");

        createAccountPage.fillForm(formMap);
        Assert.assertEquals(createAccountPage.getContinueBtnText(),"Verify mobile number");

    }

}
