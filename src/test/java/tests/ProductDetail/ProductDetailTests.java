package tests.ProductDetail;

import Pages.pageFactory.HomePage;
import Pages.pageFactory.SearchResultsPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class ProductDetailTests  extends BaseTest {

    @Test
    public void checkGesturesProductDetailPage(){
        HomePage homePage = pageFactory.getHomePage();
        homePage.searchForProduct("neck band");
        Assert.assertTrue(homePage.isAutoCompleteListDisplayed(),"Autocomplete list is not displayed");
        SearchResultsPage searchResultsPage = homePage.selectAutoCompleteOption(1);
        searchResultsPage.goToProductDetail("Neckband");
        searchResultsPage.doActions();

    }
}
