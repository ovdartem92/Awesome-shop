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

    @Given("home page is opened")
    public void openHomePage() {
        HomePage homePage = new HomePage();
        homePage.open();
    }

    @When("enter {string} data to search")
    public void enterDataToSearch(String searchCriteria) {
        SearchFragment searchFragment = new SearchFragment();
        searchFragment.typeSearchQuery(searchCriteria);
        searchFragment.clickSearchButton();
    }

    @When("enter {string} without click to search")
    public void enterWithoutClickToSearch(String searchCriteria) {
        SearchFragment searchFragment = new SearchFragment();
        searchFragment.typeSearchQuery(searchCriteria);
    }

    @And("set description checkbox")
    public void setDescriptionCheckbox() {
        SearchResultPage searchResultPage = new SearchResultPage();
        searchResultPage.setDescriptionCheckbox(true);
        searchResultPage.clickSearchButton();
    }

    @And("set iMac category")
    public void setIMacCategory() {
        SearchResultPage searchResultPage = new SearchResultPage();
        searchResultPage.setIMacCategory();
        searchResultPage.clickSearchButton();
    }

    @And("press key Enter")
    public void pressKeyEnter() {
        SearchFragment searchFragment = new SearchFragment();
        searchFragment.performSearchByPressingEnter();
    }

    @Then("Incorrect message is appeared")
    public void incorrectMessageIsAppeared() {
        SearchResultPage searchResultPage = new SearchResultPage();
        Assert.assertEquals(searchResultPage.getIncorrectSearchCriteriaMessage(), "There is no product that matches the search criteria.");
    }

    @Then("Product was found")
    public void productWasFound() {
        SearchResultPage searchResultPage = new SearchResultPage();
        List<SearchResultFragment> searchResults = searchResultPage.getAllSearchResults();
        List<String> productNames = new ArrayList<>();
        for (SearchResultFragment searchResult : searchResults) {
            productNames.add(searchResult.getName());
        }
        String expectedResult = "iPod Classic";
        Assert.assertEquals(productNames.get(0), expectedResult,
                expectedResult + " wasn't found in search result.");
    }

    @Then("Product {string} was found")
    public void productWasFound(String expectedResult) {
        SearchResultPage searchResultPage = new SearchResultPage();
        List<SearchResultFragment> searchResults = searchResultPage.getAllSearchResults();
        List<String> productNames = new ArrayList<>();
        for (SearchResultFragment searchResult : searchResults) {
            productNames.add(searchResult.getName());
        }
        Assert.assertEquals(productNames.get(0), expectedResult,
                expectedResult + " wasn't found in search result.");
    }
}
