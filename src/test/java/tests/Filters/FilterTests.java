package tests.Filters;

import Pages.pageFactory.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;


public class FilterTests extends BaseTest {

    @Test
    public void testFilterApply(){
        HomePage homePage = pageFactory.getHomePage();
        homePage.searchForProduct("neck band");
        Assert.assertTrue(homePage.isAutoCompleteListDisplayed(),"Autocomplete list is not displayed");
        SearchResultsPage searchResultsPage = homePage.selectAutoCompleteOption(1);

        FiltersPage filtersPage = searchResultsPage.goToFilters();
        filtersPage.setFilter("Headphone Style","In Ear");

        SearchResultsPage searchResultsPage1 = filtersPage.applyFilter();
        Assert.assertTrue(searchResultsPage1.checkFilterApplied("In Ear"),"Filter is not applied");

    }

}
