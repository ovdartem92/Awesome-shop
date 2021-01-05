package awesome.shop.tests.cucumber.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import ru.awesome.shop.ta.product.pages.HomePage;
import ru.awesome.shop.ta.product.pages.SearchResultPage;
import ru.awesome.shop.ta.product.pages.fragments.SearchFragment;
import ru.awesome.shop.ta.product.pages.fragments.SearchResultFragment;

import java.util.ArrayList;
import java.util.List;

public class SearchSteps {

    @Given("I have opened home page")
    public void iHaveOpenedHomePage() {
        HomePage homePage = new HomePage();
        homePage.open();
    }

    @When("I perform basic search of {string} product")
    public void iPerformBasicSearchOfProduct(String searchCriteria) {
        SearchFragment searchFragment = new SearchFragment();
        searchFragment.typeSearchQuery(searchCriteria);
        searchFragment.clickSearchButton();
    }

    @When("I type {string} search query")
    public void iTypeSearchQuery(String searchCriteria) {
        SearchFragment searchFragment = new SearchFragment();
        searchFragment.typeSearchQuery(searchCriteria);
    }

    @And("I press Enter")
    public void iPressEnter() {
        SearchFragment searchFragment = new SearchFragment();
        searchFragment.performSearchByPressingEnter();
    }

    @And("I select “iMac” category")
    public void iSelectIMacCategory() {
        SearchResultPage searchResultPage = new SearchResultPage();
        searchResultPage.setIMacCategory();
    }

    @And("I enable search in product descriptions")
    public void iEnableSearchInProductDescriptions() {
        SearchResultPage searchResultPage = new SearchResultPage();
        searchResultPage.setDescriptionCheckbox(true);
    }

    @And("I click advanced search button")
    public void iClickAdvancedSearchButton() {
        SearchResultPage searchResultPage = new SearchResultPage();
        searchResultPage.clickSearchButtonOnSearchResultPage();
    }

    @Then("{string} product should be found")
    public void productShouldBeFound(String expectedResultProduct) {
        SearchResultPage searchResultPage = new SearchResultPage();
        List<SearchResultFragment> searchResults = searchResultPage.getAllSearchResults();
        List<String> productNames = new ArrayList<>();
        for (SearchResultFragment searchResult : searchResults) {
            productNames.add(searchResult.getName());
        }
        Assert.assertEquals(productNames.get(0), expectedResultProduct,
                expectedResultProduct + " wasn't found in search result.");
    }

    @Then("I should see incorrect search message {string}")
    public void iShouldSeeIncorrectSearchMessage(String expectedResultMessage) {
        SearchResultPage searchResultPage = new SearchResultPage();
        Assert.assertEquals(searchResultPage.getIncorrectSearchCriteriaMessage(), expectedResultMessage,
                expectedResultMessage + " isn't displayed");
    }
}
